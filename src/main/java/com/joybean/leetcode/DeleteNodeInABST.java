package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/delete-node-in-a-bst/">Delete Node in a BST</a>
 *
 * @author Joybean
 */
public class DeleteNodeInABST {
    /**
     * Search target parent, replace target with target.right, make target.left become leftmost node of target.right
     *
     * @param root
     * @param key
     * @return
     */
    public static TreeNode deleteNode1(TreeNode root, int key) {
        TreeNode dummy = new TreeNode(Integer.MAX_VALUE, root, null);
        TreeNode targetParent = searchTargetParent(dummy, key);
        if (targetParent == null) {
            return dummy.left;
        }
        TreeNode target = null;
        boolean targetAsLeftChild = false;
        if (targetParent.left != null && targetParent.left.val == key) {
            target = targetParent.left;
            targetParent.left = null;
            targetAsLeftChild = true;
        } else {
            target = targetParent.right;
            targetParent.right = null;
        }
        if (target.right != null) {
            if (targetAsLeftChild) {
                targetParent.left = target.right;
            } else {
                targetParent.right = target.right;
            }
            TreeNode smallestNodeOfTargetRight = leftMostNode(target.right);
            smallestNodeOfTargetRight.left = target.left;
        } else {
            if (targetAsLeftChild) {
                targetParent.left = target.left;
            } else {
                targetParent.right = target.left;
            }
        }
        return dummy.left;
    }

    private static TreeNode searchTargetParent(TreeNode node, int key) {
        if (node == null) {
            return null;
        }
        if (node.left != null && node.left.val == key || node.right != null && node.right.val == key) {
            return node;
        }
        if (node.val > key) {
            return searchTargetParent(node.left, key);
        }
        return searchTargetParent(node.right, key);
    }

    /**
     * Replace target with target.right's left most node or target.left's right most node
     *
     * @param root
     * @param key
     * @return
     */
    public static TreeNode deleteNode2(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode2(root.left, key);
            return root;
        }
        if (root.val < key) {
            root.right = deleteNode2(root.right, key);
            return root;
        }
        if (root.left == null && root.right == null) {
            return null;
        }
        TreeNode leftMostNodeOfTargetRight = leftMostNode(root.right);
        if (leftMostNodeOfTargetRight != null) {
            root.val = leftMostNodeOfTargetRight.val;
            root.right = deleteNode2(root.right, leftMostNodeOfTargetRight.val);
        } else {
            TreeNode rightMostNodeOfTargetLeft = rightMostNode(root.left);
            if (rightMostNodeOfTargetLeft != null) {
                root.val = rightMostNodeOfTargetLeft.val;
                root.left = deleteNode2(root.left, rightMostNodeOfTargetLeft.val);
            }
        }
        return root;
    }

    /**
     * <a href="https://leetcode.com/problems/delete-node-in-a-bst/solutions/93296/recursive-easy-to-understand-java
     * -solution/">Attach target.left to left most node of target.right</a>
     *
     * @param root
     * @param key
     * @return
     */
    public static TreeNode deleteNode3(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key > root.val) {
            root.right = deleteNode3(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode3(root.left, key);
        } else {
            if (root.right == null) {
                return root.left;
            }
            if (root.left == null) {
                return root.right;
            }
            TreeNode leftMostNodeOfRightChild = leftMostNode(root.right);
            //attach target.left to left most node of target.right
            leftMostNodeOfRightChild.left = root.left;
            return root.right;
        }
        return root;
    }

    /**
     * <a href="https://leetcode.com/problems/delete-node-in-a-bst/solutions/93296/recursive-easy-to-understand-java
     * -solution/"></a>
     *
     * @param root
     * @param key
     * @return
     */
    public static TreeNode deleteNode4(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key > root.val) {
            root.right = deleteNode4(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode4(root.left, key);
        } else {
            if (root.right == null) {
                return root.left;
            }
            if (root.left == null) {
                return root.right;
            }
            //target has two children,replace target with target.right's left most node or target.left's right most node
            TreeNode leftMostNodeOfRightChild = leftMostNode(root.right);
            root.val = leftMostNodeOfRightChild.val;
            root.right = deleteNode2(root.right, leftMostNodeOfRightChild.val);
        }
        return root;
    }

    public static TreeNode leftMostNode(TreeNode node) {
        TreeNode cur = node;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur;
    }

    public static TreeNode rightMostNode(TreeNode node) {
        TreeNode cur = node;
        while (cur.right != null) {
            cur = cur.right;
        }
        return cur;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {this.val = val;}

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
