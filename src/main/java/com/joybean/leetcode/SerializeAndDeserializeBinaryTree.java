package com.joybean.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.com/problems/serialize-and-deserialize-binary-tree/">Serialize and Deserialize Binary
 * Tree</a>
 *
 * @author Joybean
 */
public class SerializeAndDeserializeBinaryTree {

    /**
     * Fill perfect binary tree:Memory Limit Exceeded
     *
     * @param root
     * @return
     */
    public static String serialize1(TreeNode root) {
        if (root == null) {
            return "";
        }

        int height = getHeight(root);
        String[] arr = new String[(int)Math.pow(2, height) - 1];
        List<String> list = Arrays.asList(arr);
        serialize(root, 0, Arrays.asList(arr));
        return list.stream().collect(Collectors.joining(","));
    }

    private static void serialize(TreeNode root, int index, List<String> list) {
        if (root == null) {
            return;
        }
        list.set(index, String.valueOf(root.val));
        serialize(root.left, 2 * index + 1, list);
        serialize(root.right, 2 * index + 2, list);
    }

    public static TreeNode deserialize1(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] arr = data.split(",");
        return buildTree(arr, 0);
    }

    private static TreeNode buildTree(String[] arr, int index) {
        if (index >= arr.length) {
            return null;
        }
        if (arr[index].equals("null")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(arr[index]));
        node.left = buildTree(arr, 2 * index + 1);
        node.right = buildTree(arr, 2 * index + 2);
        return node;
    }

    public static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    private static int index;

    /**
     * Preorder traversal
     *
     * @param root
     * @return
     */
    public static String serialize2(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        //1 2 # # 3 4 # # 5 # #
        preorderSerialize(root, sb);
        return sb.toString();

    }

    private static void preorderSerialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("# ");
            return;
        }
        sb.append(root.val + " ");
        preorderSerialize(root.left, sb);
        preorderSerialize(root.right, sb);
    }

    public static TreeNode deserialize2(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] values = data.split(" ");
        return preorderDeserialize(values);
    }

    private static TreeNode preorderDeserialize(String[] values) {
        String val = values[index++];
        if (val.equals("#")) {
            return null;
        }
        TreeNode parent = new TreeNode(Integer.parseInt(val));
        parent.left = preorderDeserialize(values);
        parent.right = preorderDeserialize(values);
        return parent;
    }

    /**
     * Preorder traversal using queue
     *
     * @param root
     * @return
     */
    public static String serialize3(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        //1 2 # # 3 4 # # 5 # #
        preorderSerialize(root, sb);
        return sb.toString();
    }

    public static TreeNode deserialize3(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(" ")));
        return preorderDeserialize(queue);
    }

    private static TreeNode preorderDeserialize(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(value));
        node.left = preorderDeserialize(queue);
        node.right = preorderDeserialize(queue);
        return node;
    }

    /**
     * <a href="https://leetcode.com/problems/serialize-and-deserialize-binary-tree/solutions/74264/short-and
     * -straight-forward-bfs-java-code-with-a-queue/">BFS: level order travel</a>
     * TODO
     * @param root
     * @return
     */
    public static String serialize4(TreeNode root) {
        //1 2 3 # # 4 5 # # # #
        return null;

    }

    public static TreeNode deserialize4(String data) {
        return null;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int x) {val = x;}
    }

}
