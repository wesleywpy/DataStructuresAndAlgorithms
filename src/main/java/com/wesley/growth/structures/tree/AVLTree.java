package com.wesley.growth.structures.tree;

/**
 * AVL树，对于任意一个节点，左右子树的高度之差<=1。
 * @author Created by Wesley on 2019/9/19
 */
public class AVLTree<K extends Comparable<K>, V> {

    /**
     * 根节点
     */
    private Node<K,V> root = null;

    /**
     * 节点数量
     */
    private int count;

    public AVLTree() {
        this.count = 0;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    private class Node<K,V>{
        K key;
        V value;
        Node<K,V> left, right;
        /**
         * 每个节点的高度
         */
        int height;

        Node(K key, V value){
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }

        Node<K,V> copy(){
            return new Node<>(key, value);
        }

    }

}
