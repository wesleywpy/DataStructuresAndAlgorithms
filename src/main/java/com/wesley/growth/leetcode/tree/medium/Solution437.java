package com.wesley.growth.leetcode.tree.medium;

import com.wesley.growth.leetcode.tree.TreeNode;

/**
 * <p>
 *  给定一个二叉树，它的每个结点都存放着一个整数值。
 *
 *  找出路径和等于给定数值的路径总数。
 *
 *  路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * </p>
 *
 * @author Created by Yani on 2020/08/17
 */
public class Solution437 {


    public int pathSum(TreeNode root, int sum) {
        if (root == null){
            return 0;
        }

        int res = findPath(root, sum);
        res += pathSum(root.left, sum);
        res += pathSum(root.right, sum);
        return res;
    }

    /**
     * 找到node节点 所有符合要求路径的数量
     */
    private int findPath(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }

        int res = 0;
        if (node.val == sum) {
            res += 1;
        }

        res += findPath(node.left, sum - node.val);
        res += findPath(node.right, sum - node.val);
        return res;
    }

    public static void main(String[] args) {
        Integer[] root = new Integer[]{1,-2,-3,1,3,-2,null,-1};
        int res = new Solution437().pathSum(TreeNode.build(root), -1);
        System.out.println(res);
    }
}
