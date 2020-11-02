package com.lc.tree;

/**
 * 树的最小深度
 */
public class Solution01 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    public int run(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = run(root.left);
        int right = run(root.right);
        if (left == 0) {
            return right + 1;
        } else if (right == 0) {
            return left + 1;
        } else {
            return Math.min(left, right) + 1;
        }
    }
}
