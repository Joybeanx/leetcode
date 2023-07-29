package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/">All Nodes Distance K in Binary Tree</a>
 *
 * @author Joybean
 */
public class AllNodesDistanceKInBinaryTree {
    private Map<Integer, List<Integer>> graph = new HashMap<>();

    /**
     * <a href="https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/editorial/">DFS on equivalent Graph</a>
     *
     * @param root
     * @param target
     * @param k
     * @return
     */
    public List<Integer> distanceK1(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList();
        buildGraph(root);
        dfs(target.val, k, new HashSet<>(), ans);
        return ans;
    }

    private void dfs(int cur, int k, Set<Integer> visited, List<Integer> ans) {
        if (k == 0) {
            ans.add(cur);
            return;
        }
        visited.add(cur);
        for (Integer neighbor : graph.getOrDefault(cur, Collections.emptyList())) {
            if (visited.contains(neighbor)) {
                continue;
            }
            dfs(neighbor, k - 1, visited, ans);
        }
    }

    private void buildGraph(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            graph.computeIfAbsent(node.val, v -> new ArrayList<>()).add(node.left.val);
            graph.computeIfAbsent(node.left.val, v -> new ArrayList<>()).add(node.val);
        }

        if (node.right != null) {
            graph.computeIfAbsent(node.val, v -> new ArrayList<>()).add(node.right.val);
            graph.computeIfAbsent(node.right.val, v -> new ArrayList<>()).add(node.val);
        }
        buildGraph(node.left);
        buildGraph(node.right);
    }

    /**
     * BFS on equivalent Graph
     * TODO
     *
     * @param root
     * @param target
     * @param k
     * @return
     */
    public List<Integer> distanceK2(TreeNode root, TreeNode target, int k) {
        return null;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }
    }
}
