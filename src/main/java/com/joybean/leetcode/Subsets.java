package com.joybean.leetcode;

import java.util.*;
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
     * Iterative solution
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            for (List<Integer> subset : new ArrayList<>(ans)) {
                List<Integer> newSubset = new ArrayList<>(subset);
                newSubset.add(nums[i]);
                ans.add(newSubset);
            }
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/subsets/discuss/122645/3ms-easiest-solution-no-backtracking-no-bit
     * -manipulation-no-dfs-no-bullshit">Optimized iterative solution</a>
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets3(int[] nums) {
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
    public static List<List<Integer>> subsets4(int[] nums) {
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
    public List<List<Integer>> subsets5(int[] nums) {
        int max_res = 1 << nums.length;
        List<List<Integer>> answer = new LinkedList<>();
        for (int i = 0; i < max_res; i++) {
            List<Integer> subset = new LinkedList<>();
            for (int bit = 0; bit < nums.length; bit++) {
                if (((i >> bit) & 1) == 1) {
                    subset.add(nums[bit]);
                }
            }
            answer.add(subset);
        }

        return answer;
    }


    /**
     * backtracking
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets6(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        subsets(new HashSet<>(), 0, nums, ans);
        return ans;
    }

    private void subsets(Set<Integer> curPath, int startIdx, int[] nums, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(curPath));
        for (int i = startIdx; i < nums.length; i++) {
            if (curPath.contains(nums[i])) {
                continue;
            }
            curPath.add(nums[i]);
            subsets(curPath, i, nums, ans);
            curPath.remove(nums[i]);
        }
    }

    /**
     * <a href="https://leetcode.com/problems/subsets/solution/">backtracking</a>
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets7(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack2(new LinkedList<>(), 0, nums, ans);
        return ans;
    }

    private static void backtrack2(LinkedList<Integer> curPath, int start, int[] nums, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(curPath));
        for (int i = start; i < nums.length; i++) {
            curPath.add(nums[i]);
            backtrack2(curPath, i + 1, nums, ans);
            curPath.removeLast();
        }
    }

}
