package com.joybean.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/target-sum/">Target Sum</a>
 *
 * @author Joybean
 */
public class TargetSum {
    /**
     * <a href="https://leetcode.cn/problems/target-sum/solutions/816361/mu-biao-he-by-leetcode-solution-o0cp
     * /?envType=problem-list-v2&envId=2cktkvj">Iterative(bottom-up) DP using two-dimensional array</a>
     *
     * @param nums
     * @param target
     * @return
     * @see PartitionEqualSubsetSum
     */
    public static int findTargetSumWays1(int[] nums, int target) {
        //p is num before which add '+'
        //q is num before which add '-'
        //because: p + q = sum, p - q = target
        //so: q = (sum - target)/2
        //the problem become find a subset of nums q such that q =  (sum - target)/2
        int sum = Arrays.stream(nums).sum();

        if (sum < target || (sum - target) % 2 == 1) {
            return 0;
        }

        target = (sum - target) / 2;
        int n = nums.length;
        int dp[][] = new int[n + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            //j must start from 0 instead of nums[i-1], case: nums = [0,0,0,0,0,0,0,0,1], target=1
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][target];
    }

    /**
     * Iterative(bottom-up) DP with state compression
     *
     * @param nums
     * @param target
     * @return
     * @see PartitionEqualSubsetSum
     */
    public static int findTargetSumWays2(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if (((sum + target) & 1) != 0) {
            return 0;
        }
        target = (sum + target) / 2;
        //dp[j] represents ways that make the sum of nums be j
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = target; j >= 0; j--) {
                int k = j - nums[i - 1];
                if (k >= 0) {
                    dp[j] = dp[k] + dp[j];
                }
            }
        }
        return dp[target];
    }

    /**
     * backtracking
     *
     * @param nums
     * @param target
     * @return
     */
    public static int findTargetSumWays3(int[] nums, int target) {
        return backTrack1(0, target, nums);

    }

    private static int backTrack1(int from, int target, int[] nums) {
        //base case,urgly
        //if (from == nums.length - 1) {
        //    if (target == 0 && nums[from] == 0) {
        //        return 2;
        //    }
        //    if (target == nums[from] || target == -nums[from]) {
        //          return 1;
        //     }
        //     return 0;
        //  }
        //base case,more elegant
        if (from == nums.length) {
            if (target == 0) {
                return 1;
            }
            return 0;
        }
        int cnt = 0;
        cnt += backTrack1(from + 1, target + nums[from], nums);
        cnt += backTrack1(from + 1, target - nums[from], nums);
        return cnt;
    }

    /**
     * backtracking with memo
     *
     * @param nums
     * @param target
     * @return
     */
    public static int findTargetSumWays5(int[] nums, int target) {
        int n = nums.length;
        //because: 0 <= sum(nums[i]) <= 1000 && -1000 <= target <= 1000
        //so: -1000 <= target + sum <= 2000, -2000 <= target - sum <= 1000
        //so: -2000 <= ongoing target <= 2000
        //we should shift 2000 to ensure array index is positive
        int[][] memo = new int[n][4001];
        return backtrack2(n - 1, target, nums, memo);

    }

    private static int backtrack2(int endIdx, int target, int[] nums, int[][] memo) {
        if (endIdx < 0) {
            if (target == 0) {
                return 1;
            }
            return 0;
        }
        if (memo[endIdx][target + 2000] != 0) {
            return memo[endIdx][target + 2000];
        }
        int ans = backtrack2(endIdx - 1, target - nums[endIdx], nums, memo) + backtrack2(endIdx - 1,
            target + nums[endIdx], nums, memo);
        memo[endIdx][target + 2000] = ans;
        return ans;
    }

    /**
     * <a
     * href="https://leetcode.com/problems/target-sum/solutions/169648/java-dfs-memorization-with-explanations
     * /">backtracking with memo</a>
     *
     * @param nums
     * @param target
     * @return
     */
    public static int findTargetSumWays4(int[] nums, int target) {
        return backtrack3(0, target, nums, new HashMap<>());

    }

    private static int backtrack3(int from, int target, int[] nums, Map<List<Integer>, Integer> memo) {
        //base case
        if (from == nums.length) {
            if (target == 0) {
                return 1;
            }
            return 0;
        }
        List<Integer> key = Arrays.asList(target, from);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int cnt = 0;
        cnt += backtrack3(from + 1, target + nums[from], nums, memo);
        cnt += backtrack3(from + 1, target - nums[from], nums, memo);
        memo.put(key, cnt);
        return cnt;
    }

}
