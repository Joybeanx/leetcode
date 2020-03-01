package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/3sum/">3Sum</a>
 *
 * @author Joybean
 */
public class ThreeSum {

    /**
     * Time exceed limit
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {
                List<Integer> list;
                if ((list = map.remove(nums[j])) != null) {
                    list.add(nums[j]);
                    list.sort(Comparator.naturalOrder());
                    if (!result.contains(list)) {
                        result.add(list);
                    }
                }
                List<Integer> elements = new ArrayList<>();
                elements.add(nums[i]);
                elements.add(nums[j]);
                map.put(-(nums[i] + nums[j]), elements);
            }
        }
        return result;
    }

    /**
     * Sort and Two pointers
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // Skip equal elements to avoid duplicates
            if (i - 1 >= 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            // Two Pointers
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // Skip equal elements to avoid duplicates
                    while (left + 1 < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // Skip equal elements to avoid duplicates
                    while (right - 1 > left && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}