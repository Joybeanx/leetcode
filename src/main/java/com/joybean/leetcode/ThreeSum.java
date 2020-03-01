package com.joybean.leetcode;

import java.util.ArrayList;
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
}