package com.wesley.growth.leetcode.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  给定一个包含n个整数的数组 nums 和一个目标值 target，
 *  判断nums中是否存在四个元素 a，b，c和d，使得a + b + c + d的值与target相等？找出所有满足条件且不重复的四元组。
 * </p>
 *  注意：
 *  答案中不可以包含重复的四元组。
 *
 * 示例:
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 * @author Created by Yani on 2020/01/03
 */
public class Solution18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);


        for (int k = 1; k < nums.length; k++) {
            int j = k - 1;
        }

        return result;
    }

}
