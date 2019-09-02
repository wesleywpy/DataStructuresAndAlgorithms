package com.wesley.growth.leetcode.tree;

/**
 * <p>
 * 合并二叉树
 * 合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 * 注意: 合并必须从两个树的根节点开始。
 * </p>
 * Email yani@uoko.com
 *
 * @author Created by Yani on 2019/09/02
 */
public class Solution617 {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if (t1 == null && t2 == null) {
            return null;
        }

        if (t1 == null) {
            return t2;
        }

        if (t2 == null) {
            return t1;
        }

        TreeNode node = new TreeNode(t1.val + t2.val);

        node.left = mergeTrees(t1.left, t2.left);
        node.right = mergeTrees(t1.right, t2.right);
        return node;
    }

}
