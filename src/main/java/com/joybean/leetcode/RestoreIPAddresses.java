package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/restore-ip-addresses/description/">Restore IP Addresses</a>
 *
 * @author Joybean
 */
public class RestoreIPAddresses {
    /**
     * DFS
     *
     * @param s
     * @return
     */
    public static List<String> restoreIpAddresses1(String s) {
        List<String> ans = new ArrayList<>();
        char[] chars = s.toCharArray();
        dfs1(chars, 0, 4, "", ans);
        return ans;
    }

    private static void dfs1(char[] chars, int startIdx, int remainingParts, String restored, List<String> ans) {
        if (startIdx == chars.length) {
            if (remainingParts == 0) {
                ans.add(restored);
            }
            return;
        }
        if (remainingParts == 0) {
            return;
        }
        if (!restored.isEmpty()) {
            restored += '.';
        }
        if (chars[startIdx] == '0') {
            dfs1(chars, startIdx + 1, remainingParts - 1, restored + chars[startIdx], ans);
        } else if (chars[startIdx] == '1') {
            dfs1(chars, startIdx + 1, remainingParts - 1, restored + chars[startIdx], ans);
            if (startIdx + 1 < chars.length) {
                dfs1(chars, startIdx + 2, remainingParts - 1, restored + chars[startIdx] + chars[startIdx + 1], ans);
                if (startIdx + 2 < chars.length) {
                    dfs1(chars, startIdx + 3, remainingParts - 1,
                            restored + chars[startIdx] + chars[startIdx + 1] + chars[startIdx + 2], ans);
                }
            }

        } else if (chars[startIdx] == '2') {
            dfs1(chars, startIdx + 1, remainingParts - 1, restored + chars[startIdx], ans);
            if (startIdx + 1 < chars.length) {
                dfs1(chars, startIdx + 2, remainingParts - 1, restored + chars[startIdx] + chars[startIdx + 1], ans);
                if (startIdx + 2 < chars.length) {
                    if (chars[startIdx + 1] < '5' || chars[startIdx + 1] == '5' && chars[startIdx + 2] <= '5') {
                        dfs1(chars, startIdx + 3, remainingParts - 1,
                                restored + chars[startIdx] + chars[startIdx + 1] + chars[startIdx + 2], ans);
                    }
                }
            }
        } else if (chars[startIdx] > '2') {
            dfs1(chars, startIdx + 1, remainingParts - 1, restored + chars[startIdx], ans);
            if (startIdx + 1 < chars.length) {
                dfs1(chars, startIdx + 2, remainingParts - 1, restored + chars[startIdx] + chars[startIdx + 1], ans);
            }
        }
    }

    /**
     * DFS
     *
     * @param s
     * @return
     */
    public static List<String> restoreIpAddresses2(String s) {
        List<String> ans = new ArrayList<>();
        dfs2(s, 0, 4, "", ans);
        return ans;
    }

    private static void dfs2(String s, int startIdx, int remainingParts, String restored, List<String> ans) {
        if (remainingParts == 0) {
            if (startIdx == s.length()) {
                ans.add(restored.substring(0, restored.length() - 1));
            }
            return;
        }
        for (int i = 1; i < 4; i++) {
            if (startIdx + i > s.length()) {
                break;
            }
            String part = s.substring(startIdx, startIdx + i);
            if ((part.length() > 1 && part.startsWith("0")) || (part.length() == 3 && part.compareTo("255") > 0)) {
                continue;
            }
            dfs2(s, startIdx + i, remainingParts - 1, restored + part + ".", ans);
        }
    }

    /**
     * Iterative solution
     *
     * @param s
     * @return TODO
     */
    public static List<String> restoreIpAddresses3(String s) {
        return null;
    }
}
