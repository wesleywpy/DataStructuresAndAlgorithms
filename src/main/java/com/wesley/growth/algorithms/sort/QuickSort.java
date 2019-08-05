package com.wesley.growth.algorithms.sort;

import java.util.Random;

/**
 * 快速排序
 * @author Created by Wesley on 2018/8/16.
 */
public class QuickSort extends AbstractSort {
    private final Random random = new Random();

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

        int p = parition2(arr, left, right);
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
        // 随机选取区间中的一个数为基准数。
        int randomIndex = random.nextInt(right - left + 1) + left;
        swap(arr, left, randomIndex);

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

    /**
     * 双路快速排序, 应对数列中有大量重复元素导致复杂度退化为O(n^2)的问题
     */
    private int parition2(int[] arr, int left, int right) {
        // 随机选取区间中的一个数为基准数。
        int randomIndex = random.nextInt(right - left + 1) + left;

        swap(arr, left, randomIndex);

        int pivot = arr[left];
        int i = left + 1;
        int j = right;

        while (true){
            while(i <= right && arr[i] < pivot){
                i++;
            }

            while(j > (left + 1) && arr[j] > pivot){
                j--;
            }

            if( i > j){
                break;
            }

            swap(arr, i, j);
            i++;
            j--;
        }

        swap(arr, left, j);
        return j;
    }
}
