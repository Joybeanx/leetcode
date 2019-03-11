package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * <a href="https://leetcode.com/problems/combination-sum/">Combination Sum</a>
 *
 * @author Joybean
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return findSubList(candidates, target, 0);
    }

    public List<List<Integer>> findSubList(int[] candidates, int target, int startIdx) {
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

    private List<Integer> curList(int candidate, int n) {
        return IntStream.range(0, n).map(t -> candidate).mapToObj(Integer::valueOf).collect(Collectors.toList());
    }
}
