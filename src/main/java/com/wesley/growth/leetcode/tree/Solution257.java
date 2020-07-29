package com.wesley.growth.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *  说明: 叶子节点是指没有子节点的节点。
 * </p>
 *
 *  输入:
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 *  输出: ["1->2->5", "1->3"]
 *  解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 * @author Created by Yani on 2020/07/27
 */
public class Solution257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        // 如果是叶子节点 返回当前值
        if (root.left == null && root.right == null) {
            res.add(String.valueOf(root.val));
            return res;
        }

        List<String> leftPath = binaryTreePaths(root.left);
        for (String s : leftPath) {
            res.add(String.valueOf(root.val).concat("->").concat(s));
        }

        List<String> rightPath = binaryTreePaths(root.right);
        for (String s : rightPath) {
            res.add(String.valueOf(root.val).concat("->").concat(s));
        }

        return res;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3, 5, 7, 4, 11};
        List<String> res = new Solution257().binaryTreePaths(TreeNode.build(arr));
        for (String item : res) {
            System.out.println(item);
        }
    }

}
