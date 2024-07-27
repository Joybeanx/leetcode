package com.joybean.leetcode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/task-scheduler/">Task Scheduler</a>
 *
 * @author Joybean
 */
public class TaskScheduler {
    /**
     * <a href="https://leetcode.com/problems/task-scheduler/solutions/104501/java-priorityqueue-solution-similar-problem-rearrange-string-k-distance-apart/">PriorityQueue</a>
     *
     * @param tasks
     * @param n
     * @return
     */
    public static int leastInterval1(char[] tasks, int n) {
        int ans = 0;
        //Sort by numbers of each task
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Map<Character, Integer> counter = new HashMap<>();
        for (char task : tasks) {
            counter.put(task, counter.getOrDefault(task, 0) + 1);
        }
        pq.addAll(counter.values());
        while (!pq.isEmpty()) {
            int k = n + 1;
            List<Integer> newCounts = new ArrayList<>();
            while (k > 0 && !pq.isEmpty()) {
                int count = pq.poll();
                if (count > 1) {
                    newCounts.add(count - 1);
                }
                k++;
                ans++;
            }
            for (Integer newCount : newCounts) {
                pq.offer(newCount);
            }
            if (pq.isEmpty()) {
                break;
            }
            ans += k;
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/task-scheduler/solutions/104500/java-o-n-time-o-1-space-1-pass-no-sorting-solution-with-detailed-explanation/"></a>
     * TODO
     *
     * @param tasks
     * @param n
     * @return
     */
    public static int leastInterval2(char[] tasks, int n) {
        return 0;
    }

}
