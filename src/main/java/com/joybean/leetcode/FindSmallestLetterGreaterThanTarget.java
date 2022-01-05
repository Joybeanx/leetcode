package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/find-smallest-letter-greater-than-target/">Find Smallest Letter Greater Than
 * Target</a>
 *
 * @author Joybean
 */
public class FindSmallestLetterGreaterThanTarget {
    /**
     * Binary search
     *
     * @param letters
     * @param target
     * @return
     */
    public static char nextGreatestLetter1(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        //search range [left,right]
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (target >= letters[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (left == letters.length) {
            return letters[0];
        }
        return letters[left];
    }
}
