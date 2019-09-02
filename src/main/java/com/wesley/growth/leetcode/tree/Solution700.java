package com.wesley.growth.leetcode.tree;

/**
 * <p>
 *  给定二叉搜索树（BST）的根节点和一个值。
 *  你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 * </p>
 * Email yani@uoko.com
 *
 * @author Created by Yani on 2019/09/02
 */
public class Solution700 {

    /**
     * 递归实现
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }

        // 因为BST, 当前节点val 比 目标值大 搜索左子树, 否则搜索右子树
        return root.val > val ? searchBST(root.left, val) : searchBST(root.right, val);
    }

    /**
     * 迭代实现
     */
    public TreeNode searchBSTByIter(TreeNode root, int val) {
        while (true) {
            if (root == null || root.val == val) {
                return root;
            }

            // 因为BST, 当前节点val 比 目标值大 搜索左子树, 否则搜索右子树
            root = root.val > val ? root.left : root.right;
        }

    }
}
