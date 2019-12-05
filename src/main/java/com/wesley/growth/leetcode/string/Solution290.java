package com.wesley.growth.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 *  这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 * </p>
 *
 *  示例1:
 *      输入: pattern = "abba", str = "dog cat cat dog"
 *      输出: true
 *  示例 4:
 *      输入: pattern = "abba", str = "dog dog dog dog"
 *      输出: false
 * @author Created by Yani on 2019/12/05
 */
public class Solution290 {

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    public boolean wordPattern(String pattern, String str) {
        if (pattern.isEmpty() || str.isEmpty()) {
            return false;
        }

        Map<Character, String> map = new HashMap<>();
        String[] strArray = str.split(" ");

        if (pattern.length() != strArray.length) {
            return false;
        }

        char[] chars = pattern.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (map.containsKey(ch)) {
                String tmp = map.get(ch);
                // key相同 value必须相同
                if (!tmp.equals(strArray[i])) {
                    return false;
                }
            }else{
                // 不同key必须是不同value
                if (map.containsValue(strArray[i])) {
                    return false;
                }
                // 建立映射关系
                map.put(chars[i], strArray[i]);
            }
        }

        return true;
    }

}
