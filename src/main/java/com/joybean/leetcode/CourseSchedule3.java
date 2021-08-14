package com.joybean.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.com/problems/course-schedule-iii/">Course Schedule III</a>
 *
 * @author Joybean
 */
public class CourseSchedule3 {
    /**
     * <a href="https://leetcode.com/problems/course-schedule-iii/discuss/308492/Java-bottom-up-DP-solution-O(n*e)">Iterative(bottom-up)
     * DP:Time Limit Exceeded</a>
     *
     * @param courses
     * @return
     */
    public static int scheduleCourse1(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(course -> course[1]));
        int maxLastDay = courses[courses.length - 1][1];
        //dp[i][j] represents till ith course, the maximum number of courses I can take on the jst day
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
}
