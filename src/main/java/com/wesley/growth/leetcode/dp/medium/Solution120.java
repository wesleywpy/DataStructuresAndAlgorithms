package com.wesley.growth.leetcode.dp.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution120
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 *
 * @author WangPanYong
 * @since 2021/03/18 13:57
 */
public class Solution120 {

    private Integer[][] memory;

    /**
     * 定义二维 dp 数组，自底向上的递推。
     * 倒数第一行的最小路径就是他自己，从倒数第二行开始，当前元素的最小路径就是当前元素加上他下一行左右两个元素的最小路径。
     * @param triangle
     * @return
     */
    public int minimumTotalByDp(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] dp = new int[size + 1];

        for (int i = size - 1; i >= 0; i--) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + list.get(j);
            }
        }
        return dp[0];
    }


    public int minimumTotal(List<List<Integer>> triangle) {
        memory = new Integer[triangle.size()][triangle.size()];
        return dfs(triangle, 0, 0);
    }

    /**
     * 自顶向下的解决问题
     * 将任一点到底边的最小路径和，转化成了与该点相邻两点到底边的最小路径和中的较小值，再加上该点本身的值。
     * @param triangle
     * @param i 行
     * @param j 列
     * @return
     */
    private int dfs(List<List<Integer>> triangle, int i, int j) {
        if (triangle.size() == i) {
            return 0;
        }

        // 二维数组进行记忆化搜索
        if (memory[i][j] != null) {
            return memory[i][j];
        }

        int r1 = dfs(triangle, i + 1, j);
        int r2 = dfs(triangle, i + 1, j + 1);

        return memory[i][j] = Math.min(r1, r2) + triangle.get(i).get(j);
    }


    public static void main(String[] args) {
        List<Integer> r1 = Arrays.asList(2);
        List<Integer> r2 = Arrays.asList(3, 4);
        List<Integer> r3 = Arrays.asList(6, 5, 7);
        List<Integer> r4 = Arrays.asList(4, 1, 8, 3);

        List<List<Integer>> param = new ArrayList<>();
        param.add(r1);
        param.add(r2);
        param.add(r3);
        param.add(r4);

        int res = new Solution120().minimumTotalByDp(param);
        System.out.println(res);
    }


}
