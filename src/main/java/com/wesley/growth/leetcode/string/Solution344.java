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

    /**
     * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
     * 示例:
     * 输入: "Let's take LeetCode contest"
     * 输出: "s'teL ekat edoCteeL tsetnoc"
     */
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sbul = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            char[] chars = words[i].toCharArray();
            reverseString(chars);
            sbul.append(chars);
            if (i < (words.length - 1)) {
                sbul.append(" ");
            }
        }
        return sbul.toString();
    }

    public static void main(String[] args) {
        String[] words = "Let's take LeetCode contest".split(" ");
        for (String word : words) {
            System.out.println(word);
        }
    }
}
