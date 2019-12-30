package com.wesley.growth.leetcode.array;

import java.util.HashMap;
import java.util.Objects;

/**
 * <p>
 *  给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * </p>
 *
 *  给定 nums = [2, 7, 11, 15], target = 9
 *  因为 nums[0] + nums[1] = 2 + 7 = 9
 *  所以返回 [0, 1]
 *
 * @author Created by Yani on 2019/12/13
 */
public class Solution1 {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> record = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];
            if (Objects.nonNull(record.get(complement))) {
                int[] res = new int[2];
                res[0] = i;
                res[1] = record.get(complement);
                return res;
            }

            record.put(nums[i], i);
        }

        throw new IllegalArgumentException();
    }

}
