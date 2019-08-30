package com.wesley.growth.leetcode.tree;

import java.util.Objects;

/**
 * <p>
 *
 * </p>
 * Email yani@uoko.com
 *
 * @author Created by Yani on 2019/08/30
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    TreeNode(Integer[] arr) {
        if (arr == null || arr.length < 1) {
            throw new IllegalArgumentException("参数不能错误");
        }

        // TODO: 2019/8/30 0030 构建二叉搜索树
        this.val = arr[0];
        buildTree(this, arr, 0);
    }

    private void buildTree(TreeNode node, Integer[] arr, int depth) {
        int leftIndex = 2 * depth + 1;
        int rightIndex = leftIndex + 1;

        if ((leftIndex < arr.length) && Objects.nonNull(arr[leftIndex])) {
            node.left = new TreeNode(arr[leftIndex]);
            buildTree(node.left, arr, depth+1);
        }

        if ((rightIndex < arr.length) && Objects.nonNull(arr[rightIndex])) {
            node.right = new TreeNode(arr[rightIndex]);
            buildTree(node.right, arr, depth+1);
        }
    }


}
