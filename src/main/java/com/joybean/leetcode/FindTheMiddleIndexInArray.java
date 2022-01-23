package com.joybean.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/find-the-middle-index-in-array/">Find the Middle Index in Array</a>
 *
 * @author Joybean
 * @see FindPivotIndex
 */
public class FindTheMiddleIndexInArray {
    /**
     * <a href="https://leetcode.com/problems/find-the-middle-index-in-array/discuss/1444082/Java-5-Liner-(One-Pass)">One pass using Map</a>
     *
     * @param nums
     * @return
     */
    public static int findMiddleIndex1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int leftSum = 0;
        for (int i = 0; i < nums.length; leftSum += nums[i++]) {
            map.putIfAbsent(leftSum * 2 + nums[i], i);
        }
        return map.getOrDefault(leftSum, -1);
    }
}
