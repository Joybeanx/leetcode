package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/course-schedule/">Course Schedule</a>
 *
 * @author Joybean
 */
public class CourseSchedule {

    /**
     * DFS: Time Limit Exceeded
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public static boolean canFinish2(int numCourses, int[][] prerequisites) {
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
     * DFS Topological sort
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public static boolean canFinish1(int numCourses, int[][] prerequisites) {
        //see graph representation: https://leetcode.cn/problems/course-schedule/solutions/250377/bao-mu-shi-ti-jie-shou-ba-shou-da-tong-tuo-bu-pai-/?envType=problem-list-v2&envId=2cktkvj
        Map<Integer, List<Integer>> prerequisiteMap = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            prerequisiteMap.putIfAbsent(prerequisite[1], new ArrayList<>());
            prerequisiteMap.get(prerequisite[1]).add(prerequisite[0]);
        }
        //Use memo to avoid TLE
        boolean[] memo = new boolean[numCourses];
        for (Map.Entry<Integer, List<Integer>> integerListEntry : prerequisiteMap.entrySet()) {
            if (!backtrack1(integerListEntry.getKey(), new HashSet<>(), prerequisiteMap, memo)) {
                return false;
            }
        }
        return true;

    }

    private static boolean backtrack1(Integer course, Set<Integer> curPath,
        Map<Integer, List<Integer>> prerequisiteMap, boolean[] marked) {
        //pruning
        if (marked[course]) {
            return true;
        }
        if (curPath.contains(course)) {
            return false;
        }
        if (!prerequisiteMap.containsKey(course)) {
            return true;
        }
        curPath.add(course);
        for (Integer prerequisite : prerequisiteMap.get(course)) {
            if (!backtrack1(prerequisite, curPath, prerequisiteMap, marked)) {
                return false;
            }
        }
        curPath.remove(course);
        marked[course] = true;
        return true;
    }

    /**
     * DFS Topological sort
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public static boolean canFinish3(int numCourses, int[][] prerequisites) {
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
            if (!backtrack2(course, graph, visited, marked)) {
                return false;
            }
        }
        return true;
    }

    private static boolean backtrack2(int course, List<List<Integer>> graph, boolean[] visited, boolean[] marked) {
        if (visited[course]) {
            return false;
        }
        if (marked[course]) {
            return true;
        }
        visited[course] = true;
        for (int nextCourse : graph.get(course)) {
            if (!backtrack2(nextCourse, graph, visited, marked)) {
                return false;
            }
        }
        visited[course] = false;
        marked[course] = true;
        return true;
    }

    /**
     * <a href="https://leetcode.com/problems/course-schedule/solutions/162743/java-c-python-bfs-topological-sorting
     * -o-n-e/">BFS Topological Sort</a>
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public static boolean canFinish4(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] indegrees = new int[numCourses];
        //init graph with empty list to avoid NPE while iterating graph[p]
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[1]].add(prerequisite[0]);
            //number of other courses need to take before take course
            indegrees[prerequisite[0]]++;
        }
        //find courses with 0 indegree, because these courses doesn't have prerequisites
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        int k = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Integer p = queue.poll();
                k++;
                for (Integer course : graph[p]) {
                    //decrease indegree for current course and keep finding courses with 0 indegree
                    if (--indegrees[course] == 0) {
                        queue.offer(course);
                    }
                }
            }
        }
        return numCourses == k;
    }

}
