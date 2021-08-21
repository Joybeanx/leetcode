package com.joybean.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/course-schedule-iii/">Course Schedule III</a>
 *
 * @author Joybean
 */
public class CourseSchedule3 {
    /**
     * <a href="https://leetcode.com/problems/course-schedule-iii/discuss/363735/Recursive-or-DP-Top-Down-or-Dp
     * -Bottom-Up-or-Greedy-or-Greedy-Optimised-or-Explanations">Iterative(bottom-up)
     * DP:Time Limit Exceeded</a>
     *
     * @param courses
     * @return
     */
    public static int scheduleCourse1(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(course -> course[1]));
        int maxLastDay = courses[courses.length - 1][1];
        //dp[i][j] represents the maximum number of courses can be take till including ith course of time jst day
        //Think this problem as Knapsack0/1 problem
        int[][] dp = new int[courses.length + 1][maxLastDay + 1];
        int m = dp.length;
        int n = dp[0].length;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int courseIndex = i - 1;
                int duration = courses[courseIndex][0];
                int lastDay = courses[courseIndex][1];
                if (j <= lastDay && j >= duration) {
                    dp[i][j] = dp[i - 1][j - duration] + 1;
                }
                //Don't take this course：Max ( a, b )
                //a:maximum number of course can be taken without this course of time j : dp[i-1][j]
                //b:maximum number of course can be take including this course but less time : dp[ i][j - 1]
                dp[i][j] = Math.max(dp[i][j], Math.max(dp[i][j - 1], dp[i - 1][j]));
            }
        }
        return dp[courses.length][maxLastDay];
    }

    /**
     * Recursive(top-down) DP with memo
     * TODO
     *
     * @param courses
     * @return
     */
    public static int scheduleCourse2(int[][] courses) {
        return 0;
    }

    /**
     * Priority Queue
     *
     * @param courses
     * @return
     */
    public static int scheduleCourse3(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(course -> course[1]));
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(
            Comparator.comparing((Integer idx) -> courses[idx][0]).reversed());
        int daysSoFar = 0;
        for (int idx = 0; idx < courses.length; idx++) {
            int[] course = courses[idx];
            if (daysSoFar + course[0] <= course[1]) {
                priorityQueue.offer(idx);
                daysSoFar += course[0];
            } else {
                Integer maxDurationIdx = priorityQueue.peek();
                if (maxDurationIdx != null && courses[maxDurationIdx][0] > course[0]) {
                    priorityQueue.poll();
                    daysSoFar -= courses[maxDurationIdx][0];
                    priorityQueue.offer(idx);
                    daysSoFar += course[0];
                }
            }
        }
        return priorityQueue.size();
    }

    /**
     * <a href="https://leetcode.com/problems/course-schedule-iii/solution/">Optimized Priority Queue</a>
     *
     * @param courses
     * @return
     */
    public static int scheduleCourse4(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(c -> c[1]));
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int time = 0;
        for (int[] c : courses) {
            if (time + c[0] <= c[1]) {
                queue.offer(c[0]);
                time += c[0];
            } else if (!queue.isEmpty() && queue.peek() > c[0]) {
                time += c[0] - queue.poll();
                queue.offer(c[0]);
            }
        }
        return queue.size();
    }
}
