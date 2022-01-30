package com.joybean.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/">Number of Submatrices That Sum to
 * Target</a>
 *
 * @author Joybean
 * @see SubarraySumEqualsK
 */
public class NumberOfSubmatricesThatSumToTarget {
    /**
     * <a href="https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/discuss/803353/Java-Solution
     * -with-Detailed-Explanation">Prefix sum</a>
     *
     * @param matrix
     * @param target
     * @return
     */
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] prefixSum = new int[m][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n + 1; j++) {
                prefixSum[i][j] = prefixSum[i][j - 1] + matrix[i][j - 1];
            }
        }
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n + 1; i++) {
            for (int j = i + 1; j < n + 1; j++) {
                map.clear();
                map.put(0, 1);
                int sum = 0;
                for (int k = 0; k < m; k++) {
                    sum += prefixSum[k][j] - prefixSum[k][i];
                    ans += map.getOrDefault(sum - target, 0);
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }
        return ans;
    }
}
