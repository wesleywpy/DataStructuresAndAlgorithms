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

    @Override
    public void sort(int[] arr) {
        Integer[] array = new Integer[arr.length];
        for(int i = 0; i < arr.length; i ++){
            array[i] = arr[i];
        }

        sort(array);

        for(int i = 0; i < array.length; i ++){
            arr[i] = array[i];
        }
    }

    @Override
    public <T extends Comparable<T>> void sort(T[] arr) {
        MaxHeap<T> heap = new MaxHeap<>(arr);
        for(int i = arr.length - 1; i >= 0; i --){
            arr[i] = heap.extractMax();
        }
    }
}
