package com.wesley.growth.leetcode.tree;

/**
 * <p>
 *  给定一个二叉树，判断它是否是高度平衡的二叉树。
 * </p>
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *  一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * @author Created by Yani on 2020/07/09
 */
public class Solution110 {

    /**
     * 自顶向下递归
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        // 终止条件: 高度差大于1
        if (Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
    }

    /**
     * 自低向上递归
     * 前序遍历
     */
    public boolean isBalanced2(TreeNode root) {
        return false;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftDepth = dfs(node.left);
        return -1;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,2,3,null,null,3,4,null,null,4};
        boolean res = new Solution110().isBalanced(TreeNode.build(arr));
        System.out.println(res);
    }
}
