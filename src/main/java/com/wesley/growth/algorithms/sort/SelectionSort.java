package com.wesley.growth.algorithms.sort;

import java.util.Arrays;

/**
 * @author Created by Wesley on 2018/7/27.
 */
public class SelectionSort implements Sort {

    @Override
    public void sort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] < (arr[minIdx])){
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                int swap = arr[i];
                arr[i] = arr[minIdx];
                arr[minIdx] = swap;
            }
            System.out.println("第" + i + "趟 list:" + Arrays.toString(arr));
        }
    }


    @Override
    public <T extends Comparable<T>> void sort(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j].compareTo(arr[minIdx]) < 0){
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                T swap = arr[i];
                arr[i] = arr[minIdx];
                arr[minIdx] = swap;
            }
        }
    }
}
