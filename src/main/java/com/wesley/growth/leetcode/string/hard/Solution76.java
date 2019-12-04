package com.wesley.growth.leetcode.string.hard;

/**
 * <p>
 *  给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 * </p>
 *
 *  示例:
 *      输入: S = "ADOBECODEBANC", T = "ABC"
 *      输出: "BANC"
 *  说明:
 *      如果 S 中不存这样的子串，则返回空字符串 ""。
 *      如果 S 中存在这样的子串，我们保证它是唯一的答案。
 * @author Created by Yani on 2019/12/04
 */
public class Solution76 {

    public String minWindow(String s, String t) {
        if (s == null || s.trim().equals("") || s.length() < t.length()) {
            return "";
        }

        // [left ... right] 为滑动窗口
        int left = 0;
        int right = 0;
        // 记录最短子串的开始位置和长度
        int start = 0;
        int minLen = Integer.MAX_VALUE;

        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();

        int[] needs = new int[256];
        for (char c : charsT) {
            needs[c]++;
        }
        // 窗口中的字符
        int[] windows = new int[256];
        int total = t.length();
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
                // 选择最小的字符串长度
                if (minLen > (right - left + 1)) {
                    // 更新最小子串的位置和长度
                    start = left;
                    minLen = right - left + 1;
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

        return minLen == Integer.MAX_VALUE ?  "" : s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        String res = new Solution76().minWindow("ADOBECODEBANC", "ABC");
        System.out.println(res);
    }
}
