package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
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
        backtrack1(new LinkedList<>(), 0, s, ans);
        return ans;
    }

    private static void backtrack1(LinkedList<String> curPath, int startIdx, String s,
                                   List<List<String>> ans) {
        if (startIdx == s.length()) {
            ans.add(new ArrayList<>(curPath));
            return;
        }
        for (int i = startIdx; i < s.length(); i++) {
            if (isPalindrome(s, startIdx, i)) {
                curPath.add(s.substring(startIdx, i + 1));
                backtrack1(curPath, i + 1, s, ans);
                curPath.removeLast();
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
