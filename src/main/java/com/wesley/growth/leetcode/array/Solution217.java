package com.wesley.growth.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 *
 * 示例 1:
 *   输入: [1,2,3,1]
 *   输出: true
 * 示例 2:
 *   输入: [1,2,3,4]
 *   输出: false
 * @author Created by Wesley on 2020/1/7
 */
public class Solution217 {

    /**
     * Hash表
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }

        return false;
    }

    /**
     * 排序
     * 时间复杂度: nlogn
     */
    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                return true;
            }
        }
        return false;
    }



}
