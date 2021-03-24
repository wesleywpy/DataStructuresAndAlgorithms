package com.wesley.growth.leetcode.dp;

/**
 * Solution53
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * @author WangPanYong
 * @since 2021/03/24 15:57
 */
public class Solution53 {


    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            if (count > result) {
                result = count;
            }

            // 相当于重置最⼤⼦序起始位置，因为遇到负数⼀定是拉低总和
            if (count <= 0) {
                count = 0;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -7, 4};
        int res = new Solution53().maxSubArray(nums);
        System.out.println(res);
    }
}