package com.wesley.growth.structures.tree;

/**
 * <p>
 * 线段树, 底层使用数组存储
 * </p>
 * Email yani@uoko.com
 *
 * @author Created by Yani on 2019/08/29
 */
public class SegementTree<E> {

    private E[] tree;
    private E[] data;

    public SegementTree(E[] arr) {
        data = (E[])new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }

        // 数组存储, 最坏情况需要 4倍 节点数量的空间
        tree = (E[])new Object[4 * arr.length];
        buildSegementTree(0, 0, arr.length - 1);
    }

    /**
     * 在treeIndex的位置创建表示区间[left...right]的线段树
     * @param treeIndex 数组的索引
     * @param left 数组左边界
     * @param right 数组右边界
     */
    private void buildSegementTree(int treeIndex, int left, int right) {

        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        // int mid = (left + right) / 2; 存在Int类型长度溢出问题
        int mid = left + (right - left) / 2 ;

    }

    public int size() {
        return data.length;
    }

    /**
     * 获取元素
     */
    public E get(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index is illegal.");
        }
        return data[index];
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
     */
    private int leftChild(int index){
        return 2*index + 1;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
     */
    private int rightChild(int index){
        return 2*index + 2;
    }

}
