package com.wesley.growth.algorithms.sort;

/**
 * 插入排序, 特点是提前终止内层循环
 * @author Wesley Created By 2018/8/13
 */
public class InsertionSort extends AbstractSort{

    @Override
    public void sort(int[] arr) {

        for (int i = 1; i < arr.length; i++){

//            for(int j = i; j > 0 && arr[j-1] > arr[j]; j --){
//                int temp = arr[j];
//                arr[j] = arr[j-1];
//                arr[j-1] = temp;
//            }

            // 减少赋值次数,提高效率
            int e = arr[i];
            int j;
            for(j = i; j > 0 && arr[j-1] > e; j --){
                arr[j] = arr[j-1];
            }
            arr[j] = e;
        }

    }

}
