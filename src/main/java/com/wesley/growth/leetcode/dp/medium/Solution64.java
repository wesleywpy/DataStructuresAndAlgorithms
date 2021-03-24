package com.wesley.growth.leetcode.dp.medium;

/**
 * Solution64
 *
 * @author WangPanYong
 * @since 2021/03/19 14:47
 */
public class Solution64 {

    /**
     * 动态规划
     * 从右下角向左上角
     */
    public int minPathSum01(int[][] grid) {
        // 行数
        int m = grid.length;
        // 列数
        int n = grid[0].length;
        int[][] dp = new int[m+1][n+1];

        System.out.println();
        for (int i = m - 1; i >= 0; i--) {
            for (int j = grid[i].length - 1; j >= 0; j--) {
                if (j + 1 >= n) {
                    dp[i][j] = dp[i + 1][j] + grid[i][j];
                } else if (i + 1 >= m) {
                    dp[i][j] = dp[i][j + 1] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i][j + 1], dp[i + 1][j]) + grid[i][j];
                }
//                System.out.printf("%-5d",dp[i][j]);
            }
//            System.out.println();
        }
        return dp[0][0];
    }

    /**
     * 动态规划
     * 从左下角向右上角, 不需要额外存储空间
     *
     * 时间复杂度 O(M×N)O(M×N) ： 遍历整个 grid 矩阵元素。
     * 空间复杂度 O(1)O(1) ： 直接修改原矩阵，不使用额外空间。
     *
     */
    public int minPathSum(int[][] grid) {
        // 行数
        int m = grid.length;
        // 列数
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 当左边和上边都是矩阵边界时： 即当i = 0, j = 0i=0,j=0时，其实就是起点
                if (j == 0 && i == 0) {
//                    System.out.printf("%-5d",grid[i][j]);
                    continue;
                }

                // 当只有左边是矩阵边界时
                if (j - 1 < 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                }
                // 当只有上边是矩阵边界时
                else if (i - 1 < 0) {
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                } else {
                    grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j]) + grid[i][j];
                }
//                System.out.printf("%-5d",grid[i][j]);
            }
//            System.out.println();
        }
        return grid[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,2,3},{4,5,6}};
        int res = new Solution64().minPathSum(grid);
        System.out.println(res);
    }

}
