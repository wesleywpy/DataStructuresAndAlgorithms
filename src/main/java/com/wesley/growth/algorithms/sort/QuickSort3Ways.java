package com.wesley.growth.algorithms.sort;

import java.util.Random;

/**
 * 三路快速排序
 * @author Created by Wesley on 2018/8/17.
 */
public class QuickSort3Ways extends AbstractSort{

    private final Random random = new Random();

    @Override
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int left, int right) {
        if(left >= right){
            return;
        }

        // 随机选取区间中的一个数为基准数。
        int randomIndex = random.nextInt(right - left + 1) + left;
        swap(arr, left, randomIndex);
        int v = arr[left];

        // arr[left+1 ... lt] < v
        int lt = left;
        // arr[gt...r] > v
        int gt = right + 1;
        // arr[left+1 ... i] == v
        int i = left + 1;

        while (i < gt){
            // e < v, e和==v部分的第一个元素交换, e就放入 <V 的部分
            if(arr[i] < v){
                swap(arr, i, lt+1);
                lt++;
                i++;
            }
            // e > v, e 和 gt-1 位置的元素交换, e就放入 >V 部分第一元素
            else if(arr[i] > v){
                swap(arr, i, gt-1);
                gt --;
            }else {
                i++;
            }
        }

        swap(arr, left, lt);
        quickSort(arr, left, lt - 1);
        quickSort(arr, gt, right);
    }

}
