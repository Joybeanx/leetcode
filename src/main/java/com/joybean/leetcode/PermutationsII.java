package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/permutations-ii/">Permutations II</a>
 *
 * @author Joybean
 */
public class PermutationsII {
    /**
     * backtracking
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> permuteUnique1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] count = new int[21];
        List<Integer> uniqueNums = new ArrayList<>();
        for (int num : nums) {
            count[num + 10]++;
            if (!uniqueNums.contains(num)) {
                uniqueNums.add(num);
            }
        }
        backtrack1(uniqueNums, nums.length, new ArrayList<>(), count, ans);
        return ans;
    }

    private static void backtrack1(List<Integer> nums, int k, List<Integer> curPath, int[] count,
        List<List<Integer>> ans) {
        if (curPath.size() == k) {
            ans.add(new ArrayList<>(curPath));
            return;
        }
        for (int num : nums) {
            if (count[num + 10] == 0) {
                continue;
            }
            curPath.add(num);
            count[num + 10]--;
            backtrack1(nums, k, curPath, count, ans);
            curPath.remove(curPath.size() - 1);
            count[num + 10]++;
        }
    }

    /**
     * <a href="https://leetcode.com/problems/permutations-ii/solution/">backtracking</a>
     * TODO
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> permuteUnique2(int[] nums) {
        return null;
    }
}
