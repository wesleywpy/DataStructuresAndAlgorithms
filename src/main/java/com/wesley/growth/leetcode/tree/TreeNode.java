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
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode build(Integer[] arr) {
        if (Objects.isNull(arr) || arr.length < 1) {
            return null;
        }
        return build(arr, 0);
    }

    private static TreeNode build(Integer[] arr, int index) {
        if (arr[index] == null) {
            return null;
        }

        TreeNode node = new TreeNode(arr[index]);

        // 左节点
        int left = 2 * index + 1;
        // 右节点
        int right = 2 * index + 2;

        if (left > arr.length - 1) {
            node.left = null;
        }else{
            node.left = build(arr, left);
        }

        if (right > arr.length - 1) {
            node.right = null;
        }else{
            node.right = build(arr, right);
        }

        return node;
    }
}
