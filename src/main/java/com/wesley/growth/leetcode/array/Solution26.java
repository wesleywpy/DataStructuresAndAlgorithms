package com.wesley.growth.leetcode.array;

/**
 *
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 实例:
 *  给定 nums = [0,0,1,1,1,2,2,3,3,4],
 *  函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 *  不需要考虑数组中超出新长度后面的元素。
 *
 * @author Created by Yani on 2019/11/08
 */
public class Solution26 {

    /**
     * 双指针法
     * @param nums 已排序的数组
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // [0 ... k) 的元素均为非 val 元素
        int k = 0;
        // 数组中每个不重复元素
        int val = nums[k];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != val) {
                k++;
                nums[k] = nums[i];
                val = nums[i];
            }
        }
        return k+1;
    }

    public static void main(String[] args) {
        int res = new Solution26().removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});
        System.out.println(res);
    }
}
