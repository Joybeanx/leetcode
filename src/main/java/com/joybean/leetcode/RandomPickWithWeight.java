package com.joybean.leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * <a href="https://leetcode.com/problems/random-pick-with-weight/">Random Pick with Weight</a>
 *
 * @author Joybean
 */
public class RandomPickWithWeight {
    private static double[] prefixSum;
    private static Random random = new Random();

    public RandomPickWithWeight(int[] w) {
        prefixSum = new double[w.length];
        double total = Arrays.stream(w).sum();
        prefixSum[0] = w[0] / total;
        int curSum = w[0];
        for (int i = 1; i < prefixSum.length; i++) {
            curSum += w[i];
            prefixSum[i] = curSum / total;
        }
    }

    public static int pickIndex() {
        double target = random.nextDouble();
        int left = 0;
        int right = prefixSum.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (prefixSum[mid] == target) {
                return mid;
            }
            if (prefixSum[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
