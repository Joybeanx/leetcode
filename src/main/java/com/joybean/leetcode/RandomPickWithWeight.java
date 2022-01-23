package com.joybean.leetcode;

import java.util.Random;

/**
 * <a href="https://leetcode.com/problems/random-pick-with-weight/">Random Pick with Weight</a>
 *
 * @author Joybean
 */
public class RandomPickWithWeight {
    private static int[] prefixSum;
    private static Random random;

    /**
     * Prefix sum + Binary search
     *
     * @param w
     */
    public RandomPickWithWeight(int[] w) {
        random = new Random();
        prefixSum = new int[w.length];
        prefixSum[0] = w[0];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + w[i];
        }
    }

    public static int pickIndex() {
        int length = prefixSum.length;
        int target = random.nextInt(prefixSum[length - 1]) + 1;
        int left = 0;
        int right = length - 1;
        //search range [left,right)
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
