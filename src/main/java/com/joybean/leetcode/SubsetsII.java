package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
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
        backtrack1(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    private static void backtrack1(int[] nums, int startIndex, List<Integer> curPath, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(curPath));
        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i - 1]) {
                continue;
            }
            curPath.add(nums[i]);
            backtrack1(nums, i + 1, curPath, ans);
            curPath.remove(curPath.size() - 1);
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
