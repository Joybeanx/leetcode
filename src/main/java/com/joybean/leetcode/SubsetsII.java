package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/subsets-ii/">Subsets II</a>
 *
 * @author Joybean
 */
public class SubsetsII {
    /**
     * backtracking
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsetsWithDup1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backtrack1(new LinkedList<>(), 0, nums, ans);
        return ans;
    }

    private static void backtrack1(LinkedList<Integer> curPath, int startIdx, int[] nums, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(curPath));
        for (int i = startIdx; i < nums.length; i++) {
            if (i != startIdx && nums[i] == nums[i - 1]) {
                continue;
            }
            curPath.add(nums[i]);
            backtrack1(curPath, startIdx + 1, nums, ans);
            curPath.removeLast();
        }
    }

    /**
     * <a href="https://leetcode.com/problems/subsets-ii/discuss/169226/Java-Two-Way-of-Recursive-thinking">backtracking</a>
     * TODO
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsetsWithDup2(int[] nums) {
        return null;
    }

    /**
     * <a href="https://leetcode.com/problems/subsets-ii/discuss/30137/Simple-iterative-solution">iterative solution</a>
     * TODO
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsetsWithDup3(int[] nums) {
        return null;
    }



}
