package com.wesley.growth.structures.heap;

import java.util.Arrays;

/**
 * <p>
 *  最大堆, 用数组存储
 * </p>
 *
 * @author Wesley
 * Created by 2018/08/30
 */
public class MaxHeap<E extends Comparable<E>> {

    /**
     * 空数据
     */
    private static final Object[] EMPTY_ELEMENTDATA = {};

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    /**
     * 从下标为1存储数据
     */
    private Object[] elementData;

    /**
     * 初始化容量
     */
    private int initialCapacity;

    /**
     * 存储的元素数量
     */
    private int size;

    public MaxHeap(int initialCapacity){
        if (initialCapacity > 0) {
            // elementData[0] 不存储数据
            this.elementData = new Object[initialCapacity + 1];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+ initialCapacity);
        }
    }

    public boolean insert(E e){
        ensureCapacityInternal(size + 1);
        this.elementData[size + 1] = e;
        size++;
        shiftUp(size);
        return true;
    }

    /**
     * 上移元素
     * @param index 数组下标
     */
    private void shiftUp(int index) {
        int parentIndex = index/2;
        Comparable parentElement = (Comparable) elementData[parentIndex];
        Comparable element = (Comparable) elementData[index];
        // 父节点小于子节点 交互位置
        while(index > 1 && parentElement.compareTo(element) < 0){
            swap(elementData, parentIndex, index);
            index /= 2;
        }
    }

    private void swap(Object[] arr, int i, int j){
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void print(){
        for (int i = 1; i < this.size; i++) {
            System.out.print(this.elementData[i]);
        }
    }

    /**
     * 保证数组容量足够
     */
    private void ensureCapacityInternal(int minCapacity){
        if (minCapacity - elementData.length > 0){
            grow(minCapacity);
        }
    }

    /**
     * 扩容
     */
    private void grow(int minCapacity) {
        int oldCapacity = elementData.length;
        // 扩展原容量的一半
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if ((newCapacity - minCapacity) < 0){
            newCapacity = minCapacity;
        }
        if ((newCapacity - MAX_ARRAY_SIZE) > 0){
            newCapacity = hugeCapacity(minCapacity);
        }

        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) {
            throw new OutOfMemoryError();
        }

        return (minCapacity > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
    }
}
