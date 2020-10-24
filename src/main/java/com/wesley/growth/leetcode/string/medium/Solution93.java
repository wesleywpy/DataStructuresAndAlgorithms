package com.wesley.growth.leetcode.string.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Solution93
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。
 * @author WangPanYong
 * @since 2020/10/21 16:43
 */
public class Solution93 {
    private final List<String> result = new ArrayList<>();
    private final Deque<String> path = new ArrayDeque<>(4);

    /**
     * 0 <= s.length <= 3000
     * s 仅由数字组成
     */
    public List<String> restoreIpAddresses(String s) {
        // 字符串的长度小于 4 或者大于 12 ，一定不能拼凑出合法的 ip 地址
        if (s == null || s.length() < 4 || s.length() > 12) {
            return result;
        }

        dfs(s,  0, 4);
        return result;
    }

    /**
     *
     * @param digits
     * @param begin
     * @param residue 记录剩余多少段还没被分割
     */
    private void dfs(String digits, int begin, int residue) {
        int length = digits.length();
        if (begin == length) {
            if (residue == 0) {
                result.add(String.join(".", path));
            }
            return;
        }

        // 每一个结点可以生长出的分支最多只有 3 条分支
        for (int i = begin; i < begin + 3; i++) {
            if (i >= length) {
                break;
            }

            if (residue - 1 > length - 1 - i) {
                break;
            }

            if (residue * 3 < length - i) {
                continue;
            }

            if (isIpSegment(digits, begin, i)) {
                String currentIpSegment = digits.substring(begin, i + 1);
                path.addLast(currentIpSegment);

                dfs(digits, i + 1, residue - 1);
                path.removeLast();
            }

        }

    }

    /**
     * 判断 s 的子区间 [left, right] 是否能够成为一个 ip 段
     */
    private boolean isIpSegment(String s, int left, int right) {
        int idx = right - left + 1;

        // 大于1位, 不能以0开头
        if (idx > 1 && s.charAt(left) == '0') {
            return false;
        }

        int res = 0;
        while (left <= right) {
            res = res * 10 + s.charAt(left) - '0';
            left ++;
        }

        return res >= 0 && res <= 255;
    }

    public static void main(String[] args) {
        String res = "101023".substring(1);
        new Solution93().restoreIpAddresses("101023")
                        .forEach(System.out::println);
    }

}
