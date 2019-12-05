package com.wesley.growth.leetcode.array;

import java.util.*;

/**
 * <p>
 *  给定两个数组，编写一个函数来计算它们的交集。
 * </p>
 *  示例 1:
 *      输入: nums1 = [1,2,2,1], nums2 = [2,2]
 *      输出: [2,2]
 *  示例 2:
 *      输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 *      输出: [4,9]
 *
 * @author Created by Yani on 2019/12/05
 */
public class Solution350 {

    /**
     * 使用Map结构
     * 使用Hash表, 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i : nums1) {
            map1.put(i, map1.getOrDefault(i, 0) + 1);
        }

        List<Integer> resList = new ArrayList<>();
        for (int j : nums2) {
            Integer count = map1.get(j);
            if (count != null && count > 0 && map1.containsKey(j)) {
                resList.add(j);
                map1.put(j, count - 1);
            }
        }

        int[] r = new int[resList.size()];
        for (int i = 0; i < r.length; i++) {
            r[i] = resList.get(i);
        }

        return r;
    }

    /**
     * 如果数组已经排序, 时间复杂度 O(n)
     *
     */
    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }


}
