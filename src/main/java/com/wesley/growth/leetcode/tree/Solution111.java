package com.wesley.growth.leetcode.tree;

/**
 * <p>
 *  给定一个二叉树，找出其最小深度。
 *  最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 *  说明: 叶子节点是指没有子节点的节点。
 * </p>
 *
 * @author Created by Yani on 2020/07/07
 */
public class Solution111 {

    /**
     * 示例:
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     *  返回它的最小深度  2.
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        // 1. 当节点左右孩子都为空时，返回 1
        // 2. 当左孩子和右孩子有为空的情况，直接返回m1+m2+1
        if (root.left == null || root.right == null) {
            return leftDepth + rightDepth + 1;
        } else {
            return 1 + (Math.min(leftDepth, rightDepth));
        }
    }


    public static void main(String[] args) {
        Integer[] arr = {3, 9, 20, null, null, 15, 7};
        TreeNode node = TreeNode.build(arr);
        System.out.println(node);
    }



}
