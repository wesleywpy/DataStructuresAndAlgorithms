package com.wesley.growth.leetcode.tree;

/**
 * <p>
 *
 * </p>
 * Email yani@uoko.com
 *
 * @author Created by Yani on 2019/09/30
 */
public class Solution1038 {

    public TreeNode bstToGst(TreeNode root) {
        if (root == null) {
            return root;
        }

        count(root, 0);
        return root;
    }

    /**
     * 思路: dfs(深度优先搜索) 逆中序遍历
     */
    private int count(TreeNode root, int sum) {
        if (root == null) {
            return sum;
        }

        // 将从右子树返回的sum累加到当前节点的值
        int count = count(root.right, sum);

        root.val = root.val + count;

        int leftVal = count(root.left, root.val);
        // 把左中右三个节点里最后一个遍历的左子节点的返回值，返回给下一层
        return leftVal;
    }
}
