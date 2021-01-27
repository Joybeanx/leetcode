package com.joybean.leetcode;


import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * <a href="https://leetcode.com/problems/two-sum/description/">Two Sum</a>
 *
 * @author Joybean
 */
public class TwoSum {
    public static int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int another = target - nums[i];
            if (map.containsKey(another) && i != map.get(another)) {
                return new int[]{i, map.get(another)};
            }
        }
        throw new RuntimeException("No solution");
    }

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new RuntimeException("No solution");
    }
}