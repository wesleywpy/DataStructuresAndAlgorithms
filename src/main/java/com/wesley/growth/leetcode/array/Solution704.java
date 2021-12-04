package com.wesley.growth.leetcode.array;

/**
 * Solution704
 * 二分查找
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * @author WangPanYong
 * @since 2021/08/23 15:44
 */
public class Solution704 {

    /**
     * 二分法使用条件
     * 数组为有序数组，同时还强调数组中无重复元素
     * @param nums
     * @param target 定义target 是在一个在左闭右闭的区间里，也就是[left, right] （这个很重要非常重要）
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        // 定义target 是在一个在左闭右闭的区间里，也就是[left, right] （这个很重要非常重要）
        int right = nums.length - 1;
        // 当left==right，区间[left, right]依然有效，所以用 <=
        while (left <= right) {
            // left + ((left + right)/2) 找到每次查找后的中间下标
            // (right - left) >> 1 防止两个特别大的int类型相加溢出, 等同于(left + right)/2
            int middle = left + ((right - left) >> 1);

            if (nums[middle] > target) {
                // target 在左区间，所以[left, middle - 1]
                right = middle - 1;
            } else if (nums[middle] < target) {
                // target 在右区间，所以[middle + 1, right]
                left = middle + 1;
            } else {
                return middle;
            }
        }

        return -1;
    }

    public int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        // 定义target 是在一个在左闭右开的区间里，也就是[left, right) （这个很重要非常重要）
        int right = nums.length;
        // 这里使用 < ,因为left == right在区间[left, right)是没有意义的
        while (left < right) {
            // 防止溢出 等同于(left + right) / 2
            int middle = left + ((right - left) >> 1);
            if (nums[middle] > target) {
                // target 在左区间，在[left, middle)中
                right = middle;
            } else if (nums[middle] < target) {
                // target 在右区间，所以[middle + 1, right]
                left = middle + 1;
            } else {
                return middle;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 4, 6, 8, 11, 15};
        int res = new Solution704().search(nums, 1);
        System.out.println(res);
    }


}
