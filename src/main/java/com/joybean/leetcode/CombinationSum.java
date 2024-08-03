package com.joybean.leetcode;

import java.util.*;
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
        backtrack1(new LinkedList<>(), 0, candidates, target, ans);
        return ans;
    }

    private static void backtrack1(LinkedList<Integer> curPath, int startIndex, int[] candidates, int target,
                                   List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(curPath));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            curPath.add(candidates[i]);
            backtrack1(curPath, i, candidates, target - candidates[i], ans);
            curPath.removeLast();
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
        //sort candidates for pruning
        Arrays.sort(candidates);
        backtrack2(new LinkedList<>(), 0, candidates, target, ans);
        return ans;
    }

    private static void backtrack2(LinkedList<Integer> curPath, int startIndex, int[] candidates, int target,
                                   List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(curPath));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            int newTarget = target - candidates[i];
            //pruning
            if (newTarget < 0) {
                break;
            }
            curPath.add(candidates[i]);
            backtrack2(curPath, i, candidates, newTarget, ans);
            curPath.removeLast();
        }
    }

    /**
     * <a href="https://leetcode.com/problems/combination-sum/solutions/16509/iterative-java-dp-solution/">Iterative
     * (bottom-up) DP</a>
     * TODO
     *
     * @param candidates
     * @param target
     * @return
     */
    public static List<List<Integer>> combinationSum4(int[] candidates, int target) {
        return null;
    }

}
