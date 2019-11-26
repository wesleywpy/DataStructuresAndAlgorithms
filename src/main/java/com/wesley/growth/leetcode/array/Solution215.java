package com.wesley.growth.leetcode.array;

import java.util.Random;

/**
 * <p>
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例:
 *  输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 *  输出: 4
 *
 * 假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * </p>
 *
 * @author Created by Yani on 2019/11/19
 */
public class Solution215 {

    private final Random random = new Random();

    /**
     * 注意到第 k 个最大元素也就是第 N - k 个最小元素，因此可以用第 k 小算法来解决本问题。
     */
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length -1, nums.length - k);
    }

    /**
     * @param k 第 k 小 的元素
     */
    private int quickSelect(int[] arr, int left, int right, int k) {

        // 随机选取区间中的一个数为基准数。
        int privotIndex = random.nextInt(right - left + 1) + left;

        privotIndex = partition(arr, left, right, privotIndex);

        // the pivot is on (N - k)th smallest position
        if (k == privotIndex)
            return arr[k];
        // go left side
        else if (k < privotIndex)
            return quickSelect(arr, left, privotIndex - 1, k);
        // go right side
        return quickSelect(arr,privotIndex + 1, right, k);
    }

    private int partition(int[] arr, int left, int right, int privotIdx) {
        int privot = arr[privotIdx];
        // 1. 将 基准点 移到最右
        swap(arr, privotIdx, right);

        // 2. 将所有 小于轴心点的元素 移动到 轴心点 左边
        int lt = left;
        for (int i = left; i <= right; i++) {
            if (arr[i] < privot) {
                swap(arr, lt, i);
                lt++;
            }
        }

        // 3.
        swap(arr, lt, right);
        return lt;
    }

    private void swap(int[] arr, int i, int j){
        if (i == j) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 4, 1, 2, 1};
        int kthLargest = new Solution215().findKthLargest(nums, 5);
        System.out.println(kthLargest);
    }
}
