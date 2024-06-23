package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/powx-n/">Pow(x, n)</a>
 *
 * @author Joybean
 */
public class Pow {
    /**
     * Straight forward: Time Limit Exceeded
     *
     * @param x
     * @param n
     * @return
     */
    public static double myPow1(double x, int n) {
        if (x == 0d) {
            return 0;
        }
        double ans = 1d;

        for (long i = 0; i < Math.abs((long)n); i++) {
            ans *= x;
        }
        if (n < 0) {
            return 1 / ans;
        }
        return ans;

    }

    /**
     * Recursive solution: double myPow
     *
     * @param x
     * @param n
     * @return
     */
    public static double myPow2(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double pow = myPow2(x, n >>> 1);
        pow *= pow;
        if ((n & 1) == 1) {
            pow = pow * (n < 0 ? (1 / x) : x);
        }
        return pow;
    }

    /**
     * <a href="https://leetcode.com/problems/powx-n/solutions/19544/5-different-choices-when-talk-with-interviewers
     * /">Recursive solution: nest myPow</a>
     * TODO
     *
     * @param x
     * @param n
     * @return
     */
    public static double myPow3(double x, int n) {
        return 0d;
    }

    /**
     * <a href=
     * "https://leetcode.com/problems/powx-n/solutions/19544/5-different-choices-when-talk-with-interviewers/">Recursive
     * solution: double x</a>
     * TODO
     *
     * @param x
     * @param n
     * @return
     */
    public static double myPow4(double x, int n) {
        return 0d;
    }

    /**
     * <a href="https://leetcode.com/problems/powx-n/solutions/1337794/java-c-simple-o-log-n-easy-faster-than-100
     * -explained/">Iterative solution</a>
     * TODO
     *
     * @param x
     * @param n
     * @return
     */
    public static double myPow5(double x, int n) {
        return 0d;
    }
}
