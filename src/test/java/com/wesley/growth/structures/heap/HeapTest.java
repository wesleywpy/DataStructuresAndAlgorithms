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
        MaxHeap<Integer> heap = new MaxHeap<Integer>(16);
        for (Integer integer : SortTestHelper.generateRandomIntegerArray(16, 0, 100)) {
            heap.insert(integer);
        }
        heap.printAsTree();
        heap.print();
    }
}
