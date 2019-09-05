package com.wesley.growth.leetcode.tree;


/**
 * <p>
 *  给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 * </p>
 * Email yani@uoko.com
 *
 * @author Created by Yani on 2019/09/04
 */
public class Solution538 {


    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        count(root, 0);
        return root;
    }

    /**
     * 思路: dfs(深度优先搜索) 逆中序遍历
     */
    private int count(TreeNode root, int sum) {
        if (root == null) {
            return sum;
        }

        // 将从右子树返回的sum累加到当前节点的值
        int count = count(root.right, sum);

        root.val = root.val + count;

        int leftVal = count(root.left, root.val);
        // 把左中右三个节点里最后一个遍历的左子节点的返回值，返回给下一层
        return leftVal;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(-2);
        TreeNode node5 = new TreeNode(3);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node3.left = node5;
        TreeNode result = new Solution538().convertBST(node1);
        System.out.println(result);
    }
}
