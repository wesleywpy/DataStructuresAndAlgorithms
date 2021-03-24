package com.wesley.growth.leetcode.dp.medium;

/**
 * Solution343
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 * @author WangPanYong
 * @since 2021/03/22 14:51
 */
public class Solution343 {

    private int[] memory;
    /**
     * 将n进行分割，至少分割两部分
     */
    private int breakInteger(int n) {
        // 无法分割
        if (n == 2) {
            return 1;
        }

        // 记忆化搜索
        if (memory[n] != 0) {
            return memory[n];
        }

        int res = -1;
        for (int i = 1; i <= n - 1; i++) {
            res = max3(res, i * (n - i), i * breakInteger(n - i));
        }

        memory[n] = res;
        return res;
    }

    private int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }


    public int integerBreak(int n) {
        memory = new int[n+1];
        return breakInteger(n);
    }

    public static void main(String[] args) {
        int res = new Solution343().integerBreak(10);
        System.out.println(res);
    }

}
