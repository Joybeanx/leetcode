package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/open-the-lock/">Open the Lock</a>
 *
 * @author Joybean
 */
public class OpenTheLock {
    /**
     * Time Limit Exceeded
     * @param deadends
     * @param target
     * @return
     */
    public static int openLock1(String[] deadends, String target) {
        LinkedList<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        List<String> deadendList = Arrays.asList(deadends);
        String initial = "0000";
        if (deadendList.contains(initial)) {
            return -1;
        }
        queue.add(initial);
        visited.add(initial);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(target)) {
                    return step;
                }
                List<String> adjacentDigits = adjacent(current, deadendList, visited);
                for (String adjacent : adjacentDigits) {
                    queue.offer(adjacent);
                    visited.add(adjacent);
                }
            }
            step++;
        }
        return -1;
    }

    public static List<String> adjacent(String digits, List<String> deadendList, Set<String> visited) {
        List<String> adjacents = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            char[] slots = digits.toCharArray();
            int slot = slots[i];
            char bigger = slot != '9' ? (char)(slot + 1) : '0';
            char less = slot != '0' ? (char)(slot - 1) : '9';
            slots[i] = bigger;
            String adjacent = new String(slots);
            if (!deadendList.contains(adjacent) && !visited.contains(adjacent)) {
                adjacents.add(adjacent);
            }
            slots[i] = less;
            adjacent = new String(slots);
            if (!deadendList.contains(adjacent) && !visited.contains(adjacent)) {
                adjacents.add(adjacent);
            }
        }
        return adjacents;
    }
}
