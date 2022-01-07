package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/find-target-indices-after-sorting-array/">Find Target Indices After Sorting
 * Array</a>
 *
 * @author Joybean
 */
public class FindTargetIndicesAfterSortingArray {
    /**
     * Sorting + Binary search
     * TODO
     *
     * @param nums
     * @param target
     * @return
     */
    public static List<Integer> targetIndices1(int[] nums, int target) {
        return null;
    }

    /**
     * Counting sort
     *
     * @param nums
     * @param target
     * @return
     */
    public static List<Integer> targetIndices2(int[] nums, int target) {
        int targetCnt = 0;
        int lessCnt = 0;
        for (int num : nums) {
            if (num == target) {
                targetCnt++;
            } else if (num < target) {
                lessCnt++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < targetCnt; i++) {
            //or ans.add(lessCnt++);
            ans.add(lessCnt + i);
        }
        return ans;
    }
}
