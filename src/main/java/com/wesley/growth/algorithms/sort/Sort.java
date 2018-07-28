package com.wesley.growth.algorithms.sort;

/**
 * @author Created by Wesley on 2018/7/27.
 */
public interface Sort {

    void sort(int[] arr);

    <T extends Comparable<T>> void sort(T[] arr);

}
