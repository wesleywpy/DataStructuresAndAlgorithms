package com.wesley.growth.algorithms.sort;

/**
 * 冒泡排序
 * @author Wesley Created By 2018/8/14
 */
public class BubbleSort extends AbstractSort {

    /**
     * 稳定
     * 时间复杂度 平均 O(n^2) 最好 O(n) 最坏 O(n^2)
     * 空间复杂度 O(1)
     **/
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
