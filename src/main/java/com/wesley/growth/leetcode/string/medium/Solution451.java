package com.wesley.growth.leetcode.string.medium;

import java.util.Arrays;
import java.util.HashMap;

/**
 * <p>
 *  给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 *  字符大小写敏感
 * </p>
 *
 * 示例1:
 *  输入:
 *  "tree"
 *
 *  输出:
 *  "eert"
 *
 *  解释:
 *  'e'出现两次，'r'和't'都只出现一次。因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 *
 * @author Created by Yani on 2019/12/10
 */
public class Solution451 {

    public String frequencySort(String s) {
        HashMap<Integer, String> map = new HashMap<>();

        int[] freq = new int[256];
        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                char ch = (char) i;

                String str = map.get(freq[i]);
                // 字符出现次数相同, 进行拼接
                if (str != null) {
                    String strNew = str.concat(build(ch, freq[i]));
                    map.put(freq[i], strNew);
                }else {
                    map.put(freq[i], build(ch, freq[i]));
                }
            }
        }

        // 按照字符频率排序
        Integer[] keys = map.keySet().toArray(new Integer[]{});
        Arrays.sort(keys);
        StringBuilder sbl = new StringBuilder();
        for (int i = keys.length - 1; i >= 0; i--) {
            sbl.append(map.get(keys[i]));
        }

        return sbl.toString();
    }

    private String build(char ch, int times) {
        String string = Character.toString(ch);
        StringBuilder res = new StringBuilder(string);
        int t = 1;
        while (t < times) {
            res.append(string);
            t++;
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String res = new Solution451().frequencySort("tree");
        System.out.println(res);
    }

}
