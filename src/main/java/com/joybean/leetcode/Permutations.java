package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/permutations/">Permutations</a>
 *
 * @author Joybean
 */
public class Permutations {
    /**
     * backtracking
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, nums, new ArrayList<>());
        return ans;
    }

    private static void backtrack(List<List<Integer>> ans, int[] nums, List<Integer> curPath) {
        if (curPath.size() == nums.length) {
            ans.add(new ArrayList<>(curPath));
            return;
        }
        for (int num : nums) {
            if (curPath.contains(num)) {
                continue;
            }
            curPath.add(num);
            backtrack(ans, nums, curPath);
            curPath.remove(curPath.size() - 1);
        }
    }

    /**
     * <a href="https://leetcode.cn/problems/permutations/solutions/2363882/46-quan-pai-lie-hui-su-qing-xi-tu-jie-by-6o7h/?envType=problem-list-v2&envId=2cktkvj">Optimized backtracking using swap</a>
     * TODO
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute2(int[] nums) {
        return null;
    }

    /**
     * <a href="https://leetcode.com/problems/permutations/solutions/18255/share-my-short-iterative-java-solution/">Iterative solution</a>
     * TODO
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute3(int[] nums) {
        return null;
    }
}
