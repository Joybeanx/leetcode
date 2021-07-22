package com.joybean.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/course-schedule/">Course Schedule</a>
 *
 * @author Joybean
 */
public class CourseSchedule {
    /**
     * Time Limit Exceeded
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public static boolean canFinish1(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> prerequisitesMap = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int[] prerequisite = prerequisites[i];
            Set<Integer> prerequisiteIdxSet;
            if (prerequisitesMap.containsKey(prerequisite[0])) {
                prerequisiteIdxSet = prerequisitesMap.get(prerequisite[0]);
            } else {
                prerequisiteIdxSet = new HashSet<>();
                prerequisitesMap.put(prerequisite[0], prerequisiteIdxSet);
            }
            prerequisiteIdxSet.add(i);
        }
        for (int i = 0; i < prerequisites.length; i++) {
            if (!canFinishInternal(i, prerequisites, prerequisitesMap, new HashSet<>())) {
                return false;
            }
        }
        return true;
    }

    private static boolean canFinishInternal(int idx, int[][] prerequisites,
        Map<Integer, Set<Integer>> prerequisitesMap, Set<Integer> visited) {
        if (visited.contains(idx)) {
            return false;
        }
        visited.add(idx);
        Set<Integer> nextPrerequisitesIdxSet = prerequisitesMap.get(prerequisites[idx][1]);
        if (nextPrerequisitesIdxSet == null) {
            return true;
        }
        for (Integer nextPrerequisiteIdx : nextPrerequisitesIdxSet) {
            if (!canFinishInternal(nextPrerequisiteIdx, prerequisites, prerequisitesMap, new HashSet<>(visited))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Topological Sort via DFS
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public static boolean canFinish2(int numCourses, int[][] prerequisites) {
        return false;
    }
}
