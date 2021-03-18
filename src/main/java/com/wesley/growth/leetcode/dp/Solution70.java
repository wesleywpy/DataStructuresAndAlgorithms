package com.wesley.growth.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution70
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * @author WangPanYong
 * @since 2021/03/17 14:50
 */
public class Solution70 {

    public int climbStairs(int n) {
        return calcWays(n);
    }

    /**
     * 动态规划
     */
    private int calcWays(int n) {
        List<Integer> memory = new ArrayList<>(n);
        memory.add(0, 1);
        memory.add(1, 1);

        for (int i = 2; i <= n; i++) {
            memory.add(i, memory.get(i-1) + memory.get(i - 2));
        }

        return memory.get(n);
    }

    /**
     * 动态规划
     */
    private int calcWays2(int n) {
        List<Integer> memory = new ArrayList<>(n);
        memory.add(0, 1);
        memory.add(1, 1);

        int pre = 1;
        int cur = 1;

        for (int i = 2; i <= n; i++) {
            pre = pre + cur;
        }

        return memory.get(n);
    }

}
