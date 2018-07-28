package com.wesley.growth.algorithms.sort;

import com.wesley.growth.algorithms.sort.util.SortTestHelper;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author Created by Wesley on 2018/7/27.
 */
public class SortTest {

    @Test
    public void selectSort() throws Exception {
        Integer[] randomArray1 = SortTestHelper.generateRandomArray(50000, 0, 50000);
        Integer[] randomArray2 = SortTestHelper.generateRandomArray(50000, 0, 50000);
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


}