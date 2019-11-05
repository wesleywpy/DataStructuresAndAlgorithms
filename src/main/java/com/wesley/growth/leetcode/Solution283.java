package com.wesley.growth.leetcode;

/**
 * <p>
 *
 * </p>
 *
 * @author Created by Yani on 2019/11/05
 */
public class Solution283 {

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * 示例:
     *  输入: [0,1,0,3,12]
     *  输出: [1,3,12,0,0]
     *
     * 说明:
     *  必须在原数组上操作，不能拷贝额外的数组。
     *  尽量减少操作次数。
     */
    public void moveZeroes(int[] nums) {
        // 双指针法
        int length = nums.length;
        int last = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                nums[last++] = nums[i];
            }
        }

        for (int i = last; i < length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,0,1,0,3,12,0,0};
        new Solution283().moveZeroes(nums);
    }

}
