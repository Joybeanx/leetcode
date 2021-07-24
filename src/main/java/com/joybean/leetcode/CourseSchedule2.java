package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/course-schedule-ii/">Course Schedule II</a>
 *
 * @author Joybean
 */
public class CourseSchedule2 {
    private static int[] ans;
    private static int index;
    private static boolean isPossible = true;

    /**
     * Inspired by <a href="https://leetcode-cn.com/problems/course-schedule-ii/solution/ke-cheng-biao-ii-by-leetcode
     * -solution">Topological sort via DFS</a>
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public static int[] findOrder1(int numCourses, int[][] prerequisites) {
        ans = new int[numCourses];
        index = numCourses - 1;
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        //0:unvisited, 1:visiting, 2:visited
        int[] visited = new int[numCourses];
        for (int course = 0; course < numCourses && isPossible; course++) {
            if (visited[course] == 0) {
                dfs(course, graph, visited);
            }
        }
        if (!isPossible) {
            return new int[0];
        }
        return ans;
    }

    private static void dfs(int course, List<List<Integer>> graph, int[] visited) {
        visited[course] = 1;
        for (int nextCourse : graph.get(course)) {
            //It's very necessary to optimize performance
            if (!isPossible) {
                return;
            }
            if (visited[nextCourse] == 0) {
                dfs(nextCourse, graph, visited);
                //Cycle found
            } else if (visited[nextCourse] == 1) {
                isPossible = false;
                return;
            }
        }
        visited[course] = 2;
        ans[index--] = course;
    }

    /**
     * Use Node  Indegree
     * TODO
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public static int[] findOrder2(int numCourses, int[][] prerequisites) {
        return null;
    }
}
