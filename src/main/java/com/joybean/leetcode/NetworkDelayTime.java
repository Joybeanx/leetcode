package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/network-delay-time/">Network Delay Time</a>
 *
 * @author Joybean
 */
public class NetworkDelayTime {
    /**
     * Dijkstra solution
     *
     * @param times
     * @param n
     * @param k
     * @return
     */
    public static int networkDelayTime1(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> timeMap = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            List<int[]> targets = timeMap.getOrDefault(times[i][0], new ArrayList<>());
            targets.add(new int[] {times[i][1], times[i][2]});
            timeMap.put(times[i][0], targets);
        }
        if (!timeMap.containsKey(k)) {
            return -1;
        }
        //minTimes[i] represents the minimum time for the ith node to receive the signal from the kth node.
        //Using minTimes can reduces the number of elements in the queue.
        int[] minTimes = new int[n + 1];
        Arrays.fill(minTimes, Integer.MAX_VALUE);
        //Using visited also can reduces the number of elements in the queue.
        Set<Integer> visited = new HashSet<>();
        visited.add(k);
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing(a -> a[1]));
        queue.offer(new int[] {k, 0});
        int ans = 0;
        while (!queue.isEmpty()) {
            int[] minTime = queue.poll();
            //pruning
            if (minTime[1] > minTimes[minTime[0]]) {
                continue;
            }
            ans = minTime[1];
            visited.add(minTime[0]);
            List<int[]> adjacentNodes = timeMap.get(minTime[0]);
            if (adjacentNodes == null) {
                continue;

            }
            for (int[] adj : adjacentNodes) {
                int nextTime = minTime[1] + adj[1];
                //Use visited array to void circular path, case:{{1, 2, 1}, {2, 1, 3}},2,2
                if (!visited.contains(adj[0]) && minTimes[adj[0]] > nextTime) {
                    queue.add(new int[] {adj[0], nextTime});
                    minTimes[adj[0]] = nextTime;
                }
            }
        }
        return visited.size() == n ? ans : -1;
    }

    /**
     * <a href="https://leetcode.com/problems/network-delay-time/discuss/210698/Java-Djikstrabfs-Concise-and-very
     * -easy-to-understand">Concise Dijkstra but may inefficient</a>
     *
     * @param times
     * @param n
     * @param k
     * @return
     */
    public static int networkDelayTime2(int[][] times, int n, int k) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] time : times) {
            map.putIfAbsent(time[0], new HashMap<>());
            map.get(time[0]).put(time[1], time[2]);
        }
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[] {0, k});
        boolean[] visited = new boolean[n + 1];
        int res = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.remove();
            int curNode = cur[1];
            int curDist = cur[0];
            if (visited[curNode]) {
                continue;
            }
            visited[curNode] = true;
            res = curDist;
            n--;
            if (n == 0) {
                return res;
            }
            if (map.containsKey(curNode)) {
                for (int next : map.get(curNode).keySet()) {
                    //This puts too many items in the queue, which makes it slower for extract min
                    pq.add(new int[] {curDist + map.get(curNode).get(next), next});
                }
            }
        }
        return -1;
    }

    /**
     * Floyd–Warshall algorithm
     * TODO
     *
     * @param times
     * @param n
     * @param k
     * @return
     */
    public static int networkDelayTime3(int[][] times, int n, int k) {
        return 0;
    }

    /**
     * Bellman-Ford algorithm
     * TODO
     *
     * @param times
     * @param n
     * @param k
     * @return
     */
    public static int networkDelayTime4(int[][] times, int n, int k) {
        return 0;
    }
}
