package com.wesley.growth.leetcode.array;

import com.wesley.growth.algorithms.sort.util.SortTestHelper;

/**
 * Solution977
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 * 示例 1： 输入：nums = [-4,-1,0,3,10] 输出：[0,1,9,16,100] 解释：平方后，数组变为 [16,1,0,9,100]，排序后，数组变为 [0,1,9,16,100]
 * 示例 2： 输入：nums = [-7,-3,2,3,11] 输出：[4,9,9,49,121]
 *
 * @author WangPanYong
 * @since 2021/08/26 10:03
 */
public class Solution977 {

    /**
     * 数组其实是有序的， 只不过负数平方之后可能成为最大数了。
     * 那么数组平方的最大值就在数组的两端，不是最左边就是最右边，不可能是中间。
     * 此时可以考虑双指针法了，i指向起始位置，j指向终止位置。
     */
    public int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int[] result = new int[nums.length];

        int left = 0;
        int right = nums.length - 1;

        int cur = right;

        while (left <= right) {
            int lv = nums[left] * nums[left];
            int rv = nums[right] * nums[right];

            if (lv > rv) {
                // 左指针指向的值 比右指针的大
                result[cur--] = lv;
                left ++;
            } else {
                result[cur--] = rv;
                right --;
            }
        }
         return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-7,-3,2,3,11};
        int[] res = new Solution977().sortedSquares(nums);
        SortTestHelper.print(res);
    }
}
