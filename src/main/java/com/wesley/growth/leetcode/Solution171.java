package com.wesley.growth.leetcode;

/**
 * <p>
 *
 * </p>
 *
 * @author Created by Yani on 2019/10/28
 */
public class Solution171 {

    /**
     * 给定一个Excel表格中的列名称，返回其相应的列序号。
     * 示例1:
     *  输入: "A"
     *  输出: 1
     *
     * 示例2:
     *  输入: "AB"
     *  输出: 28
     */
    public int titleToNumber(String s) {
        // 从低位到高位
        char[] chars = s.toCharArray();

        int j = 0;
        int res = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            int index = (chars[i] - 'A') + 1;
            res += (int)(Math.pow(26, j) * index);
            j ++;
        }
        return res;
    }

    /**
     * 从高位到低位
     */
    public int titleToNumber2(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'A' + 1;
            res = res * 26 + num;
        }
        return res;
    }


    public static void main(String[] args) {
        int res = new Solution171().titleToNumber("AAB");
        System.out.println(res);
    }


}
