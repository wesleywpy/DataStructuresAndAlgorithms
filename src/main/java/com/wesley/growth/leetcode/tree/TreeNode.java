package com.wesley.growth.leetcode.tree;

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

    public static TreeNode build(Integer[] arr) {
        if (arr == null || arr.length < 1) {
            throw new IllegalArgumentException("参数不能错误");
        }

        return buildTree(arr, 0, arr.length - 1);
    }

    private static TreeNode buildTree(Integer[] arr, int start, int end) {
        return null;
    }

}
