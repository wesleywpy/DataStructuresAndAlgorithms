package com.wesley.growth.leetcode.string.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 *  字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *
 *  说明：
 *  字母异位词指字母相同，但排列不同的字符串。
 *  不考虑答案输出的顺序。
 *
 *  输入:
 *      s: "cbaebabacd" p: "abc"
 *  输出:
 *      [0, 6]
 *  解释:
 *  起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 *  起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 * </p>
 *
 * @author Created by Yani on 2019/11/26
 */
public class Solution438 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s == null || s.trim().equals("") || s.length() < p.length()) {
            return result;
        }

        // [left ... right] 为滑动窗口
        int left = 0;
        int right = 0;

        char[] charsS = s.toCharArray();
        char[] charsP = p.toCharArray();

        int[] needs = new int[256];
        for (char c : charsP) {
            needs[c]++;
        }

        int[] windows = new int[256];
        // 目标字符数
        int total = p.length();
        while (right < charsS.length) {
            char ch = charsS[right];

            // 目标字符是否存在
            if (needs[ch] > 0) {
                windows[ch]++;
                //  固定窗口中 目标字符数量 大于 滑动窗口中的数量
                if (needs[ch] >= windows[ch]) {
                    total--;
                }
            }

            // 窗口中已经包含目标字符串
            while (total == 0) {
                // 如果 window 的大小合适, 就把起始索引 left 加入结果
                if ((right - left + 1) == p.length()) {
                    result.add(left);
                }

                char chLeft = charsS[left];
                if (needs[chLeft] > 0) {
                    windows[chLeft]--;
                    if (needs[chLeft] > windows[chLeft]) {
                        total++;
                    }
                }
                left++;
            }

            right++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] windows = new int[256];
        List<Integer> res = new Solution438().findAnagrams("cbaebabacd", "abc");
        System.out.println(res);
    }
}
