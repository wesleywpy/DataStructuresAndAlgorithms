package com.wesley.growth.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  给定两个字符串 s 和 t，判断它们是否是同构的。
 *  如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *  所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 * </p>
 *
 *  示例1:
 *      输入: s = "egg", t = "add"
 *      输出: true
 *  示例2:
 *      输入: s = "foo", t = "bar"
 *      输出: false
 * 说明:
 * 假设 s 和 t 具有相同的长度。
 * @author Created by Yani on 2019/12/05
 */
public class Solution205 {

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    public boolean isIsomorphic(String s, String t) {
        if (s.equals(t)) {
            return true;
        }
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        char[] charsS = s.toCharArray();

        for (int i = 0; i < charsS.length; i++) {
            char ch1 = charsS[i];
            char ch2 = t.charAt(i);

            if (map.containsKey(ch1)) {
                if (!map.get(ch1).equals(ch2)) {
                    return false;
                }
            }else{
                if (map.containsValue(ch2)) {
                    return false;
                }
                map.put(ch1, ch2);
            }
        }

        return true;
    }

    public boolean isIsomorphic2(String s, String t) {
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if(s.indexOf(ch1[i]) != t.indexOf(ch2[i])){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean res = new Solution205().isIsomorphic("egg", "add");
        System.out.println(res);
    }

}
