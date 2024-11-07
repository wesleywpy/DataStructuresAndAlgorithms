package com.wesley.growth.leetcode.bit;

/**
 * Solution338
 *
 * @author WangPanYong
 * @since 2024/11/07
 */
public class Solution338 {

    /**
     * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，
     * 计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
     * <p>
     * 输入：n = 2
     * 输出：[0,1,1]
     *
     */
    public int[] countBits(int n) {
        // i & (i-1) 将整数的二进制最右边的1变为0, 直到 结果为0. i&(i-1) 的执行次数 就是1的个数
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; ++i) {
            int j = i;
            while (j != 0) {
                res[i]++;
                j = j & (j - 1);
            }
        }
        return res;
    }

    public int[] countBits2(int n) {
        //动态规划
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            // 整数i的二进制形式中1的个数比 i&(i-1) 的二进制形式中1的个数多1
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution338 solution338 = new Solution338();
        int[] bits = solution338.countBits2(15);
        for (int bit : bits) {
            System.out.printf("%d ", bit);
        }
    }

}
