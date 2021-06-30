package com.joybean.leetcode;

import com.joybean.leetcode.ConvertSortedListToBinarySearchTree.ListNode.TreeNode;

/**
 * <a href="https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/">Convert Sorted List to Binary
 * Search Tree</a>
 *
 * @author Joybean
 */
public class ConvertSortedListToBinarySearchTree {
    //TODO
    public TreeNode sortedListToBST(ListNode head) {
        return null;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) { this.val = val; }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode() {}

            TreeNode(int val) { this.val = val; }

            TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
            }
        }
    }
