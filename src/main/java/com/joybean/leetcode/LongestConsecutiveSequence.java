package com.joybean.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/longest-consecutive-sequence/">Longest Consecutive Sequence</a>
 *
 * @author Joybean
 */
public class LongestConsecutiveSequence {
    public static int longestConsecutive1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, 1);
        }
        int ans = 0;
        for (int num : nums) {
            //longest consecutive sequence starts with num
            Integer curLcs = map.get(num);
            if (curLcs == null) {
                continue;
            }
            int next = num + 1;
            while (map.containsKey(next)) {
                int nextLcs = map.get(next);
                curLcs += nextLcs;
                map.remove(next);
                next += nextLcs;
            }
            map.put(num, curLcs);
            ans = Math.max(ans, curLcs);
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/longest-consecutive-sequence/editorial/">HashSet and Intelligent Sequence
     * Building</a>
     *
     * @param nums
     * @return
     */
    public static int longestConsecutive2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        int ans = 0;
        //iterate set instead of nums to skip duplicates
        for (int num : set) {
            //num is the start of a streak
            if (!set.contains(num - 1)) {
                int currentStreak = 1;
                while (set.contains(num + 1)) {
                    currentStreak++;
                    num++;
                }
                ans = Math.max(ans, currentStreak);
            }
        }
        return ans;
    }

    /**
     * Union find
     * TODO
     *
     * @param nums
     * @return
     */
    public static int longestConsecutive3(int[] nums) {
        return 0;
    }
}
