package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/valid-parenthesis-string/">Valid Parenthesis String</a>
 *
 * @author Joybean
 */
public class ValidParenthesisString {
    /**
     * Backtracking:Time Limit Exceeded
     *
     * @param s
     * @return
     */
    public static boolean checkValidString1(String s) {
        return backtrack1(s, 0, 0, 0);
    }

    private static boolean backtrack1(String s, int startIdx, int leftCnt, int rightCnt) {
        if (leftCnt < rightCnt) {
            return false;
        }
        if (startIdx == s.length()) {
            if (leftCnt == rightCnt) {
                return true;
            }
            return false;
        }
        char current = s.charAt(startIdx);
        startIdx++;
        if (current == '(') {
            return backtrack1(s, startIdx, ++leftCnt, rightCnt);
        }
        if (current == ')') {
            return backtrack1(s, startIdx, leftCnt, ++rightCnt);
        }

        if (backtrack1(s, startIdx, ++leftCnt, rightCnt)) {
            return true;
        }
        if (backtrack1(s, startIdx, --leftCnt, ++rightCnt)) {
            return true;
        }
        return backtrack1(s, startIdx, leftCnt, --rightCnt);
    }

    /**
     * <a href="https://leetcode.com/problems/valid-parenthesis-string/discuss/107566/Java-12-lines-solution
     * -backtracking">Concise backtracking (by FLAGbigoffer),Time Limit Exceeded</a>
     *
     * @param s
     * @return
     */
    public static boolean checkValidString2(String s) {
        return backtrack2(s, 0, 0);
    }

    private static boolean backtrack2(String s, int startIdx, int count) {
        if (count < 0) {
            return false;
        }
        if (startIdx == s.length()) {
            if (count == 0) {
                return true;
            }
            return false;
        }
        char current = s.charAt(startIdx);
        if (current == '(') {
            return backtrack2(s, startIdx + 1, count + 1);
        } else if (current == ')') {
            return backtrack2(s, startIdx + 1, count - 1);
        }
        return backtrack2(s, startIdx + 1, count) || backtrack2(s, startIdx + 1, count + 1) || backtrack2(s,
            startIdx + 1,
            count - 1);
    }

    /**
     * DP
     * TODO
     *
     * @param s
     * @return
     */
    public static boolean checkValidString3(String s) {
        return false;
    }

    /**
     * Greedy
     *
     * @param s
     * @return
     */
    public static boolean checkValidString4(String s) {
        return false;
    }
}
