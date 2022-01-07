package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/find-smallest-letter-greater-than-target/">Find Smallest Letter Greater Than
 * Target</a>
 *
 * @author Joybean
 */
public class FindSmallestLetterGreaterThanTarget {
    /**
     * Binary search 1
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
            if (letters[mid] <= target) {
                //Increase the left boundary of search range to locate next possible greater letter
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

    /**
     * Binary search 2
     *
     * @param letters
     * @param target
     * @return
     */
    public static char nextGreatestLetter2(char[] letters, char target) {
        int left = 0;
        int right = letters.length;
        //search range [left,right)
        while (left < right) {
            //Make mid biased to the left,so that this won't make the search range stuck
            int mid = (left + right - 1) >>> 1;
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left == letters.length) {
            return letters[0];
        }
        return letters[left];
    }
}
