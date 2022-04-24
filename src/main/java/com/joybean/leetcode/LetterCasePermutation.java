package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/letter-case-permutation/">Letter Case Permutation</a>
 *
 * @author Joybean
 */
public class LetterCasePermutation {
    /**
     * backtracking
     *
     * @param s
     * @return
     */
    public static List<String> letterCasePermutation1(String s) {
        List<String> ans = new ArrayList<>();
        backtrack1(s.toCharArray(), 0, "", ans);
        return ans;
    }

    private static void backtrack1(char[] chars, int index, String curPath, List<String> ans) {
        if (index == chars.length) {
            ans.add(curPath);
            return;
        }
        char cur = chars[index];
        if (Character.isDigit(cur)) {
            backtrack1(chars, index + 1, curPath + cur, ans);
        } else {
            backtrack1(chars, index + 1, curPath + Character.toUpperCase(cur), ans);
            backtrack1(chars, index + 1, curPath + Character.toLowerCase(cur), ans);
        }
    }

    /**
     * <a href="https://leetcode.com/problems/letter-case-permutation/discuss/255071/Java-detailed-explanation-of
     * -DFSBacktracking-solution">Optimized backtracking</a>
     *
     * @param s
     * @return
     */
    public static List<String> letterCasePermutation2(String s) {
        List<String> ans = new ArrayList<>();
        backtrack2(s.toCharArray(), 0, ans);
        return ans;
    }

    private static void backtrack2(char[] chars, int index, List<String> ans) {
        if (index == chars.length) {
            ans.add(new String(chars));
            return;
        }
        char cur = chars[index];
        if (Character.isDigit(cur)) {
            backtrack2(chars, index + 1, ans);
        } else {
            //in-place conversion
            chars[index] = Character.toUpperCase(cur);
            backtrack2(chars, index + 1, ans);
            chars[index] = Character.toLowerCase(cur);
            backtrack2(chars, index + 1, ans);
        }
    }

    /**
     * <a href="https://leetcode.com/problems/letter-case-permutation/discuss/115485/Java-Easy-BFS-DFS-solution-with
     * -explanation">BFS</a>
     * TODO
     *
     * @param s
     * @return
     */
    public static List<String> letterCasePermutation3(String s) {
        return null;
    }
}
