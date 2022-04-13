package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/combinations/">Combinations</a>
 *
 * @author Joybean
 */
public class Combinations {
    /**
     * backtracking
     *
     * @param n
     * @param k
     * @return
     */
    public static List<List<Integer>> combine1(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, n, k, 1, new ArrayList<>());
        return ans;
    }

    private static void backtrack(List<List<Integer>> ans, int n, int k, int start, List<Integer> curPath) {
        if (curPath.size() == k) {
            ans.add(new ArrayList<>(curPath));
            return;
        }
        //Pruning, better than cur <= n
        for (int cur = start; cur <= n - (k - curPath.size()) + 1; cur++) {
            curPath.add(cur);
            backtrack(ans, n, k, cur + 1, curPath);
            curPath.remove(curPath.size() - 1);
        }
    }

    /**
     * Iterative solution
     * TODO
     *
     * @param n
     * @param k
     * @return
     */
    public static List<List<Integer>> combine2(int n, int k) {
        return null;
    }

    /**
     * Recursive solution
     * TODO
     *
     * @param n
     * @param k
     * @return
     */
    public static List<List<Integer>> combine3(int n, int k) {
        return null;
    }
}
