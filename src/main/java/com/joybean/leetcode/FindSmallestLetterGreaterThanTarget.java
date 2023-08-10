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
     * Binary search 2:find upper bound
     *
     * @param letters
     * @param target
     * @return
     * @see <a href ="https://github.com/python/cpython/blob/3.9/Lib/bisect.py#L15">Python bisect_right</a>
     */
    public static char nextGreatestLetter2(char[] letters, char target) {
        int left = 0;
        int right = letters.length;
        //search range [left,right)
        //loop invariants:
        //for each num in [0, left), num <= target
        //[left, right) is not empty, left < right
        //for each num in [right, length), num > target
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (letters[mid] <= target) {
                //mid must not be insert position
                left = mid + 1;
            } else {
                //mid may be a possible insert position
                right = mid;
            }
        }
        return letters[left % letters.length];
    }
}
