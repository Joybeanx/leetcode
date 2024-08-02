package com.joybean.leetcode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/permutations-ii/">Permutations II</a>
 *
 * @author Joybean
 */
public class PermutationsII {
    /**
     * <a href="https://leetcode.com/problems/permutations-ii/editorial/">Backtracking with Groups of Numbers</a>
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> permuteUnique1(int[] nums) {
        Map<Integer, Integer> uniqueNums = new HashMap<>();
        for (int num : nums) {
            Integer count = uniqueNums.get(num);
            if (count == null) {
                uniqueNums.put(num, 1);
            } else {
                uniqueNums.put(num, count + 1);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        //LinkedList is much better than ArrayList
        LinkedList<Integer> curPath = new LinkedList<>();
        backtrack1(curPath, uniqueNums, nums.length, ans);
        return ans;
    }

    private static void backtrack1(LinkedList<Integer> curPath, Map<Integer, Integer> uniqueNums, int n,
                                   List<List<Integer>> ans) {
        if (curPath.size() == n) {
            ans.add(new ArrayList<>(curPath));
        }
        //A key insight to avoid generating any redundant permutation is that at each step rather than viewing each
        // number as a candidate, we consider each unique number as the true candidate.
        for (Integer num : uniqueNums.keySet()) {
            Integer count = uniqueNums.get(num);
            if (count == null) {
                continue;
            }
            uniqueNums.put(num, count - 1);
            curPath.add(num);
            backtrack1(curPath, uniqueNums, n, ans);
            uniqueNums.put(num, count);
            curPath.removeLast();
        }
    }

    public static List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] counter = new int[21];
        Set<Integer> uniqueNums = new HashSet<>();
        for (int num : nums) {
            counter[num + 10]++;
            if (!uniqueNums.contains(num)) {
                uniqueNums.add(num);
            }
        }
        backtrack2(new ArrayList<>(), uniqueNums, counter, nums.length, ans);
        return ans;
    }

    private static void backtrack2(List<Integer> curPath, Set<Integer> uniqueNums, int[] counter, int n,
                                   List<List<Integer>> ans) {
        if (curPath.size() == n) {
            ans.add(new ArrayList<>(curPath));
            return;
        }
        //A key insight to avoid generating any redundant permutation is that at each step rather than viewing each
        // number as a candidate, we consider each unique number as the true candidate.
        for (int num : uniqueNums) {
            if (counter[num + 10] == 0) {
                continue;
            }
            curPath.add(num);
            counter[num + 10]--;
            backtrack2(curPath, uniqueNums, counter, n, ans);
            curPath.remove(curPath.size() - 1);
            counter[num + 10]++;
        }
    }

    /**
     * <a href="https://leetcode.com/problems/permutations-ii/solutions/18594/really-easy-java-solution-much-easier
     * -than-the-solutions-with-very-high-vote/">backtracking with visited array</a>
     * TODO
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> permuteUnique3(int[] nums) {
        return null;
    }
}
