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

    /**
     * LeetCode 541
     * 给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。
     * 如果剩余少于 k 个字符，则将剩余的所有全部反转。如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。
     *
     * 要求:
     *  该字符串只包含小写的英文字母。
     *  给定字符串的长度和 k 在[1, 10000]范围内。
     */
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();

        // 直接反转每个2k 字符块
        for (int start = 0; start < chars.length; start += 2*k) {
            int i = start;
            int j = Math.min(start + k - 1, chars.length - 1);
            while (i < j) {
                char tmp = chars[i];
                chars[i] = chars[j];
                chars[j] = tmp;
                i++;
                j--;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String[] words = "Let's take LeetCode contest".split(" ");
        for (String word : words) {
            System.out.println(word);
        }
    }
}
