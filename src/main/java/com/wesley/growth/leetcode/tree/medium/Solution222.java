package com.wesley.growth.leetcode.tree.medium;

import com.wesley.growth.leetcode.tree.TreeNode;

/**
 * <p>
 *  给出一个完全二叉树，求出该树的节点个数。
 * </p>
 *
 *  输入:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *  输出: 6
 * @author Created by Yani on 2020/07/09
 */
public class Solution222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    /**
     * 利用完全二叉树特性
     */
    public int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 分别计算左右子树的高度
        int left = count(root.left);
        int right = count(root.right);
        // 如果左右子树高度相等，说明是满二叉树，返回左边的高度再递归遍历右子树
        if (left == right) {
            // 这个位运算是指 2 ^ left
            return (1 << left) + countNodes2(root.right);
        } else {
            // 如果不相等，就先求出右子树高度在递归遍历左子树
            return (1 << right) + countNodes2(root.left);
        }
    }

    private int count(TreeNode node) {
        int level = 0;
        while (node != null) {
            level++;
            // 这里遍历左子树是因为完全二叉树的性质下只要左子树不为空高度就+1
            node = node.left;
        }
        return level;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 2, 3, 4, 4, 3};
        int res = new Solution222().countNodes2(TreeNode.build(arr));
        System.out.println(res);
    }


}
