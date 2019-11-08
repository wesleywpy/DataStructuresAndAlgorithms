package com.wesley.growth.leetcode.math;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author Created by Yani on 2019/10/31
 */
public class Solution169 {

    /**
     * 求众数
     *
     * 给定一个大小为 n 的数组，找到其中的众数。
     * 众数是指在数组中出现次数大于 n/2 的元素。
     * 你可以假设数组是非空的，并且给定的数组总是存在众数。
     */
    public int majorityElement(int[] nums) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) +  1);
            }else{
                map.put(num, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > (length / 2)) {
                return entry.getKey();
            }
        }

        return 0;
    }

    /**
     * 摩尔投票法
     * 寻找数组中超过一半的数字，这意味着数组中其他数字出现次数的总和都是比不上这个数字出现的次数
     * 即如果把 该众数记为 +1 ，把其他数记为 −1 ，将它们全部加起来，和是大于 0 的。
     */
    public int majorityElement2(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            // 如果出现次数 count 变为 0 ，candidate 进行变化，保存为当前遍历的那个数字，并且同时把 count 重置为 1
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            }
            else if (candidate == nums[i]) {
                count ++;
            }else{
                count --;
            }
        }
        return candidate;
    }


}
