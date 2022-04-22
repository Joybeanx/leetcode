package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <a href="https://leetcode.com/problems/combination-sum/">Combination Sum</a>
 *
 * @author Joybean
 */
public class CombinationSum {
    public static List<List<Integer>> combinationSum1(int[] candidates, int target) {
        return findSubList(candidates, target, 0);
    }

    public static List<List<Integer>> findSubList(int[] candidates, int target, int startIdx) {
        if (startIdx == candidates.length) {
            return Collections.EMPTY_LIST;
        }
        int i = 0;
        int nextTarget = 0;
        List<List<Integer>> lists = new ArrayList<>();
        int cur = 0;
        while ((nextTarget = target - cur) >= 0) {
            if (cur == target) {
                lists.add(curList(candidates[startIdx], i));
            } else {
                List<List<Integer>> subLists = findSubList(candidates, nextTarget, startIdx + 1);
                if (!subLists.isEmpty()) {
                    for (List<Integer> sublist : subLists) {
                        sublist.addAll(curList(candidates[startIdx], i));
                    }
                    lists.addAll(subLists);
                }
            }
            cur = (++i) * candidates[startIdx];
        }
        return lists;
    }

    private static List<Integer> curList(int candidate, int n) {
        return IntStream.range(0, n).map(t -> candidate).mapToObj(Integer::valueOf).collect(Collectors.toList());
    }

    /**
     * backtracking
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(candidates, target, 0, 0, new ArrayList<>(), ans);
        return ans;
    }

    private static void backtrack(int[] candidates, int target, int startIndex, int curSum, List<Integer> curPath,
        List<List<Integer>> ans) {
        if (curSum == target) {
            ans.add(new ArrayList<>(curPath));
            return;
        }
        if (curSum > target) {
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            curPath.add(candidates[i]);
            backtrack(candidates, target, i, curSum + candidates[i], curPath, ans);
            curPath.remove(curPath.size() - 1);
        }
    }

    /**
     * backtracking with pruning
     *
     * @param candidates
     * @param target
     * @return
     */
    public static List<List<Integer>> combinationSum3(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack2(candidates, target, 0, 0, new ArrayList<>(), ans);
        return ans;
    }

    private static void backtrack2(int[] candidates, int target, int startIndex, int curSum, List<Integer> curPath,
        List<List<Integer>> ans) {
        if (curSum == target) {
            ans.add(new ArrayList<>(curPath));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            int newSum = curSum + candidates[i];
            //pruning
            if (newSum > target) {
                break;
            }
            curPath.add(candidates[i]);
            backtrack2(candidates, target, i, newSum, curPath, ans);
            curPath.remove(curPath.size() - 1);
        }
    }
}
