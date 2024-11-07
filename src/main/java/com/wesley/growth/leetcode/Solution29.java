package com.wesley.growth.leetcode;

/**
 * Solution29
 *
 * @author WangPanYong
 * @since 2024/10/22
 */
public class Solution29 {

    public int divide(int dividend, int divisor) {
        if (divisor == 1) {
            return dividend;
        }

        // int最小值 && 除数为-1 会溢出直接返回
        if (dividend == 0x80000000 && divisor == -1) {
            // 有符号int最大值 2^32 - 1
            return 0x7fffffff;
        }

        int negative = 2;
        // 将正数转换为负数 不会导致溢出
        if (dividend > 0) {
            --negative;
            dividend = -dividend;
        }

        if (divisor > 0) {
            --negative;
            divisor = -divisor;
        }

        int result = divideCore(dividend, divisor);
        return negative == 1 ? -result : result;
    }

    // 转换为负数后 dividend 会小于 divisor
    private int divideCore(int dividend, int divisor) {

        int result = 0;
        while (dividend <= divisor) {
            // 商
            int quotient = 1;
            int value = divisor;
            // 被除数(是负数) 是否小于 除数的2倍 0xc0000000为 -2^31 的一半 -2^30
            while (value > 0xc0000000 && dividend <= (value + value)) {
                // 商 也是 成倍增加
                quotient += quotient;
                value += value;
            }

            dividend = dividend - value;
            result += quotient;
        }

        return result;
    }
}
