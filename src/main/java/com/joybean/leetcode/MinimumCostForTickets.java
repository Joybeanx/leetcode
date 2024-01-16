package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/minimum-cost-for-tickets/">Minimum Cost For Tickets</a>
 *
 * @author Joybean
 */
public class MinimumCostForTickets {
    /**
     * Iterative(bottom-up) DP
     *
     * @param days
     * @param costs
     * @return
     */
    public static int mincostTickets1(int[] days, int[] costs) {
        int n = days.length;
        //dp[i] represents the minimum cost of the travel plan for days[0..i-1]
        int[] dp = new int[n + 1];
        int minCost = Integer.MAX_VALUE;
        for (int cost : costs) {
            minCost = Math.min(cost, minCost);
        }
        for (int i = 1; i <= n; i++) {
            dp[i] = minCost + dp[i - 1];
            //find the biggest day index less than or equals to (days[i-1]-interval)
            int idx = findPrevIdx(i - 1, 7, days);
            if (idx != -1) {
                dp[i] = Math.min(costs[1] + dp[idx], dp[i]);
            }

            idx = findPrevIdx(i - 1, 30, days);
            if (idx != -1) {
                dp[i] = Math.min(costs[2] + dp[idx], dp[i]);
            }
        }
        return dp[n];
    }

    private static int findPrevIdx(int curIdx, int interval, int[] days) {
        int idx = 0;
        while (days[idx] + interval <= days[curIdx]) {
            idx++;
        }
        return idx;
    }

    /**
     * <a href="https://leetcode.com/problems/minimum-cost-for-tickets/editorial/">Iterative(bottom-up) DP</a>
     *
     * @param days
     * @param costs
     * @return
     */
    public static int mincostTickets2(int[] days, int[] costs) {
        int n = days.length;
        int lastDay = days[n - 1];
        //p[i] represents the minimum cost to travel until the ith day
        int[] dp = new int[lastDay + 1];
        int k = 0;
        for (int curDay = 1; curDay <= lastDay; curDay++) {
            if (curDay < days[k]) {
                dp[curDay] = dp[curDay - 1];
                continue;
            }
            dp[curDay] = dp[Math.max(curDay - 1, 0)] + costs[0];
            dp[curDay] = Math.min(dp[Math.max(curDay - 7, 0)] + costs[1], dp[curDay]);
            dp[curDay] = Math.min(dp[Math.max(curDay - 30, 0)] + costs[2], dp[curDay]);
            k++;
        }
        return dp[lastDay];
    }
}
