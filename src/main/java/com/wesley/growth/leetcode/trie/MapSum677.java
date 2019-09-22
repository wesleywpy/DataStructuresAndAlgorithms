package com.wesley.growth.leetcode.trie;

import java.util.TreeMap;

/**
 * <p>
 * LeetCode 677 键值映射
 * </p>
 * Email yani@uoko.com
 *
 * @author Created by Yani on 2019/09/12
 */
public class MapSum677 {

    private Node root;

    public MapSum677() {
        root = new Node();
    }

    public void insert(String key, int val) {
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            Node node = cur.next.get(c);
            if (node == null) {
                node = new Node();
                cur.next.put(c, node);
            }
            cur = node;
        }

        cur.val = val;
    }

    public int sum(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            Node node = cur.next.get(c);
            if (node == null) {
                return 0;
            }
            cur = node;
        }
        return sum(cur);
    }

    /**
     * 遍历 node 以及 node的所有子节点的 value 值并求和
     */
    private int sum(Node node) {
        int result = node.val;

        for (Character character : node.next.keySet()) {
            result += sum(node.next.get(character));
        }

        return result;
    }

    private class Node {
        int val;

        /**
         * 每个节点有若干指向下个节点的指针
         */
        TreeMap<Character, Node> next;

        Node() {
            this(0);
        }

        Node(int value) {
            this.val = value;
            this.next = new TreeMap<>();
        }

    }

}
