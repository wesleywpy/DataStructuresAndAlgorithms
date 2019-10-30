package com.wesley.growth.leetcode.bit;

/**
 * <p>
 *
 * </p>
 *
 * @author Created by Yani on 2019/10/30
 */
public class Solution191 {

    /**
     * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
     *
     * 十六进制: 0x8000 0000
     * 二进制: 1000 0000 0000 0000 0000 0000 0000 0000
     */
    public int hammingWeight(int n) {
        int res = 0;
        // 运算的优先级，移位运算高于逻辑运算，>>>高于&
        // >>>无符号右移，移出部分舍弃，左边位补0
        for (int i = 0; i < 32; i++) {
            int t = (n & 0x80000000 >>> i) >>> (31 - i);
            res += t;
        }
        return res;
    }

    /**
     * 这里关键的想法是对于任意数字 n ，将 n 和 n - 1 做与运算，会把最后一个 1 的位变成 0 。
     *
     */
    public int hammingWeight2(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }

    public static void main(String[] args) {
        new Solution191().hammingWeight(12);
        System.out.println(Integer.MAX_VALUE);
    }
}
