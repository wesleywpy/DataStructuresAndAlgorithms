package com.wesley.growth.leetcode.tree;

import java.util.LinkedList;

/**
 * <p>
 * 翻转一个二叉树
 * </p>
 * Email yani@uoko.com
 *
 * @author Created by Yani on 2019/09/03
 */
public class Solution226 {

    /**
     * 输入：
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     *
     *  输出：
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        // 后序遍历
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    /**
     * 迭代方法实现
     * 思路: 需要交换树中所有节点的左孩子和右孩子
     */
    public TreeNode invertTreeByIter(TreeNode root) {
        if (root == null) {
            return null;
        }

        // 保存 还没有交换左右孩子位置 的节点
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node7 = new TreeNode(7);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node9 = new TreeNode(9);

        node4.left = node2;
        node4.right = node7;
        node2.left = node1;
        node2.right = node3;

        node7.left = node6;
        node7.right = node9;
        TreeNode result = new Solution226().invertTree(node4);
        System.out.println(result);
    }


}
