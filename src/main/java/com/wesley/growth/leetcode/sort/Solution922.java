package com.wesley.growth.leetcode.sort;

import com.wesley.growth.algorithms.sort.util.SortTestHelper;

/**
 * <p>
 *  给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 *
 *  对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 * </p>
 * Email yani@uoko.com
 *
 * @author Created by Yani on 2019/09/18
 */
public class Solution922 {

    /**
     * 两次遍历
     */
    public int[] sortArrayByParityII(int[] A) {
        int[] res = new int[A.length];

        int idx = 0;
        for (int i : A) {
            if (i % 2 == 0) {
                res[idx] = i;
                idx += 2;
            }
        }

        idx = 1;
        for (int i : A) {
            if (i % 2 == 1) {
                res[idx] = i;
                idx += 2;
            }
        }

        return res;
    }

    /**
     * 双指针法, 不开辟额外空间
     */
    public int[] sortArrayByParityII2(int[] A) {
        // 执行奇数的指针
        int j = 1;
        // 偶数指针
        for (int i = 0; i < A.length; i += 2) {
            // 偶指针位置 是奇数
            if (A[i] % 2 == 1) {
                // 找到 执行偶数的 奇指针
                while (A[j] % 2 == 1) {
                    j += 2;
                }

                int tmp = A[j];
                A[j] = A[i];
                A[i] = tmp;
            }
        }
        return A;
    }


    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 2};
        Solution922 s = new Solution922();
        s.sortArrayByParityII(arr);
        SortTestHelper.print(arr);
    }
}
