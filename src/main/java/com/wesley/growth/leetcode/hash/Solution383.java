package com.wesley.growth.leetcode.hash;

/**
 * Solution383
 *
 * @author WangPanYong
 * @since 2022/01/10 10:57
 */
public class Solution383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        if (null == ransomNote || null == magazine || ransomNote.length() > magazine.length()) {
            return false;
        }

        // 利用字符的ASCII码
        int[] freq = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            freq[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            int cnt = freq[ransomNote.charAt(i) - 'a'];
            if (cnt > 0) {
                freq[ransomNote.charAt(i) - 'a']--;
            }else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        boolean res = new Solution383().canConstruct("aa", "aab");
        System.out.println(res);
    }


}
