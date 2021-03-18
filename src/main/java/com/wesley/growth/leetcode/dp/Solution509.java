package com.wesley.growth.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和
 *
 * @author WangPanYong
 * @since 2020/09/29 14:20
 */
public class Solution509 {

    /**
     * 给定 N，计算 F(N)。
     * 提示：
     *   0 ≤ N ≤ 30
     *  大量重复的递归计算
     */
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }
        // 递归实现
        return fib(n-1) + fib(n-2);
    }

    /**
     *
     * @param n
     * @return
     */
    public int fib02(int n) {
        if (n < 2) {
            return n;
        }
        //初始状态 即初始化前两个数字
        int a = 0;
        int b = 1;
        for(int i = 2; i <= n; ++i){
            // 使 a, b 两数字交替前进即可
            b = a + b;
            a = b - a;
        }
        return b;
    }

    /**
     * 动态规划 - 自下向上的解决问题
     */
    public int fib03(int n) {
        List<Integer> memory = new ArrayList<>(n);
        memory.add(0, 0);
        memory.add(1, 1);

        for (int i = 2; i <= n; i++) {
            memory.add(i, memory.get(i-1) + memory.get(i - 2));
        }

        return memory.get(n);
    }

    public static void main(String[] args) {
        int res = new Solution509().fib03(3);
        System.out.println(res);
    }

}
