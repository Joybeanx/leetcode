package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
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
     * While iterating through all numbers, for each new number, we can either pick it or not pick it
     * <ol>
     * <li>if pick, just add current number to every existing subset.</li>
     * <li>if not pick, just leave all existing subsets as they are.</li>
     * We just combine both into our result.
     * </ol>
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
     * Bit manipulation
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets3(int[] nums) {
        int max_res = 1 << nums.length;
        List<List<Integer>> answer = new LinkedList<>();
        for (int i = 0; i < max_res; i++) {
            List<Integer> subset = new LinkedList<>();
            for (int bit = 0; bit < nums.length; bit++) {
                if (((i >> bit) & 1) == 1) subset.add(nums[bit]);
            }
            answer.add(subset);
        }

        return answer;
    }

    public List<List<Integer>> subsets4(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }


}
