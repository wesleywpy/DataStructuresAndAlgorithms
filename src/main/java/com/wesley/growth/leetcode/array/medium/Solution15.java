package com.wesley.growth.leetcode.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * </p>
 *  注意：答案中不可以包含重复的三元组。
 *
 *  例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]
 *  满足要求的三元组集合为：
 *  [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 *  ]
 * @author Created by Yani on 2019/12/24
 */
public class Solution15 {

    /**
     * 排序 + 双指针
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);
        // 锚点
        for (int k = 0; k < nums.length; k++) {
            // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if(nums[k] > 0) {
                break;
            }

            // 当前元素和前一个元素比较 进行锚点去重
            if(k > 0 && nums[k] == nums[k-1]) {
                continue;
            }

            int left = k+1;
            int right = nums.length -1;

            while (left < right) {
                int target = nums[left] + nums[k] + nums[right];
                if (target > 0) {
                    right --;
                } else if (target < 0) {
                    left ++;
                } else {
                    result.add(Arrays.asList(nums[k], nums[left], nums[right]));
                    // 去重
                    while (left < right && nums[left] == nums[left+1]) {
                        left++;
                    }
                    // 去重
                    while (left < right && nums[right] == nums[right-1]) {
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new Solution15().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(res);
    }
}
