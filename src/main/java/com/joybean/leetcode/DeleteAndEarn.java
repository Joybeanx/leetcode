package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/delete-and-earn/">Delete and Earn</a>
 *
 * @author Joybean
 */
public class DeleteAndEarn {
    /**
     * Iterative(bottom-up) DP
     *
     * @param nums
     * @return
     */
    public static int deleteAndEarn1(int[] nums) {
        int n = 10001;
        int[] counter = new int[n];
        for (int num : nums) {
            counter[num]++;
        }
        //dp[i][0] represents maximum points when we skip number i
        //dp[i][1] represents maximum points when we take number i
        int[][] dp = new int[n][2];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            //not necessary
            //if (counter[i] == 0) {
            //    continue;
            //}
            dp[i][1] = dp[i - 1][0] + counter[i] * i;
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    /**
     * <a href="https://leetcode.com/problems/delete-and-earn/discuss/109895/JavaC%2B%2B-Clean-Code-with-Explanation">Iterative(bottom-up) DP with state compression</a>
     *
     * @param nums
     * @return
     */
    public static int deleteAndEarn2(int[] nums) {
        int n = 10001;
        //use sum instead of count
        int[] sum = new int[n];
        for (int num : nums) {
            sum[num] += num;
        }
        int take = 0, skip = 0;
        for (int i = 0; i < n; i++) {
            //maximum points from 0 to i, while you take i.
            int takei = skip + sum[i];
            //maximum points from 0 to i, while you skip i.
            int skipi = Math.max(skip, take);
            take = takei;
            skip = skipi;
        }
        return Math.max(take, skip);
    }


    /**
     * <a href="https://leetcode.com/problems/delete-and-earn/discuss/109891/Sharing-my-Simple-Straight-Forward-Java-O(n)-Solution-Explanation-Included">Iterative(bottom-up) DP</a>
     *
     * @param nums
     * @return
     */
    public static int deleteAndEarn3(int[] nums) {
        int n = 10001;
        //use sum instead of count
        int[] sum = new int[n];
        for (int num : nums) {
            sum[num] += num;
        }
        //dp[i] represents maximum points of sum[0..i-2]
        int[] dp = new int[n + 2];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 2] + sum[i - 2], dp[i - 1]);
        }
        return dp[n + 1];
    }


    public static void main(String[] args) {
        System.out.println(deleteAndEarn1(new int[]{3, 1}));
        System.out.println(deleteAndEarn1(new int[]{3, 4, 2}));
        System.out.println(deleteAndEarn1(new int[]{2, 2, 3, 3, 3, 4}));
    }
}
