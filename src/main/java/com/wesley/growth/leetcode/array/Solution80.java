package com.wesley.growth.leetcode.array;

/**
 * <p>
 *  给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 *  不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * </p>
 * 示例:
 *  给定 nums = [0,0,1,1,1,1,2,3,3],
 *  函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
 *  你不需要考虑数组中超出新长度后面的元素。
 * @author Created by Yani on 2019/11/12
 */
public class Solution80 {


    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }

        // 边界: 当数组的长度小于等于 2 时，不需要操作，直接返回原数组即可。
        if (nums.length <= 2) {
            return nums.length;
        }

        int slow = 1;
        for (int fast = 2; fast < nums.length; fast++) {
            if (nums[slow - 1] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        int res = new Solution80().removeDuplicates(new int[]{1,1,1,2,2,3});
        System.out.println(res);
    }
}
