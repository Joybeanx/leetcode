package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/divide-chocolate/">Divide Chocolate</a>
 *
 * @author Joybean
 */
public class DivideChocolate {
    /**
     * <a href="https://www.lintcode.com/problem/divide-chocolate/description">Binary search</a>
     */
    public static int maximizeSweetness1(int[] sweetness, int k) {
        int left = Integer.MAX_VALUE;
        int right = 0;
        for (int s : sweetness) {
            left = Math.min(s, left);
            right += s;
        }
        //answer must be less than or equal to average
        right = right / (k + 1);
        //search range[left,right)
        while (left < right) {
            int mid = (left + right + 1) >>> 1;
            if (isFeasible(sweetness, mid, k + 1)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private static boolean isFeasible(int[] sweetness, int mid, int target) {
        int pieces = 0;
        int cur = 0;
        //count number of pieces whose sweetness is greater than mid
        for (int s : sweetness) {
            cur += s;
            if (cur >= mid) {
                pieces++;
                cur = 0;
                if (pieces >= target) {
                    return true;
                }
            }
        }
        return false;
    }
}
