package com.joybean.oj.leetcode;


import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Two Sum
 * <p>Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>You may assume that each input would have exactly one solution.
 * <p>Example:
 * <pre class="code">
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * </pre>
 *
 * @author Jobean
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
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

    public int[] _twoSum(int[] nums, int target) {
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

/*
在一个村庄中有m户居民，打算雇佣n个工人，挨家挨户地询问并且记录下各家的门牌号和能提供的工人数量，那么最多询问m次就可以找到两家并且其提供的工人数量之和恰好为n
*/
