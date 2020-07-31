package com.wesley.growth.leetcode.tree.medium;

import com.wesley.growth.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 *  例如，从根到叶子节点路径 1->2->3 代表数字 123。
 *  计算从根到叶子节点生成的所有数字之和。
 *  说明: 叶子节点是指没有子节点的节点。
 * </p>
 *
 * 示例 1:
 * 输入: [1,2,3]
 *     1
 *    / \
 *   2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 *
 * @author Created by Yani on 2020/07/31
 */
public class Solution129 {

    public int sumNumbers(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        sum(root, "", res);
        return res.stream()
                  .reduce((v1, v2) -> v1 + v2)
                  .orElse(0);
    }

    private void sum(TreeNode root, String nums, List<Integer> vals) {
        if (root == null) {
            return ;
        }

        if (root.left == null && root.right == null) {
            vals.add(Integer.valueOf(nums.concat(String.valueOf(root.val))));
            return ;
        }

        // 连接数字
        String str = nums.concat(String.valueOf(root.val));
        sum(root.left, str, vals);
        sum(root.right, str, vals);
    }

    public int helper(TreeNode root, int i){
        if (root == null) {
            return 0;
        }
        // 每一层 进一位
        int temp = i * 10 + root.val;
        if (root.left == null && root.right == null){
            return temp;
        }
        return helper(root.left, temp) + helper(root.right, temp);
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{4, 9, 0, 5, 1};
        int res = new Solution129().sumNumbers(TreeNode.build(arr));
        System.out.println(res);
    }

}
