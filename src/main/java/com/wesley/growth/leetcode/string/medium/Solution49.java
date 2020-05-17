package com.wesley.growth.leetcode.string.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 示例:
 *   输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 *   输出:
 *  [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 *  ]
 *
 * 说明:
 *  所有输入均为小写字母。
 *  不考虑答案输出的顺序。
 * @author Created by Wesley on 2020/1/7
 */
public class Solution49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            List<String> anagrams = map.getOrDefault(strs[i], new ArrayList<String>());


        }


        return res;
    }

}
