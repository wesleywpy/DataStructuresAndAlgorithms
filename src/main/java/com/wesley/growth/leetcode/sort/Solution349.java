package com.wesley.growth.leetcode.sort;

import java.util.HashSet;

/**
 * <p>
 *  给定两个数组，编写一个函数来计算它们的交集。
 * </p>
 * Email yani@uoko.com
 *
 * @author Created by Yani on 2019/10/09
 */
public class Solution349 {

    /**
     * @return 输出结果中的每个元素一定是唯一的, 可以不考虑输出结果的顺序
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }

        HashSet<Integer> set2 = new HashSet<>(nums1.length);
        for (int j = 0; j < nums2.length; j++) {
            if (set1.contains(nums2[j])) {
                set2.add(nums2[j]);
            }
        }

        Integer[] res = set2.toArray(new Integer[]{});
        int[] r = new int[res.length];
        for (int i = 0; i < res.length; i++) {
            r[i] = res[i];
        }

        return r;
    }
}
