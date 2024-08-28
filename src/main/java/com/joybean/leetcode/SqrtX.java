package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/sqrtx/">Sqrt(x)</a>
 *
 * @author Joybean
 */
public class SqrtX {

    /**
     * Linear search 1
     *
     * @param x
     * @return
     * @see <a href="https://en.wikipedia.org/wiki/Integer_square_root">Integer Square Root</a>
     */
    public static int mySqrt1(int x) {
        //use long to avoid integer overflow when calculating i*i
        //case: x = 2147395600,  463460 * 463460 = 2147395600, 463460 * 46341 = -2147479015
        long i = 0;
        while (i * i <= x) {
            i++;
        }
        return (int) (i - 1);
    }

    /**
     * Linear search 2
     *
     * @param x
     * @return
     * @see <a href="https://en.wikipedia.org/wiki/Integer_square_root">Integer Square Root</a>
     */
    public static int mySqrt2(int x) {
        //use long to avoid integer overflow when calculating i*i
        //case: x = 2147395600,  463460 * 463460 = 2147395600, 463460 * 46341 = -2147479015
        long i = 0;
        while ((i + 1) * (i + 1) <= x) {
            i++;
        }
        return (int) i;
    }

   /*
    //wrong solution, overflow occurs when x = Integer.MAX_VALUE
    public static int mySqrt(int x) {
        int left = 0;
        int right = x + 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            long p = (long)mid * mid;
            if (p > x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }
    */

    /**
     * Binary search 1
     *
     * @param x
     * @return
     */
    public static int mySqrt3(int x) {
        int left = 0;
        int right = x;
        //search range [left,right)
        while (left < right) {
            int mid = (left + right + 1) >>> 1;
            int r = x / mid;
            if (r > mid) {
                left = mid;
            } else if (r < mid) {
                right = mid - 1;
            } else {
                return mid;
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
    public static int mySqrt4(int x) {
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

    /**
     * <a href="https://en.wikipedia.org/wiki/Newton%27s_method">Newton's method</a>
     *
     * @param x
     * @return
     */
    public static int mySqrtx5(int x) {
        if (x == 0) return 0;
        long i = x;
        while (i > x / i)
            i = (i + x / i) / 2;
        return (int) i;
    }
}
