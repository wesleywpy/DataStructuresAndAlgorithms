package com.wesley.growth.leetcode.array;

import com.wesley.growth.algorithms.sort.util.SortTestHelper;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 示例:
 *  输入: [0,1,0,3,12]
 *  输出: [1,3,12,0,0]
 *
 * 说明:
 *  必须在原数组上操作，不能拷贝额外的数组。
 *  尽量减少操作次数。
 * @author Created by Yani on 2019/11/05
 */
public class Solution283 {

    /**
     *  双指针法, 时间复杂度O(n), 空间复杂度O(1)
     */
    public void moveZeroes(int[] nums) {
        int length = nums.length;

        // [0 ... last) 的元素均为非0元素
        int last = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                nums[last++] = nums[i];
            }
        }

        for (int i = last; i < length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * 双指针法 优化
     */
    public void moveZeroes2(int[] nums) {
        // [0 ... k) 的元素均为非0元素
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != k) {
                    int tmp = nums[i];
                    nums[i] = nums[k];
                    nums[k] = tmp;
                }
                k++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,0,1,0,3,12,0,0};
        new Solution283().moveZeroes2(nums);
        SortTestHelper.print(nums);
    }

}
