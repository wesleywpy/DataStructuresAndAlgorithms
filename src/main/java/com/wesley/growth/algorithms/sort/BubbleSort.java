package com.wesley.growth.algorithms.sort;

/**
 * 冒泡排序
 * @author Wesley Created By 2018/8/14
 */
public class BubbleSort extends AbstractSort {

    @Override
    public void sort(int[] arr) {
        int len = arr.length;
        boolean flag = true;
        for(int i = 0; i < len - 1 && flag; i ++){
            flag = false;
            for(int j = 0; j < len - 1 - i; j ++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] =  arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
        }
    }
}
