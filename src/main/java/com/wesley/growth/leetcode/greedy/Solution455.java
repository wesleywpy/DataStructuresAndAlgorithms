package com.wesley.growth.leetcode.greedy;

import java.util.Arrays;

/**
 * Solution455
 *
 * @author WangPanYong
 * @since 2021/03/23 15:04
 */
public class Solution455 {

    /**
     *
     * @param g 对每个孩子 i，都有一个胃口值 g[i]
     * @param s 并且每块饼干 j，都有一个尺寸 s[j]
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        int i = 0;
        for (int j = 0; j < s.length; j++) {
            // ⼩饼⼲先喂饱⼩胃⼝
            if (i < g.length && s[j] >= g[i]) {
                i++;
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] g = new int[]{1, 2, 7, 10};
        int[] s = new int[]{1, 3, 5, 9};
        int res = new Solution455().findContentChildren(g, s);
        System.out.println(res);
    }
}
