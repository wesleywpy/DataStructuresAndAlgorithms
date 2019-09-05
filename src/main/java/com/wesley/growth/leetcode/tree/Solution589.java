package com.wesley.growth.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <p>
 *
 * </p>
 * Email yani@uoko.com
 *
 * @author Created by Yani on 2019/09/05
 */
public class Solution589 {

    /**
     * N叉树的前序遍历
     */
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        return preOrder(root, result);
    }

    private List<Integer> preOrder(Node root, List<Integer> result) {
        if (root == null) {
            return result;
        }

        result.add(root.val);
        for (Node node : root.children) {
            preOrder(node, result);
        }

        return result;
    }

    /**
     * 递归实现前序遍历
     */
    private List<Integer> preOrderIter(Node root, List<Integer> result) {
        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            // 利用栈后进先出特点
            Node node = stack.pop();
            result.add(node.val);

            List<Node> children = node.children;
            for (int i = children.size() - 1; i >= 0; i--) {
                stack.push(children.get(i));
            }
        }

        return result;
    }

    private class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    };
}
