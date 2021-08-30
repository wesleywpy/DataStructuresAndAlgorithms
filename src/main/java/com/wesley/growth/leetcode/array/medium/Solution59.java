package com.wesley.growth.leetcode.array.medium;

/**
 * Solution59
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * @author WangPanYong
 * @since 2021/08/27 10:41
 */
public class Solution59 {

    public int[][] generateMatrix(int n) {
        if (n == 1) {
            return new int[][]{{1}};
        }

        int[][] res = new int[n][n];
        int total = n * n;
        int start = 1;

        int left = 0;
        // 矩阵右边界 下标最大为 n-1
        int right = n - 1;
        int top = 0;
        // 矩阵下边界 下标最大为 n-1
        int below = n -1;
        while (start <= total) {
            // 从左往右，上边界 top += 1，相当于上边界向下降
            for (int i = left; i <= right; i++) {
//                System.out.print(start);
                res[top][i] = start++;
            }
//            System.out.println();
            top ++;
            // 从上往下，右边界 递减
            for (int i = top; i <= below; i++) {
//                System.out.print(start);
                res[i][right] = start++;
            }
//            System.out.println();
            right --;
            // 从右往左，下边界 上升
            for (int i = right; i >= left; i--) {
//                System.out.print(start);
                res[below][i] = start++;
            }
//            System.out.println();
            below --;
            // 从下往上，左边界 递增
            for (int i = below; i >= top; i--) {
//                System.out.print(start);
                res[i][left] = start++;
            }
//            System.out.println();
            left ++;

        }
        return res;
    }

    public static void main(String[] args) {
        new Solution59().generateMatrix(4);
    }

}
