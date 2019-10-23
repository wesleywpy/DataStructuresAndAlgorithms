package com.wesley.growth.leetcode.string;

/**
 * <p>
 * “回文串”是一个正读和反读都一样的字符串，比如“level”或者“noon”等等就是回文串。
 * </p>
 *
 * @author Created by Yani on 2019/10/23
 */
public class Solution125 {

    /**
     * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
     * 注意:
     *  字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
     *
     *  例子:
     *  输入: "abca"
     *  输出: True
     *  解释: 你可以删除c字符。
     */
    public boolean validPalindrome(String s) {

        return true;
    }


    /**
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写
     */
    public boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().toCharArray();

        int i = 0;
        int j = chars.length - 1;
        while (i < j && j > 0) {
            char x = chars[i];
            char y = chars[j];
            if (!isTarget(x)) {
                i ++;
                continue;
            }

            if (!isTarget(y)) {
                j --;
                continue;
            }

            if (x != y) {
                return false;
            }

            i ++;
            j --;
        }
        return true;
    }

    private boolean isTarget(char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z');
    }

    public static void main(String[] args) {
        boolean res = new Solution125().validPalindrome("deeee");
        System.out.println(res);
    }


}
