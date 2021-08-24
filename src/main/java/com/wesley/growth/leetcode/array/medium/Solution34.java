package com.wesley.growth.leetcode.array.medium;

/**
 * Solution34
 * 在排序数组中查找元素的第一个和最后一个位置
 * @author WangPanYong
 * @since 2021/08/24 14:57
 */
public class Solution34 {

    /**
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     * @param nums
     * @param target
     * @return 如果数组中不存在目标值 target，返回 [-1, -1]。
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int left = left(nums, target);
        if (left == -1) {
            return new int[] {-1, -1};
        }
        int right = right(nums, target);
        return new int[] {left, right};
    }

    public int left(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        // 定义target 是在一个在左闭右闭的区间里，也就是[left, right]
        while (left <= right) {
            // 防止溢出
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                // 缩小右边界，在左半部分继续查找
                right = mid - 1;
            }
        }

        // 当要查找的元素大于排序数组中所有元素时 left == nums.length
        // 当要查找的元素小于排序数组中所有元素时 nums[left] != target
        if (left == nums.length || nums[left] != target) {
            return -1;
        }

        return left;
    }

    public int right(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        // 定义target 是在一个在左闭右闭的区间里，也就是[left, right]
        while (left <= right) {
            // 防止溢出
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                // 缩小左边界，在右半部分继续查找
                left = mid + 1;
            }
        }

        // 当要查找的元素大于排序数组中所有元素时 nums[right] != target
        // 当要查找的元素小于排序数组中所有元素时 right == -1
        if (right == -1 || nums[right] != target) {
            return -1;
        }

        return right;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        new Solution34().searchRange(nums, 1);
    }


}
