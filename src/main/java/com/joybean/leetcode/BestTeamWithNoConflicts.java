package com.joybean.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * <a href="https://leetcode.com/problems/best-team-with-no-conflicts/">Best Team With No Conflicts</a>
 *
 * @author Joybean
 */
public class BestTeamWithNoConflicts {
    /**
     * Iterative(bottom-up) DP
     *
     * @param scores
     * @param ages
     * @return
     */
    public static int bestTeamScore1(int[] scores, int[] ages) {
        int ans = 0;
        int n = scores.length;
        Integer[] sortedIndex = IntStream.range(0, n).boxed().toArray(Integer[]::new);
        Arrays.sort(sortedIndex, (a, b) -> ages[a] != ages[b] ? ages[a] - ages[b] : scores[a] - scores[b]);
        int[] sortedScores = new int[n];
        int[] sortedAges = new int[n];
        for (int i = 0; i < n; i++) {
            sortedScores[i] = scores[sortedIndex[i]];
            sortedAges[i] = ages[sortedIndex[i]];
        }
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = sortedScores[i];
            for (int j = 0; j < i; j++) {
                if (sortedScores[j] <= sortedScores[i]) {
                    dp[i] = Math.max(dp[j] + sortedScores[i], dp[i]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/best-team-with-no-conflicts/discuss/899475/Fairly-easy-DP">Concise iterative(bottom-up) DP</a>
     *
     * @param scores
     * @param ages
     * @return
     */
    public static int bestTeamScore2(int[] scores, int[] ages) {
        int ans = 0;
        int n = ages.length;
        int[][] candidate = new int[n][2];
        for (int i = 0; i < n; i++) {
            candidate[i][0] = ages[i];
            candidate[i][1] = scores[i];
        }
        Arrays.sort(candidate, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = candidate[i][1];
            for (int j = 0; j < i; j++) {
                if (candidate[j][1] <= candidate[i][1]) {
                    dp[i] = Math.max(dp[j] + candidate[i][1], dp[i]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
