package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * KSum
 *
 * @author Joybean
 */
public class KSum {
    /**
     * <a href="https://leetcode.com/problems/4sum/solution/">Two pointers</a>
     *
     * @param nums
     * @param k
     * @param target
     * @return
     */
    public static List<List<Integer>> kSum(int[] nums, int k, int target) {
        Arrays.sort(nums);
        return kSum(nums, 0, k, target);
    }

    public static List<List<Integer>> kSum(int[] nums, int start, int k, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int average = target / k;
        // We cannot obtain a sum of target if the smallest value
        // in nums is greater than target / k or if the largest
        // value in nums is smaller than target / k.
        if (nums[start] > average || average > nums[nums.length - 1]) {
            return ans;
        }
        if (k == 2) {
            return twoSum(nums, start, target);
        }
        for (int i = start; i < nums.length - k + 1; i++) {
            //Skip equal elements to avoid duplicates
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            for (List<Integer> list : kSum(nums, i + 1, k - 1, target - nums[i])) {
                list.add(nums[i]);
                ans.add(list);
            }
        }
        return ans;

    }

    public static List<List<Integer>> twoSum(int[] nums, int start, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int left = start;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                ans.add(Stream.of(nums[left], nums[right]).collect(Collectors.toList()));
                left++;
                right--;
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}
