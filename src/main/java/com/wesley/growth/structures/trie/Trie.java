package com.wesley.growth.structures.trie;

import java.util.Objects;
import java.util.TreeMap;

/**
 * <p>
 * 字典树
 * </p>
 * Email yani@uoko.com
 *
 * @author Created by Yani on 2019/09/10
 */
public class Trie {

    private Node root;

    /**
     * 单词数量
     */
    private int size;


    public Trie() {
        this.root = new Node();
        this.size = 0;
    }

    /**
     * 添加一个单词
     */
    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            Node node = cur.next.get(c);
            if (Objects.isNull(node)) {
                node = new Node();
                cur.next.put(c, node);
            }

            cur = node;
        }

        if (!cur.isWord) {
            cur.isWord = true;
            this.size++;
        }
    }

    /**
     * 单词是否存在
     */
    public boolean contains(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            Node node = cur.next.get(c);
            if (Objects.isNull(node)) {
                return false;
            }
            cur = node;
        }

        return cur.isWord;
    }

    public boolean startsWtih(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            Node node = cur.next.get(c);
            if (Objects.isNull(node)) {
                return false;
            }
            cur = node;
        }
        return true;
    }

    public int size() {
        return this.size;
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
