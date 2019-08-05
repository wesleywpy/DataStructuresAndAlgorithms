package com.wesley.growth.algorithms.sort;

import com.wesley.growth.algorithms.sort.util.SortTestHelper;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Created by Wesley on 2018/7/27.
 */
public class SortTest {

    @Test
    public void selectSort() throws Exception {
        Integer[] randomArray1 = SortTestHelper.generateRandomIntegerArray(50000, 0, 50000);
        Integer[] randomArray2 = SortTestHelper.generateRandomIntegerArray(50000, 0, 50000);
        SortTestHelper.testSort(new SelectionSort(), randomArray1);
        System.out.println("------------");
        SortTestHelper.testSort(new MergeSort(), randomArray2);
    }

    @Test
    public void selectSort2() throws Exception {
        String[] arr = {"A", "C", "Z", "B", "D", "E"};
        SortTestHelper.testSort(new SelectionSort(), arr);
        SortTestHelper.print(arr);
    }

    @Test
    public void insertionSort(){
        int[] array1 = SortTestHelper.generateRandomIntArray(50000, 0, 50000);
        int[] array2 = Arrays.copyOf(array1, array1.length);

        SortTestHelper.testSort(new InsertionSort(), array1);
        SortTestHelper.testSort(new SelectionSort(), array2);
    }

    /**
     * 近乎有序的数组, 排序算法性能比较
     */
    @Test
    public void compareWithNearlyOrderedArray(){
        int[] array1 = SortTestHelper.generateNearlyOrderedArray(500000, 1000);
        int[] array2 = Arrays.copyOf(array1, array1.length);
        SortTestHelper.testSort(new QuickSort(), array1);
        SortTestHelper.testSort(new MergeSort(), array2);
    }

    /**
     * 大量重复元素, 排序算法性能比较
     */
    @Test
    public void compareWithRepeatArray(){
        int[] array1 = SortTestHelper.generateRandomIntArray(500000, 0, 50);
        int[] array2 = Arrays.copyOf(array1, array1.length);
        SortTestHelper.testSort(new QuickSort(), array1);
        SortTestHelper.testSort(new MergeSort(), array2);
    }


    @Test
    public void heapSort(){
//        int[] array = SortTestHelper.generateRandomIntArray(500000, 0, 500000);
        int[] array = {3, 9, 6, 5, 2, 8, 7};
        SortTestHelper.testSort(new QuickSort(), array);
        SortTestHelper.print(array);
    }

    /**
     * 综合比较
     */
    @Test
    public void comprehensiveComparison(){
        MergeSort mergeSort = new MergeSort();
        QuickSort quickSort = new QuickSort();
        QuickSort3Ways quickSort3Ways = new QuickSort3Ways();
        HeapSort heapSort = new HeapSort();

        System.out.println(" --------------- 一般性随机序列");
        int[] array1 = SortTestHelper.generateRandomIntArray(500000, 0, 500000);
        int[] array2 = Arrays.copyOf(array1, array1.length);
        int[] array3 = Arrays.copyOf(array1, array1.length);
        int[] array4 = Arrays.copyOf(array1, array1.length);

        SortTestHelper.testSort(mergeSort, array1);
        SortTestHelper.testSort(quickSort, array2);
        SortTestHelper.testSort(quickSort3Ways, array3);
        SortTestHelper.testSort(heapSort, array4);

        System.out.println(" --------------- 大量重复元素的序列");

        array1 = SortTestHelper.generateRandomIntArray(500000, 0, 50);
        array2 = Arrays.copyOf(array1, array1.length);
        array3 = Arrays.copyOf(array1, array1.length);
        array4 = Arrays.copyOf(array1, array1.length);

        SortTestHelper.testSort(mergeSort, array1);
        SortTestHelper.testSort(quickSort, array2);
        SortTestHelper.testSort(quickSort3Ways, array3);
        SortTestHelper.testSort(heapSort, array4);

        System.out.println(" --------------- 近乎有序的序列");

        array1 = SortTestHelper.generateNearlyOrderedArray(500000, 100);
        array2 = Arrays.copyOf(array1, array1.length);
        array3 = Arrays.copyOf(array1, array1.length);
        array4 = Arrays.copyOf(array1, array1.length);

        SortTestHelper.testSort(mergeSort, array1);
        SortTestHelper.testSort(quickSort, array2);
        SortTestHelper.testSort(quickSort3Ways, array3);
        SortTestHelper.testSort(heapSort, array4);
    }


}