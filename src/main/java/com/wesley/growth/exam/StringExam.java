package com.wesley.growth.exam;

/**
 * <p>
 * 字符串相关
 * </p>
 * Email yani@uoko.com
 *
 * @author Created by Yani on 2019/08/05
 */
public class StringExam {

    /**
     * 字符串反转函数
     */
    public static String reverse(final String str) {
        if (null == str || str.length() == 0) {
            return "";
        }

        int n = str.length() - 1;
        char[] value = str.toCharArray();

        // 通过字符串长度找到 交换位置的下标 j 和 k
        for (int j = (n-1) >> 1; j >= 0; j--) {
            int k = n - j;
            char cj = value[j];
            char ck = value[k];
            value[j] = ck;
            value[k] = cj;
        }

        return new String(value);
    }

    /**
     * 字符串反转(简单方法)
     */
    public static String reverseSimple(final String str) {
        if (null == str || str.length() == 0) {
            return "";
        }

        int n = str.length() - 1;
        char[] value = str.toCharArray();
        StringBuilder result = new StringBuilder();
        for (int j = n; j >= 0; j--) {
            result.append(value[j]);
        }

        return result.toString();
    }

    /**
     * 去掉字符串中重复的字符, 不许使用额外存储空间
     *
     */
    public static String removeDuplicateChar(final String str) {
        if (null == str || str.length() < 2) {
            return "";
        }

        int len = str.length() - 1;
        char[] value = str.toCharArray();

        int p = 0;
        for (int i = 0; i < len; i++) {
            value[p++] = value[i];

            for (int j = i + 1; j < len; j++) {
                if (value[i] == value[j]) {
                    value[j] = '\0';
                }
            }

        }

        return new String(value);
    }
}
