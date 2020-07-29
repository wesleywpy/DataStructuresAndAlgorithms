package com.wesley.growth.leetcode.tree;

/**
 * <p>
 *  计算给定二叉树的所有左叶子之和。
 * </p>
 * 示例：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *  在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 * @author Created by Yani on 2020/07/10
 */
public class Solution404 {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 当前节点左子节点为null，则返回右子节点的递归解
        if (root.left == null) {
            return sumOfLeftLeaves(root.right);
        }

        // 当前节点的左子节点为叶子节点，则返回左子节点值+右子节点的递归解
        if (root.left.left == null && root.left.right == null) {
            return root.left.val + sumOfLeftLeaves(root.right);
        }

        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3, 9, 20, 2, null, 15, 7};
        int res = new Solution404().sumOfLeftLeaves(TreeNode.build(arr));
        System.out.println(res);
    }

}
