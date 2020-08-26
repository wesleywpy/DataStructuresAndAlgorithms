package com.wesley.growth.leetcode.tree.bst;

import com.wesley.growth.leetcode.tree.TreeNode;

/**
 * <p>
 *  给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * </p>
 * 说明:
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉搜索树中。
 *
 * @author Created by Yani on 2020/08/18
 */
public class Solution235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return root;
        }

        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }

}
