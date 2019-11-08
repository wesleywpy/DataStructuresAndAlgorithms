package com.wesley.growth.leetcode.array;

/**
 *  给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 *  不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *  元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * @author Created by Yani on 2019/11/08
 */
public class Solution27 {

    public int removeElement(int[] nums, int val) {
        // [0 ... k) 的元素均为非 val 元素
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                int tmp = nums[i];
                nums[i] = nums[k];
                nums[k] = tmp;
                k ++;
            }
        }
        return k;
    }

}
