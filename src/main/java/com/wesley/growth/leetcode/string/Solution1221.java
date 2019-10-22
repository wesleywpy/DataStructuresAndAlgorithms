package com.wesley.growth.leetcode.string;

/**
 * <p>
 *
 * </p>
 *
 * @author Created by Yani on 2019/10/22
 */
public class Solution1221 {

    /**
     * 在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。
     *
     * 给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
     *
     * 返回可以通过分割得到的平衡字符串的最大数量。
     */
    public int balancedStringSplit(String s) {
        char[] chars = s.toCharArray();

        int r = 0;
        int l = 0;
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'R') {
                r++;
            } else if (chars[i] == 'L') {
                l ++;
            }
            if (r == l && r != 0) {
                result++;
                r = 0;
                l = 0;
            }
        }

        return result;
    }

}
