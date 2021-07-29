package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/minimum-height-trees/">Minimum Height Trees</a>
 *
 * @author Joybean
 */
public class MinimumHeightTrees {
    /**
     * DFS:Time Limit Exceeded
     *
     * @param n
     * @param edges
     * @return
     */
    public static List<Integer> findMinHeightTrees1(int n, int[][] edges) {
        if (n == 1) {
            return Arrays.asList(0);
        }
        Map<Integer, Set<Integer>> edgesMap = new HashMap<>();
        for (int[] edge : edges) {
            Set<Integer> adjacent1 = edgesMap.getOrDefault(edge[0], new HashSet<>());
            adjacent1.add(edge[1]);
            edgesMap.put(edge[0], adjacent1);
            Set<Integer> adjacent2 = edgesMap.getOrDefault(edge[1], new HashSet<>());
            adjacent2.add(edge[0]);
            edgesMap.put(edge[1], adjacent2);
        }
        List<Integer> ans = new ArrayList<>();
        int minHeightSoFar = Integer.MAX_VALUE;
        for (Integer root : edgesMap.keySet()) {
            Set<Integer> visited = new HashSet<>();
            visited.add(root);
            int minHeight = getMaxHeight(root, edgesMap, visited);
            if (minHeight < minHeightSoFar) {
                ans.clear();
                ans.add(root);
                minHeightSoFar = minHeight;
            } else if (minHeight == minHeightSoFar) {
                ans.add(root);
            }
        }
        return ans;
    }

    private static int getMaxHeight(int root, Map<Integer, Set<Integer>> edgesMap, Set<Integer> visited) {
        Set<Integer> adjacentNodes = edgesMap.get(root);
        int maxHeight = 0;
        for (int adjacent : adjacentNodes) {
            if (visited.contains(adjacent)) {
                continue;
            }
            visited.add(adjacent);
            maxHeight = Math.max(maxHeight, getMaxHeight(adjacent, edgesMap, visited));
            visited.remove(adjacent);
        }
        return 1 + maxHeight;
    }
}
