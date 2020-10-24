package com.wesley.growth.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution17
 *
 * @author WangPanYong
 * @since 2020/10/20 16:22
 */
public class Solution17 {

    private final String[] letterMap = {
            " ",   // 0
            "",    // 1
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", // 6
            "pqrs",// 7
            "tuv", // 8
            "wxyz" // 9
    };

    private List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() < 1) {
            return res;
        }
        findCombination(digits, 0, "");
        return res;
    }

    /**
     * @param digits 数字字符串
     * @param index 下标
     * @param s 结果字符串
     **/
    private void findCombination(String digits, int index, String s) {
        if (index == digits.length()) {
            res.add(s);
            return;
        }

        // 每一位数字
        char c = digits.charAt(index);
        if (c >= '0' && c <= '9' && c != '1') {
            // 每一位数字对应的字符串
            String letters = letterMap[c - '0'];
            for (int i = 0; i < letters.length(); i++) {
                findCombination(digits, index+1, s.concat(String.valueOf(letters.charAt(i))));
            }
        }

    }

    public static void main(String[] args) {
        new Solution17().letterCombinations("23").forEach(System.out::println);
    }

}
