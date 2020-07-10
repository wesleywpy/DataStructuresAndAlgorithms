package com.wesley.growth.leetcode.tree;

/**
 * <p>
 *  给定一个二叉树，检查它是否是镜像对称的。
 * </p>
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 *
 * @author Created by Yani on 2020/07/08
 */
public class Solution101 {

    /**
     * 镜像对称，就是左右两边相等，也就是左子树和右子树是相当的。
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        //调用递归函数，比较左节点，右节点
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        // 终止条件
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        // 递归比较 左边，left 和 right.right
        // 递归比较 右边，right 和 right.left
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 2, 3, 4, 4, 3};
        boolean res = new Solution101().isSymmetric(TreeNode.build(arr));
        System.out.println(res);
    }

}
