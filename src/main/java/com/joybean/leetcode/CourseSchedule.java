package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
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
     * Topological sort via DFS
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public static boolean canFinish2(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        boolean[] visited = new boolean[numCourses];
        //Use memo array to avoid repeating checking one course
        boolean[] marked = new boolean[numCourses];
        for (int course = 0; course < numCourses; course++) {
            if (!dfs(course, graph, visited, marked)) {
                return false;
            }
        }
        return true;
    }

    private static boolean dfs(int course, List<List<Integer>> graph, boolean[] visited, boolean[] marked) {
        if (visited[course]) {
            return false;
        }
        if (marked[course]) {
            return true;
        }
        visited[course] = true;
        for (int nextCourse : graph.get(course)) {
            if (!dfs(nextCourse, graph, visited, marked)) {
                return false;
            }
        }
        visited[course] = false;
        marked[course] = true;
        return true;
    }
}
