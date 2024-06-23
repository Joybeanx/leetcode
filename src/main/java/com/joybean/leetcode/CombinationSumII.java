package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/combination-sum-ii/">Combination Sum II</a>
 *
 * @author Joybean
 */
public class CombinationSumII {
    /**
     * backtracking:Time Limit Exceeded with 30 1s
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        //Use set to remove duplicates
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(candidates);
        backtrack1(candidates, target, 0, new ArrayList<>(), set);
        return new ArrayList<>(set);
    }

    private static void backtrack1(int[] candidates, int target, int startIndex,
        List<Integer> curPath, Set<List<Integer>> set) {
        if (target == 0 && !set.contains(curPath)) {
            set.add(new ArrayList<>(curPath));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            int newTarget = target - candidates[i];
            //pruning
            if (newTarget < 0) {
                break;
            }
            curPath.add(candidates[i]);
            backtrack1(candidates, newTarget, i + 1, curPath, set);
            curPath.remove(curPath.size() - 1);
        }
    }

    /**
     * backtracking on unique candidates
     *
     * @param candidates
     * @param target
     * @return
     */
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int[] counter = new int[51];
        for (int candidate : candidates) {
            counter[candidate]++;
        }
        List<List<Integer>> ans = new ArrayList<>();
        backtrack2(new LinkedList<>(), 0, target, counter, ans);
        return ans;
    }

    private static void backtrack2(LinkedList<Integer> curPath, int startIdx, int target,
        int[] counter, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(curPath));
            return;
        }
        for (int i = startIdx; i < counter.length; i++) {
            if (counter[i] == 0) {
                continue;
            }
            int newTarget = target - i;
            // pruning
            if (newTarget < 0) {
                continue;
            }
            curPath.add(i);
            counter[i]--;
            //or combinationSum4(curPath, counter[i] == 0 ? i + 1 : i, newTarget, counter, ans);
            backtrack2(curPath, i, newTarget, counter, ans);
            counter[i]++;
            curPath.removeLast();
        }
    }

    /**
     * backtracking on unique candidate
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum3(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] count = new int[51];
        List<Integer> uniqueCandidates = new ArrayList<>();
        for (int candidate : candidates) {
            count[candidate]++;
            if (!uniqueCandidates.contains(candidate)) {
                uniqueCandidates.add(candidate);
            }
        }
        backtrack3(uniqueCandidates, target, 0, new ArrayList<>(), count, ans);
        return ans;
    }

    private static void backtrack3(List<Integer> candidates, int target, int startIndex,
        List<Integer> curPath, int[] remainingCount, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(curPath));
            return;
        }
        for (int i = startIndex; i < candidates.size(); i++) {
            int candidate = candidates.get(i);
            int newTarget = target - candidate;
            //pruning
            if (newTarget < 0) {
                break;
            }
            if (remainingCount[candidate] == 0) {
                continue;
            }
            curPath.add(candidate);
            remainingCount[candidate]--;
            backtrack3(candidates, newTarget, i, curPath, remainingCount, ans);
            curPath.remove(curPath.size() - 1);
            remainingCount[candidate]++;
        }
    }

    /**
     * <a href="https://leetcode.com/problems/combination-sum-ii/discuss/16861/Java-solution-using-dfs-easy-understand
     * ">Skip duplicates</a>
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum4(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack4(new ArrayList<>(), 0, target, candidates, ans);
        return ans;
    }

    private static void backtrack4(List<Integer> curPath, int startIndex, int target, int[] candidates,
        List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(curPath));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            //we only use candidate in startIndex, skip subsequent duplicates
            if (i > startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            int newTarget = target - candidates[i];
            //pruning
            if (newTarget < 0) {
                break;
            }
            curPath.add(candidates[i]);
            backtrack4(curPath, i + 1, newTarget, candidates, ans);
            curPath.remove(curPath.size() - 1);
        }
    }


}
