package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <a href="https://leetcode.com/problems/subsets/">Subsets</a>
 *
 * @author Joybean
 */
public class Subsets {
    public static List<List<Integer>> subsets1(int[] nums) {
        return IntStream.range(0, 2 << nums.length - 1).mapToObj(Integer::toBinaryString)
            .map(bs -> buildSubset(bs, nums))
            .collect(Collectors.toList());
    }

    private static List<Integer> buildSubset(String bs, int[] nums) {
        List<Integer> list = new ArrayList<>();
        int gap = nums.length - bs.length();
        for (int i = 0; i < bs.length(); i++) {
            if (bs.charAt(i) == '1') {
                list.add(nums[gap + i]);
            }
        }
        return list;
    }

    /**
     * <a href="https://leetcode.com/problems/subsets/discuss/122645/3ms-easiest-solution-no-backtracking-no-bit
     * -manipulation-no-dfs-no-bullshit">Iterative solution</a>
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int n : nums) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                List<Integer> subset = new ArrayList<>(result.get(i));
                subset.add(n);
                result.add(subset);
            }
        }
        return result;
    }

    /**
     * Recursive solution
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets3(int[] nums) {
        return findSubsets(nums, nums.length - 1);
    }

    private static List<List<Integer>> findSubsets(int[] nums, int endIdx) {
        if (endIdx < 0) {
            //Note: not returning Collections.emptyList()
            return Collections.singletonList(new ArrayList<>());
        }
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> subsets = findSubsets(nums, endIdx - 1);
        result.addAll(subsets);
        for (List<Integer> subset : subsets) {
            List<Integer> newSubSet = new ArrayList<>(subset);
            newSubSet.add(nums[endIdx]);
            result.add(newSubSet);
        }
        return result;
    }

    /**
     * Bit manipulation
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets4(int[] nums) {
        int max_res = 1 << nums.length;
        List<List<Integer>> answer = new LinkedList<>();
        for (int i = 0; i < max_res; i++) {
            List<Integer> subset = new LinkedList<>();
            for (int bit = 0; bit < nums.length; bit++) {
                if (((i >> bit) & 1) == 1) {subset.add(nums[bit]);}
            }
            answer.add(subset);
        }

        return answer;
    }

    /**
     * <a href="https://leetcode.com/problems/subsets/solution/">backtracking</a>
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets5(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    private static void backtrack(int[] nums, int start, List<Integer> curPath, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(curPath));
        for (int i = start; i < nums.length; i++) {
            curPath.add(nums[i]);
            backtrack(nums, i + 1, curPath, ans);
            curPath.remove(curPath.size() - 1);
        }
    }

}
