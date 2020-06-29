package com.wesley.growth.leetcode.sort.medium;

import com.wesley.growth.algorithms.sort.util.SortTestHelper;

/**
 * <p>
 *  设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 * </p>
 *
 * 示例：
 *   输入： arr = [1,3,5,7,2,4,6,8], k = 4
 *   输出： [1,2,3,4]
 * 提示:
 *   0 <= len(arr) <= 100000
 *   0 <= k <= min(100000, len(arr))
 *
 * @author Created by Yani on 2020/06/29
 */
public class Solution17dot14 {

    public int[] smallestK(int[] arr, int k) {
        int[] res = new int[k];

        return res;
    }

    /**
     * 解决方案: 插入排序
     */
    private int[] insertionSort(int[] arr, int k) {
        for (int i = 1; i < arr.length; i++) {
            int e = arr[i];
            int j;
            for (j = i; j > 0 && arr[j-1] > e; j--) {
                arr[j] =  arr[j-1];
            }
            arr[j] = e;
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,7,2,4,6,8};
        int[] res = new Solution17dot14().smallestK(arr, 4);
        SortTestHelper.print(res);
    }



}
