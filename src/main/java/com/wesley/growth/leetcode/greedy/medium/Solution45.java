package com.wesley.growth.leetcode.greedy.medium;

/**
 * Solution45
 * @author WangPanYong
 * @since 2021/04/08 15:28
 */
public class Solution45 {

    /**
     * 贪心算法
     */
    public int jump(int[] nums) {
        int len = nums.length;
        int res = 0;
        // 当前覆盖的最远距离下标
        int curr = 0;
        // 下⼀步覆盖的最远距离下标
        int next = 0;

        for (int i = 0; i < len - 1; i++) {
            // 更新下⼀步覆盖的最远距离下标
            next = Math.max(nums[i] + i, next);
            if (i == curr) {
                curr = next;
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{3,2,1,1,4};
        int res = new Solution45().jump(prices);
        System.out.println(res);
    }

}
