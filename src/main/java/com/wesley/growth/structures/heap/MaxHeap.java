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

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    /**
     * 从下标为1存储数据
     */
    private E[] elementData;

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
            this.elementData = (E[]) new Comparable[initialCapacity + 1];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+ initialCapacity);
        }
    }

    public MaxHeap(E[] datas){
        // heapify 堆化
        this.initialCapacity = datas.length;

        this.elementData = (E[]) new Comparable[initialCapacity + 1];
        for(int i = 0; i < datas.length; i++){
            elementData[i + 1] = datas[i];
        }

        this.size = datas.length;
        // 第一个非叶子节点位置: 元素个数 / 2 .
        for(int i = size / 2; i >= 1; i --){
            shiftDown(i);
        }
    }

    public boolean insert(E e){
        ensureCapacityInternal(size + 1);
        this.elementData[size + 1] = e;
        size++;
        shiftUp(size);
        return true;
    }

    public E extractMax(){
        assert size > 0;
        // 第一个元素和最后一个元素交换
        E result = this.elementData[1];

        swap(this.elementData, 1, size);
        this.elementData[size--] = null;
        shiftDown(1);

        return result;
    }

    /**
     * 上移元素
     * @param index 数组下标
     */
    private void shiftUp(int index) {
        // 父节点小于子节点 交换位置
        while(index > 1){
            int parentIndex = index/2;
            if(elementData[parentIndex].compareTo(elementData[index]) < 0){
                swap(elementData, parentIndex, index);
                index /= 2;
            }else{
                break;
            }
        }
    }

    /**
     * 下移元素
     */
    private void shiftDown(int index){
        // 存在左子节点
        while( 2*index <= size){
            int left = 2 * index;
            int right = left + 1;
            // 存在右节点并且大于左节点
            if( right <= size && (elementData[right].compareTo(elementData[left]) > 0 )){
                left = right;
            }

            // 如果父节点大于等于子节点 不交换位置
            if(elementData[index].compareTo(elementData[left]) >= 0){
                break;
            }

            swap(elementData, index, left);

            // 向下迭代
            index = left;
        }
    }

    private void swap(E[] arr, int i, int j){
        E temp = arr[i];
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
            System.out.print(this.elementData[i] + " ");
        }
        System.out.println();
    }

    private void printSpace(int n) {
        // 打印n个空格(在这里用‘\t'来代替)
        for (int i = 0; i < n; i++) {
            System.out.printf("%3s", "");
        }
    }

    public void printAsTree() {
        // 首先遍历第一行
        int lineNum = 1;
        // lines是堆的层数
        int lines = (int) (Math.log(size) / Math.log(2)) + 1;
        int spaceNum = (int) (Math.pow(2, lines) - 1);
        // 因为在[1...size]左闭右闭区间存数据，data[0]不存数据
        for (int i = 1; i <= size; ) {

            //每层都是打印这个区间[2^(层数-1) ... (2^层数)-1]。如果堆里的数不够(2^层数)-1个，那就打印到size。所以取min((2^层数)-1,size).
            for (int j = (int) Math.pow(2, lineNum - 1); j <= Math.min(size, (int) Math.pow(2, lineNum) - 1); j++) {
                //打印spaceNum个空格
                printSpace(spaceNum);
                //打印数据
                System.out.printf("%3s", elementData[j]);
                //图片中绿色方框
                System.out.printf("%3s", "");
                //打印spaceNum个空格
                printSpace(spaceNum);
                i++;//每打印一个元素就 + 1
            }
            lineNum++;
            spaceNum = spaceNum / 2;
            System.out.println();
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
