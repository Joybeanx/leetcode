package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/combination-sum-iii/">Combination Sum III</a>
 *
 * @author Joybean
 */
public class CombinationSumIII {
    /**
     * backtracking
     *
     * @param k
     * @param n
     * @return
     */
    public static List<List<Integer>> combinationSum1(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack1(k, n, 1, new ArrayList<>(), ans);
        return ans;
    }

    private static void backtrack1(int k, int target, int start, List<Integer> curPath, List<List<Integer>> ans) {
        if (curPath.size() == k) {
            if (target == 0) {
                ans.add(new ArrayList<>(curPath));
            }
            return;
        }

        for (int cur = start; cur <= 9; cur++) {
            int newTarget = target - cur;
            //pruning
            if (curPath.size() == k - 1 && newTarget < 0) {
                break;
            }
            curPath.add(cur);
            backtrack1(k, newTarget, cur + 1, curPath, ans);
            curPath.remove(curPath.size() - 1);
        }
    }
}
