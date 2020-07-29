package com.wesley.growth.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>
 *
 *  给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 *  说明: 叶子节点是指没有子节点的节点。
 * </p>
 *
 * @author Created by Yani on 2020/07/10
 */
public class Solution112 {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        // 左右子节点都为null才是叶子节点, 再进行值得比较
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }

        return hasPathSum(root.left, sum - root.val) ||  hasPathSum(root.right, sum - root.val);
    }

    /**
     * 广度优先
     */
    public boolean hasPathSumWithBfs(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queNode = new LinkedList<TreeNode>();
        Queue<Integer> queVal = new LinkedList<Integer>();
        queNode.offer(root);
        queVal.offer(root.val);
        while (!queNode.isEmpty()) {
            // 从队列弹出一个元素
            TreeNode now = queNode.poll();
            int temp = queVal.poll();
            if (now.left == null && now.right == null) {
                if (temp == sum) {
                    return true;
                }
                continue;
            }
            if (now.left != null) {
                queNode.offer(now.left);
                queVal.offer(now.left.val + temp);
            }
            if (now.right != null) {
                queNode.offer(now.right);
                queVal.offer(now.right.val + temp);
            }
        }
        return false;
    }


}
