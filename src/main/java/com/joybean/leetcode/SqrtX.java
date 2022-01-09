package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/sqrtx/">Sqrt(x)</a>
 *
 * @author Joybean
 */
public class SqrtX {
    /**
     * Binary search 1
     *
     * @param x
     * @return
     */
    public static int mySqrt1(int x) {
        int left = 0;
        int right = x;
        //search range [left,right)
        while (left < right) {
            int mid = (left + right + 1) >>> 1;
            int cur = x / mid;
            if (mid == cur) {
                return mid;
            }
            if (mid > cur) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    /**
     * <a href="https://leetcode.com/problems/sqrtx/discuss/25066/Solve-this-problem-with-Binary-Search">Binary search 2</a>
     *
     * @param x
     * @return
     */
    public static int mySqrt2(int x) {
        int left = 1;
        int right = x;
        int ans = 0;
        //search range [left,right]
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (mid <= x / mid) {
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
