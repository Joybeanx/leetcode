package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/palindrome-partitioning/">Palindrome Partitioning</a>
 *
 * @author Joybean
 */
public class PalindromePartitioning {
    /**
     * backtracking
     *
     * @param s
     * @return
     */
    public static List<List<String>> partition1(String s) {
        List<List<String>> ans = new ArrayList<>();
        backtrack1(s, 0, new ArrayList<>(), ans);
        return ans;
    }

    private static void backtrack1(String s, int start, List<String> curPath,
        List<List<String>> ans) {
        if (start == s.length()) {
            ans.add(new ArrayList<>(curPath));
            return;
        }
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                curPath.add(s.substring(start, end + 1));
                backtrack1(s, end + 1, curPath, ans);
                curPath.remove(curPath.size() - 1);
            }
        }

    }

    private static boolean isPalindrome(String s, int start, int end) {
        int left = start;
        int right = end;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    /**
     * <a href="https://leetcode.com/problems/palindrome-partitioning/solution/">backtracking with dp</a>
     * TODO
     *
     * @param s
     * @return
     */
    public static List<List<String>> partition2(String s) {
        return null;
    }
}
