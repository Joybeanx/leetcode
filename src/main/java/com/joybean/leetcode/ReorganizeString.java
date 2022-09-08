package com.joybean.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/reorganize-string/">Reorganize String</a>
 *
 * @author Joybean
 */
public class ReorganizeString {
    /**
     * Priority queue
     *
     * @param s
     * @return
     */
    public static String reorganizeString1(String s) {
        int[] counter = new int[26];
        for (char c : s.toCharArray()) {
            counter[c - 'a']++;
        }
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] != 0) {
                queue.add(new int[] {i, counter[i]});
                if (counter[i] > (s.length() + 1) / 2) {
                    return "";
                }
            }

        }
        int[] prev = {-1, -1};
        int[] cur;
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            cur = queue.poll();
            if (prev[1] > 0) {
                queue.offer(prev);
            }
            if (cur[1] > 0) {
                sb.append((char)(cur[0] + 'a'));
                cur[1]--;
            }
            prev = cur;
        }
        return sb.toString();
    }

    /**
     * <a href="https://leetcode.com/problems/reorganize-string/discuss/232469/Java-No-Sort-O(N)-0ms-beat-100>No
     * sorting</a>
     * TODO
     *
     * @param s
     * @return
     */
    public static String reorganizeString2(String s) {
        return null;
    }
}
