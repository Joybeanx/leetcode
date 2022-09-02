package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/number-of-matching-subsequences/">Number of Matching Subsequences</a>
 *
 * @author Joybean
 */
public class NumberOfMatchingSubsequences {
    /**
     * Straight forward:Time Limit Exceeded
     *
     * @param s
     * @param words
     * @return
     */
    public static int numMatchingSubseq1(String s, String[] words) {
        int ans = 0;
        //curIndexes[i] is the current index of words[i]
        int[] curIndexes = new int[words.length];
        for (char ch : s.toCharArray()) {
            for (int i = 0; i < words.length; i++) {
                if (curIndexes[i] != words[i].length() && ch == words[i].charAt(curIndexes[i])) {
                    curIndexes[i]++;
                    if (curIndexes[i] == words[i].length()) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    /**
     * Optimized straight forward:Time Limit Exceeded
     *
     * @param s
     * @param words
     * @return
     */
    public static int numMatchingSubseq2(String s, String[] words) {
        int ans = 0;
        Map<Integer, Integer> curIndexMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            curIndexMap.put(i, 0);
        }
        for (char ch : s.toCharArray()) {
            Iterator<Map.Entry<Integer, Integer>> iterator = curIndexMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> entry = iterator.next();
                if (entry.getValue() != words[entry.getKey()].length() && ch == words[entry.getKey()].charAt(
                    entry.getValue())) {
                    entry.setValue(entry.getValue() + 1);
                    if (entry.getValue() == words[entry.getKey()].length()) {
                        ans++;
                        iterator.remove();
                    }
                }
            }
        }
        return ans;
    }

    /**
     * Use waiting array
     *
     * @param s
     * @param words
     * @return
     */
    public static int numMatchingSubseq3(String s, String[] words) {
        List<StringBuilder>[] waiting = new ArrayList[26];
        for (String word : words) {
            List<StringBuilder> list = waiting[word.charAt(0) - 'a'];
            if (list == null) {
                list = new ArrayList<>();
                waiting[word.charAt(0) - 'a'] = list;
            }
            list.add(new StringBuilder(word));
        }
        int ans = 0;
        for (char ch : s.toCharArray()) {
            List<StringBuilder> curList = waiting[ch - 'a'];
            if (curList == null || curList.isEmpty()) {
                continue;
            }
            Iterator<StringBuilder> iterator = curList.iterator();
            while (iterator.hasNext()) {
                StringBuilder each = iterator.next();
                each.deleteCharAt(0);
                if (each.length() == 0) {
                    iterator.remove();
                    ans++;
                } else if (each.charAt(0) != ch) {
                    iterator.remove();
                    List<StringBuilder> nextList = waiting[each.charAt(0) - 'a'];
                    if (nextList == null) {
                        nextList = new ArrayList<>();
                        waiting[each.charAt(0) - 'a'] = nextList;
                    }
                    nextList.add(each);
                }
            }

        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/number-of-matching-subsequences/discuss/117634/Efficient-and-simple-go
     * -through-words-in-parallel-with-explanation">Concise waiting array solution</a>
     *
     * @param s
     * @param words
     * @return
     */
    public static int numMatchingSubseq4(String s, String[] words) {
        List<StringBuilder>[] waiting = new ArrayList[26];
        for (char ch = 'a'; ch <= 'z'; ch++) {
            waiting[ch - 'a'] = new ArrayList<>();
        }
        for (String word : words) {
            waiting[word.charAt(0) - 'a'].add(new StringBuilder(word));
        }
        int ans = 0;
        for (char ch : s.toCharArray()) {
            List<StringBuilder> curList = waiting[ch - 'a'];
            waiting[ch - 'a'] = new ArrayList<>();
            for (StringBuilder sb : curList) {
                sb.deleteCharAt(0);
                if (sb.length() == 0) {
                    ans++;
                } else {
                    waiting[sb.charAt(0) - 'a'].add(sb);
                }
            }
        }
        return ans;
    }
}
