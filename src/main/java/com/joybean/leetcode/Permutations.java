package com.joybean.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.com/problems/permutations/">Permutations</a>
 *
 * @author Joybean
 */
public class Permutations {
    /**
     * backtracking using LinkedHashSet
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack1(new LinkedHashSet<>(), nums, ans);
        return ans;
    }

    private static void backtrack1(LinkedHashSet<Integer> curPath, int[] nums, List<List<Integer>> ans) {
        if (curPath.size() == nums.length) {
            ans.add(new ArrayList<>(curPath));
            return;
        }
        for (int num : nums) {
            if (curPath.contains(num)) {
                continue;
            }
            curPath.add(num);
            backtrack1(curPath, nums, ans);
            curPath.remove(curPath.size() - 1);
        }
    }

    /**
     * backtracking based on swap
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack2(new LinkedList<>(), 0, nums, ans);
        return ans;
    }

    private static void backtrack2(LinkedList<Integer> curPath, int startIdx, int[] nums, List<List<Integer>> ans) {
        if (curPath.size() == nums.length) {
            ans.add(new ArrayList<>(curPath));
            return;
        }
        for (int i = startIdx; i < nums.length; i++) {
            swap(startIdx, i, nums);
            curPath.add(nums[startIdx]);
            backtrack2(curPath, startIdx + 1, nums, ans);
            curPath.removeLast();
            swap(startIdx, i, nums);
        }
    }

    private static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    /**
     * <a href="https://leetcode.cn/problems/permutations/solutions/2363882/46-quan-pai-lie-hui-su-qing-xi-tu-jie-by-6o7h/">Optimized backtracking based on swap</a>
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute3(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        backtrack3(0, numList, ans);
        return ans;
    }

    private static void backtrack3(int startIdx, List<Integer> nums,
                                   List<List<Integer>> ans) {
        if (startIdx == nums.size()) {
            ans.add(new ArrayList<>(nums));
            return;
        }
        for (int i = startIdx; i < nums.size(); i++) {
            swap(startIdx, i, nums);
            backtrack3(startIdx + 1, nums, ans);
            swap(startIdx, i, nums);
        }
    }

    private static void swap(int i, int j, List<Integer> nums) {
        int tmp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, tmp);
    }

    /**
     * <a href="https://leetcode.com/problems/permutations/solutions/18255/share-my-short-iterative-java-solution/">Iterative solution</a>
     * TODO
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute4(int[] nums) {
        return null;
    }
}
