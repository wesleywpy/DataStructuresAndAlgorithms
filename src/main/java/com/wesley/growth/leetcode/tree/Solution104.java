package com.wesley.growth.leetcode.tree;

import java.util.LinkedList;

/**
 * <p>
 * 给定一个二叉树，找出其最大深度。
 * </p>
 * Email yani@uoko.com
 *
 * @author Created by Yani on 2019/09/04
 */
public class Solution104 {

    /**
     * 深度优先搜索(DFS), 时间复杂度O(n)
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return 1 + Math.max(leftDepth, rightDepth);
    }

    /**
     * 层序遍历
     */
    public int maxDepthByIter(TreeNode root) {
        if (root == null) {
            return 0;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int depth = 0;
        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                count --;
            }
            depth ++;
        }

        return depth;
    }

}
