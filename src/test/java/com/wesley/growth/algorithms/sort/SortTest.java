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
        int[] randomArray = SortTestHelper.generateRandomArray(10000, 0, 10000);
        SortTestHelper.testSort(new SelectionSort(), randomArray);
    }

}