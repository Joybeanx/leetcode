package com.joybean.oj.leetcode;


import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * <a href="https://leetcode.com/problems/two-sum/description/">Two Sum</a>
 *
 * @author Jobean
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int another = target - nums[i];
            if (map.containsKey(another) && i != map.get(another)) {
                return new int[]{i, map.get(another)};
            }
        }
        throw new RuntimeException("no solution.");
    }

    public static int[] _twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}