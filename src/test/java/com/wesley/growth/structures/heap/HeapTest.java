package com.wesley.growth.structures.heap;

import com.wesley.growth.algorithms.sort.util.SortTestHelper;
import org.junit.Test;

/**
 * <p>
 *
 * </p>
 *
 * @author Wesley
 * Created by 2018/08/30
 */
public class HeapTest {

    @Test
    public void insertTest(){
        Integer[] integers = SortTestHelper.generateRandomIntegerArray(31, 0, 100);
        MaxHeap<Integer> heap = new MaxHeap<Integer>(integers);

        heap.print();
        heap.printAsTree();

        while (!heap.isEmpty()){
            System.out.print(heap.extractMax() + " ");
        }
    }
}
