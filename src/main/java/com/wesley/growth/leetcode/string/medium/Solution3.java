package com.wesley.growth.leetcode.string.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例1:
 *  输入: "abcabcbb"
 *  输出: 3
 *  解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * </p>
 *
 * @author Created by Yani on 2019/11/25
 */
public class Solution3 {

    public int lengthOfLongestSubstring(String s) {
        // [left ... right] 为滑动窗口
        int left = 0;
        int right = -1;
        int res = 0;
        int[] freq = new int[256];

        while (left < s.length()) {
            // right 指针向右
            if (right + 1 < s.length() && freq[s.charAt(right+1)] == 0) {
                right++;
                freq[s.charAt(right)]++;
            }else{
                // left 指针向右
                freq[s.charAt(left)]--;
                left++;
            }
            int tmp = right - left + 1;
            res = tmp > res ? tmp : res;
        }
        return res;
    }

    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        // try to extend the range [i, j]
        for (int right = 0, left = 0; right < n; right++) {
            if (map.containsKey(s.charAt(right))) {
                // 已经存在字符的索引
                int tmp = map.get(s.charAt(right));
                left = Math.max(tmp, left);
            }
            res = Math.max(res, right - left + 1);
            map.put(s.charAt(right), right + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int res = new Solution3().lengthOfLongestSubstring2("abcdabcbb");
        System.out.println(res);
    }

}
