package com.wesley.growth.leetcode.tree;

/**
 * <p>
 * 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。(满足 [L...R] 之间的数字的总和 )
 * 二叉搜索树保证具有唯一的值。
 * </p>
 * Email yani@uoko.com
 *
 * @author Created by Yani on 2019/08/30
 */
public class Solution938 {

    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }

        // 当前值 比最小值还小 返回右子树的和
        if (root.val < L) {
            return rangeSumBST(root.right, L, R);
        }

        // 当前值 比最大值还大 返回左子树的和
        if (root.val > R) {
            return rangeSumBST(root.left, L, R);
        }

        // 当前节点 val >= L 且 X <= R 时则返回：当前节点值 + 左子树之和 + 右子树之和
        return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }

    public static void main(String[] args) {
    }

}
