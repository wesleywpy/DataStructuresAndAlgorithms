package com.wesley.growth.leetcode.greedy;

import java.util.Arrays;

/**
 * Solution1005
 *
 * @author WangPanYong
 * @since 2021/04/09 13:38
 */
public class Solution1005 {

    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);

        int res = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0 && K > 0) {
                A[i] *= -1;
                K --;
            }

            if (A[i] == 0) {
                K = 0;
            }
        }

        if (K > 0) {

        }


        return res;
    }


    public static void main(String[] args) {
        int[] s = new int[]{-2,9,9,8,4};
        int res = new Solution1005().largestSumAfterKNegations(s, 5);
        System.out.println(res);
    }
}
