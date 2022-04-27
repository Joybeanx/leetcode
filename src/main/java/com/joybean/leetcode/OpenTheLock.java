package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <a href="https://leetcode.com/problems/open-the-lock/">Open the Lock</a>
 *
 * @author Joybean
 */
public class OpenTheLock {
    /**
     * BFS
     *
     * @param deadends
     * @param target
     * @return
     */
    public static int openLock1(String[] deadends, String target) {
        //Use set to avoid TLE
        Set<String> visited = Stream.of(deadends).collect(Collectors.toSet());
        String initial = "0000";
        //corner case
        if (visited.contains(initial)) {
            return -1;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(initial);
        visited.add(initial);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(target)) {
                    return step;
                }
                List<String> neighbors = getNeighbors(current, visited);
                for (String neighbor : neighbors) {
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
            step++;
        }
        return -1;
    }

    /**
     * Bidirectional BFS
     *
     * @param deadends
     * @param target
     * @return
     */
    public static int openLock2(String[] deadends, String target) {
        Set<String> deadSet = Stream.of(deadends).collect(Collectors.toSet());
        String initial = "0000";
        Set<String> set1 = new HashSet<>();
        set1.add(initial);
        Set<String> set2 = new HashSet<>();
        set2.add(target);
        int step = 0;
        while (!set1.isEmpty() && !set2.isEmpty()) {
            Set<String> tmpSet = new HashSet<>();
            for (String cur1 : set1) {
                if (deadSet.contains(cur1)) {
                    continue;
                }
                if (set2.contains(cur1)) {
                    return step;
                }
                //Note here, compare with openLock1
                deadSet.add(cur1);
                List<String> neighbors = getNeighbors(cur1, deadSet);
                for (String neighbor : neighbors) {
                    tmpSet.add(neighbor);
                }
            }
            set1 = set2;
            set2 = tmpSet;
            step++;
        }
        return -1;
    }

    /**
     * Optimized bidirectional BFS
     *
     * @param deadends
     * @param target
     * @return
     */
    public static int openLock3(String[] deadends, String target) {
        Set<String> deadSet = Stream.of(deadends).collect(Collectors.toSet());
        String initial = "0000";
        Set<String> set1 = new HashSet<>();
        set1.add(initial);
        Set<String> set2 = new HashSet<>();
        set2.add(target);
        Set<String> tmpSet;
        int step = 0;
        while (!set1.isEmpty() && !set2.isEmpty()) {
            //pick a smaller set
            if (set1.size() > set2.size()) {
                tmpSet = set1;
                set1 = set2;
                set2 = tmpSet;
            }
            Set<String> neighborSet = new HashSet<>();
            for (String cur1 : set1) {
                if (deadSet.contains(cur1)) {
                    continue;
                }
                if (set2.contains(cur1)) {
                    return step;
                }
                deadSet.add(cur1);
                List<String> neighbors = getNeighbors(cur1, deadSet);
                for (String neighbor : neighbors) {
                    neighborSet.add(neighbor);
                }
            }
            set1 = neighborSet;
            step++;
        }
        return -1;
    }

    public static List<String> getNeighbors(String digits, Set<String> visited) {
        List<String> neighbors = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            for (String neighbor : Arrays.asList(moveUp(digits, i), moveDown(digits, i))) {
                if (!visited.contains(neighbor)) {
                    neighbors.add(neighbor);
                }
            }
        }
        return neighbors;
    }

    public static String moveUp(String digits, int index) {
        char[] slots = digits.toCharArray();
        if (slots[index] == '9') {
            slots[index] = '0';
        } else {
            slots[index]++;
        }
        return new String(slots);
    }

    public static String moveDown(String digits, int index) {
        char[] slots = digits.toCharArray();
        if (slots[index] == '0') {
            slots[index] = '9';
        } else {
            slots[index]--;
        }
        return new String(slots);
    }
}
