package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/valid-palindrome/">Valid Palindrome</a>
 *
 * @author Joybean
 */
public class ValidPalindrome {
    /**
     * Two pointers
     *
     * @param s
     * @return
     */
    public static boolean isPalindrome1(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            if (!Character.isLetterOrDigit(chars[left])) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(chars[right])) {
                right--;
                continue;
            }
            if (Character.toLowerCase(chars[left]) != Character.toLowerCase(chars[right])) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * <a href="https://leetcode.com/problems/valid-palindrome/discuss/39981/My-three-line-java-solution">Use
     * StringBuilder</a>
     *
     * @param s
     * @return
     */
    public static boolean isPalindrome2(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String reversed = new StringBuilder(actual).reverse().toString();
        return actual.equals(reversed);
    }
}
