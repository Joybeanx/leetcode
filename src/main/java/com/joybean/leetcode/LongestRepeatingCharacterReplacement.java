package com.joybean.leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/longest-repeating-character-replacement/">Longest Repeating Character
 * Replacement</a>
 *
 * @author Joybean
 */
public class LongestRepeatingCharacterReplacement {
    /**
     * Sliding window + Monotonic queue
     *
     * @param s
     * @param k
     * @return
     */
    public static int characterReplacement1(String s, int k) {
        int left = 0;
        int ans = 0;
        //The top element of dequeue always store character which has the largest count in current window
        Deque<Character> deque = new LinkedList<>();
        Map<Character, Integer> counter = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            Character rightChar = s.charAt(right);
            counter.merge(rightChar, 1, Integer::sum);
            while (!deque.isEmpty() && counter.get(rightChar) >= counter.get(deque.peekLast())) {
                deque.pollLast();
            }
            deque.offerLast(rightChar);
            while (!deque.isEmpty() && right - left - counter.get(deque.peek()) + 1 > k) {
                Character leftChar = s.charAt(left);
                counter.merge(leftChar, -1, Integer::sum);
                if (counter.remove(leftChar, 0) && deque.peek().equals(leftChar)) {
                    deque.poll();
                }
                left++;
            }
            ans = Math.max(right - left + 1, ans);
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/longest-repeating-character-replacement/discuss/91271/Java-12-lines-O
     * (n)-sliding-window-solution-with-explanation">Sliding window 2</a>
     *
     * @param s
     * @param k
     * @return
     */
    public static int characterReplacement2(String s, int k) {
        int left = 0;
        int ans = 0;
        int maxCount = 0;
        int[] counter = new int[26];
        for (int right = 0; right < s.length(); right++) {
            maxCount = Math.max(++counter[s.charAt(right) - 'A'], maxCount);
            if (right - left - maxCount + 1 > k) {
                counter[s.charAt(left++) - 'A']--;
                //Don't need to update maxCount here,see tsuvmxwu's explanation.
            }
            ans = Math.max(right - left + 1, ans);
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/longest-repeating-character-replacement/discuss/278271/JavaC%2B
     * %2BPython-Sliding-Window-just-O(n)">Sliding window 3</a>
     *
     * @param s
     * @param k
     * @return
     */
    public static int characterReplacement3(String s, int k) {
        int left = 0;
        int right = 0;
        int maxCount = 0;
        int[] counter = new int[26];
        for (right = 0; right < s.length(); right++) {
            maxCount = Math.max(++counter[s.charAt(right) - 'A'], maxCount);
            if (right - left - maxCount + 1 > k) {
                counter[s.charAt(left++) - 'A']--;
            }
        }
        return right - left;
    }
}
