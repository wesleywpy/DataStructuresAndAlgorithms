package com.wesley.growth.structures.tree;

import java.util.Objects;

/**
 * <p>
 * Binary Search Tree
 * <ul>
 *  <li>是一颗二叉树，不一定是完全二叉树</li>
 *  <li>若左子树不为空，每个节点的键值大于左孩子</li>
 *  <li>若右子树不为空，每个节点的键值小于右孩子</li>
 *  <li>以左右孩子为根的子树仍符合以上性质。</li>
 * </ul>
 * </p>
 *  <p>
 *      Email yani@uoko.com
 *  </p>
 * @author Created by Yani on 2018/10/18
 */
public class BSTree<K extends Comparable<K>,V> {

    /**
     * 根节点
     */
    private Node<K,V> root = null;

    private int count;

    public BSTree() {
        this.count = 0;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void insert(K key, V value){
        if(Objects.isNull(root)) {
            count ++;
            root = new Node<>(key, value);
        } else {
            insert(root, key, value);
        }
    }

    public boolean contains(K key){
        return contains(root, key);
    }

    public V search(K key){
        return search(root, key);
    }

    public void traverse(){
        preOrder(root);
    }

    public K minimum(){
        assert count != 0;
        Node<K,V> minNode = minimum(root);
        return minNode.key;
    }

    public K maximum(){
        assert count != 0;
        Node<K,V> maxNode = maximum(root);
        return maxNode.key;
    }

    public void remove(K key){
        root = remove(root, key);
    }

    /**
     * 向以node为根的二叉搜索树中,插入节点(key, value)
     * @param node 递归节点
     * @return 返回插入新节点后的二叉搜索树的根
     */
    private Node<K,V> insert(Node<K,V> node, K key, V value){

        if (Objects.isNull(node)){
            count ++;
            return new Node<>(key, value);
        }

        int result = key.compareTo(node.key);
        if(result == 0) {
            node.key = key;
            node.value = value;
        } else if (result < 0) {
            // 左子树递归
            node.left = insert(node.left, key, value);
        } else {
            // 右子树递归
            node.right = insert(node.right, key, value);
        }

        return node;

    }

    /**
     * 插入操作非递归实现
     */
    private void insertNonRecursive(K key, V value){
        if(root.key.equals(key)){
            return;
        }

        Node<K,V> parentNode = root;
        Node<K,V> currentNode = root;

        // 从root节点向下遍历
        while(Objects.nonNull(currentNode)){
            parentNode = currentNode;

            int result = key.compareTo(currentNode.key);
            if(0 == result){
                return;
            }else if (result < 0) {
                // 当前节点小于key, 向左
                currentNode = currentNode.left;
            }else{
                currentNode = currentNode.right;
            }
        }
        if(parentNode.key.compareTo(key) < 0){
            parentNode.left = new Node<>(key, value);
        }else{
            parentNode.right = new Node<>(key, value);
        }

    }

    /**
     * 查看以node为根的二叉搜索树中是否包含键值为key的节点
     */
    private boolean contains(Node<K, V> node, K key) {
        if (Objects.isNull(node)) {
            return false;
        }

        int result = node.key.compareTo(key);
        if(result == 0) {
            return true;
        } else if (result < 0) {
            return contains(node.left, key);
        } else {
            return contains(node.right, key);
        }
    }

    /**
     * 在以node为根的二叉搜索树中查找key所对应的value
     */
    private V search(Node<K, V> node, K key){
        if (Objects.isNull(node)) {
            return null;
        }

        int result = node.key.compareTo(key);
        if(result == 0) {
            return node.value;
        } else if (result < 0) {
            return search(node.left, key);
        } else {
            return search(node.right, key);
        }
    }

    /**
     * 对以node为根的二叉搜索树进行前序遍历
     */
    private void preOrder(Node<K,V> node){
        if(Objects.nonNull(node)){
            System.out.println(node.key);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * 对以node为根的二叉搜索树进行中序遍历
     */
    private void inOrder(Node<K,V> node){
        if(Objects.nonNull(node)){
            inOrder(node.left);
            System.out.println(node.key);
            inOrder(node.right);
        }
    }

    /**
     * 对以node为根的二叉搜索树进行后序遍历
     */
    private void postOrder(Node<K,V> node){
        if(Objects.nonNull(node)){
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.key);
        }
    }

    /**
     * 在以node为根的二叉搜索树中,返回最小键值的节点
     */
    private Node<K,V> minimum(Node<K,V> node){
        if(Objects.isNull(node.left)){
            return node;
        }

        return minimum(node.left);
    }

    /**
     * 在以node为根的二叉搜索树中,返回最大键值的节点
     */
    private Node<K,V> maximum(Node<K,V> node){
        if(Objects.isNull(node.right)){
            return node;
        }

        return minimum(node.right);
    }

    /**
     * 删除掉以node为根的二分搜索树中键值为key的节点
     * 返回删除节点后新的二分搜索树的根
     */
    private Node<K,V> remove(Node<K,V> node, K key){
        if(Objects.isNull(node)) {
            return null;
        }




        return node;
    }

    /**
     * 删除掉以node为根的二分搜索树中的最小节点
     * 返回删除节点后新的二分搜索树的根
     */
    private Node<K, V> removeMin(Node<K,V> node){
        if(Objects.isNull(node.left)){
            Node<K, V> result = node.right;
            node = null;
            count --;
            return result;
        }

        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 删除掉以node为根的二分搜索树中的最大节点
     * 返回删除节点后新的二分搜索树的根
     */
    private Node<K, V> removeMax(Node<K,V> node){

        Node<K, V> parentNode = node;
        Node<K, V> currentNode = node;

        while(Objects.nonNull(currentNode)){

            if(Objects.isNull(currentNode.right)){
                // 当前节点是最大节点
                parentNode.right = currentNode.left;
                count --;
                break;
            }

            parentNode = currentNode;
            currentNode = currentNode.right;
        }

        return node;
    }


    static class Node<K,V>{
        K key;
        V value;
        Node<K,V> left;
        Node<K,V> right;

        Node(K key, V value){
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }



}
