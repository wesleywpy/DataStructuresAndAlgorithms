package com.wesley.growth.algorithms.sort;

import com.wesley.growth.algorithms.sort.util.SortTestHelper;
import static org.junit.Assert.*;
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

}