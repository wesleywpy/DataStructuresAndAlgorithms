package com.wesley.growth.leetcode.greedy.medium;

/**
 * Solution376
 *
 * @author WangPanYong
 * @since 2021/03/24 14:04
 */
public class Solution376 {

    public int wiggleMaxLength(int[] nums) {
        // 前一对峰值
        int preDiff = 0;
        // 当前一对峰值
        int curDiff = 0;
        // 记录峰值个数
        int result = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            curDiff = nums[i + 1] - nums[i];
            // 出现峰值
            if ((preDiff <= 0 && curDiff > 0) || (preDiff >= 0 && curDiff < 0)) {
                result ++;
                preDiff = curDiff;
            }
        }
        return result;
    }





    public static void main(String[] args) {
        int[] nums = new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        new Solution376().wiggleMaxLength(nums);
    }

}
