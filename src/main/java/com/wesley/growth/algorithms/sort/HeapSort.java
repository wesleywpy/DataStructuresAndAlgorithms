package com.wesley.growth.algorithms.sort;

import com.wesley.growth.structures.heap.MaxHeap;

/**
 * <p>
 * 堆排序
 * </p>
 *
 * @author Wesley
 * Created by 2018/08/31
 */
public class HeapSort extends AbstractSort {

    /**
     * 从下标0开始, 原地堆排序, 不产生额外内存空间
     * parent(i) = (i-1) / 2
     * left child (i) = 2*i + 1
     * right child (i) = 2*i + 2
     * 最后一个非叶子节点的索引: (count - 1) / 2
     */
    @Override
    public void sort(int[] arr) {

        // 将数组二叉堆化, 堆中每个节点的值都不大于其父节点的值（大顶堆）
        for(int i = (arr.length - 1) / 2; i >= 0; i--){
            shiftDown(arr, i, arr.length);
        }

        for(int i = arr.length - 1; i > 0; i--){
            swap(arr,0, i);
            shiftDown(arr, 0, i);
        }
    }

    /**
     * @param index 下标
     * @param n 最后一个非叶子节点的索引
     */
    private void shiftDown(int[] arr, int index, int n){
        // 存在左子节点
        while( (2*index + 1) < n){
            int left = 2 * index + 1;
            int right = left + 1;
            // 存在右节点并且大于左节点
            if( right < n && (arr[right] > arr[left])){
                left = right;
            }

            // 如果父节点大于等于子节点
            if(arr[index] >= (arr[left])){
                break;
            }

            swap(arr, index, left);
            index = left;
        }
    }


    /**
     * 使用堆结构
     */
    @Override
    public <T extends Comparable<T>> void sort(T[] arr) {
        MaxHeap<T> heap = new MaxHeap<>(arr);
        for(int i = arr.length - 1; i >= 0; i --){
            arr[i] = heap.extractMax();
        }
    }
}
