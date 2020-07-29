package com.wesley.growth.leetcode.tree.medium;

import com.wesley.growth.leetcode.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <p>
 *  给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *  说明: 叶子节点是指没有子节点的节点。
 *
 * </p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * @author Created by Yani on 2020/07/27
 */
public class Solution113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        // 使用 Deque 作为 Stack使用
        Deque<Integer> path = new ArrayDeque<>();
        dfs(root, sum, path, res);
        return res;
    }

    private void dfs(TreeNode root, int sum, Deque<Integer> path, List<List<Integer>> res) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null && sum == root.val) {
            path.addLast(root.val);
            res.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }

        path.addLast(root.val);
        dfs(root.left, sum - root.val, path, res);
        dfs(root.right, sum - root.val, path, res);
        path.removeLast();
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, 5, 1};
        new Solution113().pathSum(TreeNode.build(arr), 22);
    }

}
