package com.wesley.growth.algorithms.sort.util;

import com.wesley.growth.algorithms.sort.Sort;
import java.util.Random;
import java.util.StringJoiner;

/**
 * @author Created by Wesley on 2018/7/27.
 */
public class SortTestHelper {

    private SortTestHelper() {

    }

    /**
     * 生成有n个元素的随机数组,每个元素的随机范围为[rangeL, rangeR]
     */
    public static Integer[] generateRandomIntegerArray(int n, int rangeL, int rangeR) {
        assert rangeL < rangeR;
        Integer[] result = new Integer[n];

        Random random = new Random();
        for(int i = 0; i < n; i++){
            result[i] = random.nextInt(rangeR - rangeL + 1) + rangeL;
        }
        return result;
    }

    /**
     * 生成有n个元素的随机数组,每个元素的随机范围为[rangeL, rangeR]
     */
    public static int[] generateRandomIntArray(int n, int rangeL, int rangeR) {
        assert rangeL < rangeR;
        int[] result = new int[n];

        Random random = new Random();
        for(int i = 0; i < n; i++){
            result[i] = random.nextInt(rangeR - rangeL + 1) + rangeL;
        }
        return result;
    }

    /**
     * 生成一个近乎有序的数组
     * @param n 数组长度
     * @param swapTimes 数组元素随机交换的次数
     */
    public static int[] generateNearlyOrderedArray(int n, int swapTimes){
        int[] result = new int[n];
        for(int i = 0; i < n; i ++){
            result[i] = i;
        }

        Random random = new Random();
        for(int j = 0; j < swapTimes; j ++){
            int x = random.nextInt(n);
            int y = random.nextInt(n);
            int temp = result[x];
            result[x] = result[y];
            result[y] = temp;
        }

        return result;
    }

    public static void testSort(Sort sort, int[] arr){
        System.out.println("排序开始: "+ sort.getClass().getSimpleName());
        long start = System.currentTimeMillis();
        sort.sort(arr);
        long end = System.currentTimeMillis();

        if(!isSorted(arr)){
            System.out.println("排序失败!");
            return;
        }

        System.out.println("排序结束! \r\n耗时: " + (end - start) + " 毫秒");
    }

    public static <T extends Comparable<T>> void testSort(Sort sort, T[] arr){
        System.out.println("排序开始...");

        long start = System.currentTimeMillis();
        sort.sort(arr);
        long end = System.currentTimeMillis();

        System.out.println("排序结束! \r\n耗时: " + (end - start) + " 毫秒");
    }

    private static boolean isSorted(int[] arr){
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i] > arr[i + 1]){
                return false;
            }
        }

        return true;
    }

    public static <T> void print(T[] array){
        StringJoiner joiner = new StringJoiner(",");
        for (int i = 0; i < array.length; i++){
            joiner.add(String.valueOf(array[i]));
        }
        System.out.println(joiner.toString());
    }

    public static void print(int[] array){
        StringJoiner joiner = new StringJoiner(",");
        for (int i = 0; i < array.length; i++){
            joiner.add(String.valueOf(array[i]));
        }
        System.out.println(joiner.toString());
    }

}
