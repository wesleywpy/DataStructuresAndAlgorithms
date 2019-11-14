package com.wesley.growth.leetcode.array;

/**
 * <p>
 *  给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *  此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * </p>
 *
 * @author Created by Yani on 2019/11/14
 */
public class Solution75 {

    /**
     * 一个直观的解决方案是使用计数排序的两趟扫描算法。
     * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
     *
     * 时间复杂度 O(n)
     * 空间复杂度 0(k), k为元素的取值范围
     */
    public void sortColors(int[] nums) {
        int k = 3;
        int[] colors = new int[k];
        for (int i = 0; i < colors.length; i++) {
            colors[i] = 0;
        }

        for (int i = 0; i < nums.length; i++) {
            colors[nums[i]]++;
        }

        int index = 0;
        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < colors[i]; j++) {
                nums[index++] = i;
            }
        }
    }

    /**
     * 三路快速排序思路
     * 只遍历一遍数组即可
     */
    public void sortColors2(int[] nums) {
        // nums[0 ... zero] == 0, 初始边界为-1
        int zero = -1;
        // nums[two ... n-1] == 2
        int two = nums.length;

        for (int i = 0; i < two; ) {

            if (nums[i] == 1) {
                i++;
            }
            // 最大值放到数组最后面
            else if (nums[i] == 2) {
                two --;
                swap(nums, i, two);
            }
            // 最小值
            else {
                zero ++;
                swap(nums, zero, i);
                i ++;
            }
        }
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
