package com.wesley.growth.leetcode.array;

/**
 * <p>
 *  给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *  说明:
 *      初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 *      你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * </p>
 *
 * @author Created by Yani on 2019/11/19
 */
public class Solution88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m];
        System.arraycopy(nums1, 0, temp, 0, m);

        int i = 0, j = 0, k = 0;
        // 在每一步将最小值放入输出数组中。
        while (i < m && j < n) {
            nums1[k] = (temp[i] < nums2[j]) ? temp[i++] : nums2[j++];
            k++;
        }

        // i+j , 输出数组的起始位置
        // (m+n) - (i+j) : 剩下还未移动的元素个数
        if (i < m) {
            System.arraycopy(temp, i, nums1, i+j, (m+n) - (i+j));
        }

        if (j < n) {
            System.arraycopy(nums2, j, nums1, i+j, (m+n) - (i+j));
        }
    }

}
