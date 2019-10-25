package com.wesley.growth.leetcode.string;

import java.util.HashMap;

/**
 * <p>
 * 罗马数字转整数
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 *
 * </p>
 * @author Created by Yani on 2019/10/24
 */
public class Solution13 {

    /**
     * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
     */
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char[] chars = s.toCharArray();
        if (chars.length == 1) {
            return map.get(chars[0]);
        }

        char pre = chars[0];
        int res = map.get(pre);
        for (int i = 1; i < chars.length; i++) {
            char cur = chars[i];
            int val = map.getOrDefault(cur, 0);
            if ((cur == 'V' || cur == 'X') && pre == 'I') {
                res = val - 2 + res;
            } else if ((cur == 'L' || cur == 'C') && pre == 'X') {
                res = val - 20 + res;
            } else if ((cur == 'D' || cur == 'M') && pre == 'C') {
                res = val - 200 + res;
            } else {
                res += val;
            }
            pre = cur;
        }

        return res;
    }

    public static void main(String[] args) {
        int res = new Solution13().romanToInt("MCMXCIV");
        System.out.println(res);
    }
}
