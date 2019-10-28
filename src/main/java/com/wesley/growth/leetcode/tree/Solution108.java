package com.wesley.growth.leetcode.tree;

/**
 * <p>
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * </p>
 *
 * @author Created by Yani on 2019/10/25
 */
public class Solution108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        // 左子树
        node.left = buildTree(nums, left, mid - 1);
        // 右子树
        node.right = buildTree(nums, mid + 1, right);
        return node;
    }

}
