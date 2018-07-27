package com.wesley.growth.algorithms.sort;

/**
 * @author Created by Wesley on 2018/7/27.
 */
public class SelectionSort implements Sort {

    @Override
    public void sort(int[] array){
        System.out.println("选择排序开始...");

        for (int i = 0; i < array.length; i ++) {

            for(int j = i; j < array.length; j++){
                if(array[j] < array[i]){
                    int swap = array[i];
                    array[i] = array[j];
                    array[j] = swap;
                }
            }
        }
    }

}
