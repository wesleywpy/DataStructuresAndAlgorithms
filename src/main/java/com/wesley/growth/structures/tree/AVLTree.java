package com.wesley.growth.structures.tree;

import java.util.ArrayList;
import java.util.Objects;

/**
 * <p>
 *
 * </p>
 * Email yani@uoko.com
 *
 * @author Created by Yani on 2019/09/20
 */
public class AVLTree <K extends Comparable<K>, V> {

    /**
     * 根节点
     */
    private Node<K,V> root = null;

    private int size;

    public AVLTree() {
        this.size = 0;
    }

    /**
     * 添加新元素
     */
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    public V get(K key){
        Node node = getNode(root, key);
        return node == null ? null : (V) node.value;
    }

    public void set(K key, V newValue){
        Node node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException(key + " doesn't exist!");
        }

        node.value = newValue;
    }

    /**
     * 是否存在
     */
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @return 是否是 二分搜索树
     */
    public boolean isBST() {
        ArrayList<K> list = new ArrayList<>();
        inOrder(root, list);
        // 中序遍历之后 元素是按从小到大排序的
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1).compareTo(list.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * @return 是否是 平衡二叉树
     */
    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node<K, V> node) {
        if (node == null) {
            return true;
        }

        int balanceFactor = getBalanceFactor(node);
        if (balanceFactor > 1) {
            return false;
        }

        return isBalanced(node.left) && isBalanced(node.right);
    }

    private void inOrder(Node<K, V> node, ArrayList<K> list) {
        if (node == null) {
            return;
        }

        inOrder(node.left, list);
        list.add(node.key);
        inOrder(node.right, list);
    }

    /**
     * @return 返回以node为根节点的二分搜索树中，key所在的节点
     */
    private Node<K, V> getNode(Node<K, V> node, K key) {
        if (node == null) {
            return null;
        }

        int cr = key.compareTo(node.key);
        // key 大于 当前节点
        if (cr > 0) {
            return getNode(node.right, key);
        }
        // key 小于 当前节点
        else if (cr < 0) {
            return getNode(node.left, key);
        } else {
            return node;
        }
    }

    /**
     * 向以node为根的二叉搜索树中,插入节点(key, value)
     * @param node 递归节点
     * @return 返回插入新节点后的二叉搜索树的根
     */
    private Node<K, V> add(Node<K, V> node, K key, V value) {
        if (Objects.isNull(node)) {
            size ++;
            return new Node<>(key, value);
        }

        int cr = key.compareTo(node.key);
        // 插入节点key 大于 当前节点key
        if (cr > 0) {
            node.right = add(node.right, key, value);
        }
        // 插入节点key 小于 当前节点key
        else if (cr < 0) {
            node.left = add(node.left, key, value);
        }
        // 插入节点key 等于 当前节点key
        else {
            node.value = value;
        }

        // 更新节点的高度
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        // 计算平衡因子
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1) {
            System.out.println("不平衡 : " + balanceFactor);
        }

        // 平衡维护
        // LL
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
            return rightRotate(node);
        }

        // RR
        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0) {
            return leftRotate(node);
        }

        // LR
        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RL
        if (balanceFactor > -1 && getBalanceFactor(node.left) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    /**
     * @return 返回节点的高度
     */
    private int getHeight(Node<K,V> node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    /**
     * 平衡因子 等于 当前节点左右子树高度之差
     * @return 返回节点的平衡因子
     */
    private int getBalanceFactor(Node<K,V> node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    // 对节点y进行向右旋转操作，返回旋转后新的根节点x
    //        y                              x
    //       / \                           /   \
    //      x   T4     向右旋转 (y)        z     y
    //     / \       - - - - - - - ->    / \   / \
    //    z   T3                       T1  T2 T3 T4
    //   / \
    // T1   T2
    private Node<K, V> rightRotate(Node<K, V> y) {
        Node<K,V> x = y.left;
        Node<K,V> t3 = x.right;

        // 向右旋转过程
        x.right = y;
        y.left = t3;

        // 更新高度
        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));
        x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));

        return x;
    }

    // 对节点y进行向左旋转操作，返回旋转后新的根节点x
    //    y                             x
    //  /  \                          /   \
    // T1   x      向左旋转 (y)       y     z
    //     / \   - - - - - - - ->   / \   / \
    //   T2  z                     T1 T2 T3 T4
    //      / \
    //     T3 T4
    private Node<K, V> leftRotate(Node<K, V> y) {
        Node<K, V> x = y.right;
        Node<K, V> t2 = x.left;

        // 向左旋转
        x.left = y;
        y.right = t2;

        // 更新高度
        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));
        x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));

        return x;
    }

    private class Node<K, V> {
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
