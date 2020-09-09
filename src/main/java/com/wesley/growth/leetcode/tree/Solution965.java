package com.wesley.growth.leetcode.tree;

/**
 * <p>
 *  如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 *  只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 * </p>
 *
 *  提示：
 *   给定树的节点数范围是 [1, 100]。
 *   每个节点的值都是整数，范围为 [0, 99] 。
 *
 * @author Created by Wesley on 2020/09/03
 */
public class Solution965 {

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean res = isUnivalTree(root.left);
        res = res && isUnivalTree(root.right);

        // 当前节点值 不等于左子节点 或 右子节点
        if ((root.left != null && root.val != root.left.val)
                || (root.right != null && root.val != root.right.val)) {
            res = false;
        }

        return res;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,1,1,1,1,2,1};
        boolean res = new Solution965().isUnivalTree(TreeNode.build(arr));
        System.out.println(res);
    }



}
