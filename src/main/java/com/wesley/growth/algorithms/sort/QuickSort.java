package com.wesley.growth.algorithms.sort;

/**
 * 快速排序
 * @author Created by Wesley on 2018/8/16.
 */
public class QuickSort extends AbstractSort {

    @Override
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * 对arr[l...r]部分进行快速排序
     */
    private void quickSort(int[] arr, int left, int right){
        if (left >= right) {
            return;
        }

        int p = parition(arr, left, right);
        // 左区间
        quickSort(arr, left, p - 1);
        // 右区间
        quickSort(arr, p + 1, right);
    }

    /**
     * // 返回p, 使得arr[left...p-1] < arr[p] ; arr[p+1...right] > arr[p]
     * @return 基准数的位置
     */
    private int parition(int[] arr, int left, int right) {

        // 取区间第一个数为基准数。
        int pivot = arr[left];
        int p = left;

        for(int i = p + 1; i <= right; i++){
            if(arr[i] < pivot){
                p++;
                swap(arr, p, i);
            }
        }

        swap(arr, left, p);
        return p;
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
