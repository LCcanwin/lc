package com.lc.code;

public class Solution222 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return help(root);
    }

    public int help(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = help(node.left);
        int right = help(node.right);
        return left + right + 1;
    }
}
