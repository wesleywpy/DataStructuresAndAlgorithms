package com.wesley.growth.leetcode.trie;

import java.util.TreeMap;

/**
 * <p>
 *
 * </p>
 * Email yani@uoko.com
 *
 * @author Created by Yani on 2019/09/11
 */
public class WordDictionary211 {

    private Node root;

    public WordDictionary211() {
        root = new Node();
    }

    public void addWord(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            Node node = cur.next.get(c);
            if (node == null) {
                node = new Node();
                cur.next.put(c, node);
            }

            cur = node;
        }

        if (!cur.isWord) {
            cur.isWord = true;
        }
    }

    /**
     * 可以搜索文字或正则表达式字符串，字符串只包含字母 . ( . 可以表示任何一个字母) 或 a-z
     */
    public boolean search(String word) {
        return match(root, word, 0);
    }

    private boolean match(Node node, String word, int index) {
        if (index == word.length()) {
            return node.isWord;
        }

        char c = word.charAt(index);

        if ('.' == c) {
            for (char character : node.next.keySet()) {
                Node next = node.next.get(character);
                if (next != null && match(next, word, index + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            if (null == node.next.get(c)) {
                return false;
            }
            return match(node.next.get(c), word, index + 1);
        }
    }

    private class Node {
        /**
         * 是否是一个单词
         */
        boolean isWord;

        /**
         * 每个节点有若干指向下个节点的指针
         */
        TreeMap<Character, Node> next;

        Node() {
            this(false);
        }

        Node(boolean isWord) {
            this.isWord = isWord;
            this.next = new TreeMap<>();
        }

    }
}
