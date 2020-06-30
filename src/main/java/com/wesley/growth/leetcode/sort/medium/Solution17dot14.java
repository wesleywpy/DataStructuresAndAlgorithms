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

    /**
     * 构建小顶堆
     */
    public int[] smallestK(int[] arr, int k) {
        int size = arr.length - 1;
        // 第一个非叶子节点位置: 元素个数 / 2
        for (int i = size / 2; i >= 0; i--) {
            shiftDown(arr, i, size);
        }

        // 弹出最小元素
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[0];
            swap(arr, 0, size);
            size --;
            shiftDown(arr, 0, size);
        }
        return res;
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void shiftDown(int[] arr, int index, int len){
        // 二叉堆 shift down 过程
        while ((2 * index + 1) <= len) {
            // 当前节点的 左子结点 2i + 1
            int left = 2 * index + 1;
            // 当前节点的 右结点 2i + 2
            int right = left + 1;

            // 右节点 小于 左节点
            if (right <= len && arr[right] < arr[left]) {
                left = right;
            }
            // 当前节点 小于等于 子节点 不交换位置
            if (arr[index] <= arr[left]) {
                break;
            }

            swap(arr, index, left);
            // 向下迭代
            index = left;
        }
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
