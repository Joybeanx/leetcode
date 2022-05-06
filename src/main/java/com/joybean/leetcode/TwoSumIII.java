package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/two-sum-iii-data-structure-design/">Two Sum III</a>
 *
 * @author Joybean
 */
public class TwoSumIII {
    private List<Integer> nums = new ArrayList<>();
    private Set<Integer> twoSums = new HashSet<>();

    /**
     * https://www.lintcode.com/problem/607/
     *
     * Add the number to an internal data structure.
     *
     * @param number
     */
    public void add(int number) {
        for (Integer each : nums) {
            twoSums.add(each + number);
        }
        nums.add(number);
    }

    /**
     * Find if there exists any pair of numbers which sum is equal to the value.
     *
     * @param value
     * @return
     */
    public boolean find(int value) {
        return twoSums.contains(value);
    }
}
