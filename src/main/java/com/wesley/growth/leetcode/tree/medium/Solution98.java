package com.wesley.growth.leetcode.tree.medium;

import com.wesley.growth.leetcode.tree.TreeNode;

/**
 * <p>
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * </p>
 *
 * @author Created by Wesley on 2020/09/10
 */
public class Solution98 {
    private long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        // 左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        return isValidBST(root.right);
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{10,5,15,null,null,6,20};
        boolean res = new Solution98().isValidBST(TreeNode.build(arr));
        System.out.println(res);
    }
}
