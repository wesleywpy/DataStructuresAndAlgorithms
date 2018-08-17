package com.wesley.growth.algorithms.sort;

import com.wesley.growth.algorithms.sort.util.SortTestHelper;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;
import java.util.Random;

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

    /**
     * 三路快速排序
     */
    @Test
    public void quickSort3Ways(){
        // 大量重复元素的序列
//        int[] array1 = SortTestHelper.generateRandomIntArray(500000, 0, 50);
        // 近乎有序的序列
//        int[] array1 = SortTestHelper.generateNearlyOrderedArray(500000, 100);
        int[] array1 = SortTestHelper.generateRandomIntArray(500000, 0, 500000);
        int[] array2 = Arrays.copyOf(array1, array1.length);
        int[] array3 = Arrays.copyOf(array1, array1.length);

        SortTestHelper.testSort(new MergeSort(), array1);
        SortTestHelper.testSort(new QuickSort(), array2);
        SortTestHelper.testSort(new QuickSort3Ways(), array3);
    }


    @Test
    public void test(){
        Random random = new Random();
        for(int i = 0; i < 100; i++){
            System.out.println(random.nextInt(1));
        }
    }

}