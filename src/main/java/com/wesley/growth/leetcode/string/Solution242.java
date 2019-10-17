package com.wesley.growth.leetcode.string;

/**
 * <p>
 *
 *  一种把某个词或句子的字母的位置（顺序）加以改换所形成的新词，英文叫做anagram，词典把这个词翻译成“异位词”
 * </p>
 *
 * @author Created by Yani on 2019/10/17
 */
public class Solution242 {

    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     */
    public boolean isAnagram(String s, String t) {
        if (t.length() != s.length()) {
            return false;
        }

        char[] arr1 = new char[26];
        char[] arr2 = new char[26];
        for (char c : s.toCharArray()) {
            arr1[c - 'a'] ++;
        }

        for (char c : t.toCharArray()) {
            arr2[c - 'a'] ++;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }

}
