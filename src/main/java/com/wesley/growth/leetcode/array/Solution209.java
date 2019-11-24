package com.wesley.growth.leetcode.array;

/**
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 * 示例:
 *   输入: s = 7, nums = [2,3,1,2,4,3]
 *   输出: 2
 *   解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * @author Created by Wesley on 2019/11/24
 */
public class Solution209 {

    /**
     * 双指针: 滑动窗口
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    public int minSubArrayLen(int s, int[] nums) {
        // [left ... right] 为滑动窗口
        int left = 0;
        int right = -1;
        int sum = 0;
        int res = nums.length + 1;

        while (left < nums.length) {
            // 滑动过程
            if ((right + 1) < nums.length && sum < s) {
                right++;
                sum += nums[right];
            }else {
                sum -= nums[left];
                left ++;
            }

            if (sum >= s) {
                int tmp = right - left + 1;
                res = tmp < res ? tmp : res;
            }
        }

        // 没有解
        if (res == (nums.length + 1)){
            return 0;
        }

        return res;
    }

    public static void main(String[] args) {
        new Solution209().minSubArrayLen(7, new int[]{2,3,1,2,4,3});
    }

}
