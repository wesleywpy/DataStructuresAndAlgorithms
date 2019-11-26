package com.wesley.growth.leetcode;

/**
 * <p>
 *  LeetCode11
 * </p>
 *
 * @author Created by Yani on 2019/11/22
 */
public class Solution11 {

    public int maxArea(int[] height) {
        // [left ... right] 对撞指针
        int left = 0;
        int right = height.length - 1;

        int res = -1;
        while (left < right) {
            int edge = right - left;
            int area = height[left] < height[right] ? edge * height[left] : edge * height[right];
            res = area > res ? area : res;

            // 两个指针相互靠近时，矩形的底是变小的，所以只有高变大才有可能面积变大，所以 让短的那个边向中间靠近
            if (height[left] < height[right]) {
                left++;
            } else{
                right --;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2,5,25,24,5};
        int maxArea = new Solution11().maxArea(nums);
        System.out.println(maxArea);
    }


}
