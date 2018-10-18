package com.wesley.growth.algorithms.search;

/**
 * <p>
 *
 * </p>
 * Email yani@uoko.com
 *
 * @author Created by Yani on 2018/10/17
 */
public class BinarySearch {

    /**
     * @param array 有序的数组
     * @param target 目标值
     * @return 目标索引, 没有返回-1
     */
    public static int binarySearch(Integer[] array, Integer target){
        int left = 0;
        int right = array.length - 1;

        // array[left,right] 区间中查找
        while(left <= right){

//            int mid = (left + right) / 2; 当left和right值都接近于Int最大值时, 相加值会超过Int最大值
            int mid = left + (right - left) / 2;

            if (array[mid].equals(target)){
                return mid;
            }

            if (array[mid] < target){
                left = mid + 1;
            }else{
                right = mid -1;
            }

        }

        return -1;
    }


    private static int recursiveBinarySearch(Integer[] array, int left, int right, Integer target){
        if (left > right){
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (array[mid].equals(target)){
            return mid;
        }

        if (array[mid] < target){
            return recursiveBinarySearch(array, mid+1, right, target);
        }else{
            return recursiveBinarySearch(array, left, mid-1, target);
        }

    }

    /**
     * 递归实现二分查找
     */
    public static int recursiveBinarySearch(Integer[] array, Integer target){
        return recursiveBinarySearch(array, 0, array.length - 1, target);
    }

    public static void main(String[] args) {
        int len = 1000000;
        Integer[] array = new Integer[len];
        for(int i = 0; i < len; i ++){
            array[i] = i;
        }

        long begin = System.currentTimeMillis();
        for(int i = 0; i < len * 2; i ++){
            int idx = binarySearch(array, i);
            if(i < len ){
                assert i == idx;
            }else{
                assert idx == -1;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Binary Search : "+ (end - begin) +" ms");

        begin = System.currentTimeMillis();
        for(int i = 0; i < len * 2; i ++){
            int idx = recursiveBinarySearch(array, i);
            if(i < len ){
                assert i == idx;
            }else{
                assert idx == -1;
            }
        }
        end = System.currentTimeMillis();
        System.out.println("Binary Search (Recursion) : "+ (end - begin) +" ms");

    }
}
