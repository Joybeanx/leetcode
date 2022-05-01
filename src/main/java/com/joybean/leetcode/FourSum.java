package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/4sum/">4Sum</a>
 *
 * @author Joybean
 */
public class FourSum {
    /**
     * Two pointers
     *
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum1(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                int twoSum = nums[i] + nums[j];
                while (left < right) {
                    int sum = twoSum + nums[left] + nums[right];
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
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
            }
        }
        return ans;
    }

    /**
     * Use KSum template
     *
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum2(int[] nums, int target) {
        return KSum.kSum(nums, 4, target);
    }
}
