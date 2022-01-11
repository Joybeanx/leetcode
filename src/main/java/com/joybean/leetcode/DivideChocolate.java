package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/divide-chocolate/">Divide Chocolate</a>
 *
 * @author Joybean
 */
public class DivideChocolate {
    /**
     * <a href="https://coordinate.blog.csdn.net/article/details/102646247">Binary search</a>
     */
    public static int maximizeSweetness1(int[] sweetness, int k) {
        int left = Integer.MAX_VALUE;
        int right = 0;
        for (int s : sweetness) {
            left = Math.min(s, left);
            right += s;
        }
        //search range[left,right)
        while (left < right) {
            int mid = (left + right + 1) >>> 1;
            int cuts = 0;
            int cur = 0;
            for (int s : sweetness) {
                cur += s;
                if (cur >= mid) {
                    cuts++;
                    cur = 0;
                }
            }
            if (cuts <= k) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }
}
