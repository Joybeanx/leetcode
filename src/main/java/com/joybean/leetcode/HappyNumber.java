package com.joybean.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/happy-number/">Happy Number</a>
 *
 * @author Joybean
 */
public class HappyNumber {
    /**
     * Use HashSet to detect cycle
     *
     * @param n
     * @return
     */
    public static boolean isHappy1(int n) {
        Set<Integer> set = new HashSet<>();
        while (set.add(n)) {
            int next = 0;
            while (n != 0) {
                int digit = n % 10;
                next += digit * digit;
                n /= 10;
            }
            n = next;
            if (n == 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * <a href="https://leetcode.com/problems/happy-number/solutions/56917/my-solution-in-c-o-1-space-and-no-magic-math-property-involved/">Floyd's cycle detection algorithm</a>
     * TODO
     *
     * @param n
     * @return
     */
    public static boolean isHappy2(int n) {
        return false;
    }
}
