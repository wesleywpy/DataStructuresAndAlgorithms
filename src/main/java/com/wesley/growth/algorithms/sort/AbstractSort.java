package com.wesley.growth.algorithms.sort;

/**
 * @author Wesley Created By 2018/8/13
 */
public abstract class AbstractSort implements Sort{

    @Override
    public void sort(int[] arr) {
        Integer[] result = new Integer[arr.length];
        for (int i = 0; i < arr.length; i ++){
            result[i] = arr[i];
        }

        this.sort(result);

        for (int i = 0; i < arr.length; i ++){
            arr[i] = result[i];
        }
    }

    @Override
    public <T extends Comparable<T>> void sort(T[] arr) {
        throw new UnsupportedOperationException();
    }

    void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
