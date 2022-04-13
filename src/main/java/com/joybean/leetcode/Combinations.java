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
        backtrack(ans, new ArrayList<>(), n, k, 1);
        return ans;
    }

    private static void backtrack(List<List<Integer>> ans, List<Integer> curPath, int n, int k, int start) {
        if (curPath.size() == k) {
            ans.add(new ArrayList<>(curPath));
            return;
        }
        //Pruning, better than cur <= n
        for (int cur = start; cur <= n - (k - curPath.size()) + 1; cur++) {
            curPath.add(cur);
            backtrack(ans, curPath, n, k, cur + 1);
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
