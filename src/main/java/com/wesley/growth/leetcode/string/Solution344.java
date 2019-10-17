package com.wesley.growth.leetcode.string;

/**
 * <p>
 *
 * </p>
 *
 * @author Created by Yani on 2019/10/17
 */
public class Solution344 {

    /**
     * 反转字符串
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间
     */
    public void reverseString(char[] s) {
        if (null == s || s.length == 0) {
            return;
        }

        int n = s.length - 1;
        // (n-1) >> 1 , 最大索引位置 - 1 除以 2 得到 起始交换位置
        // 通过字符串长度找到 交换位置的下标 j 和 k
        for (int j = (n-1) >> 1; j >= 0; j--) {
            int k = n - j;
            char cj = s[j];
            char ck = s[k];
            s[j] = ck;
            s[k] = cj;
        }
    }
}
