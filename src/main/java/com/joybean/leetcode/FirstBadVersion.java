package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/first-bad-version/">First Bad Version</a>
 *
 * @author Joybean
 */
public class FirstBadVersion {
    /**
     * Binary search 1
     *
     * @param n
     * @return
     */
    public static int firstBadVersion1(int n) {
        int left = 1;
        int right = n;
        //search range [left,right)
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean isBadVersion(int version) {
        return false;
    }
}
