package com.wesley.growth.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 *
 * </p>
 *
 * @author Created by Yani on 2019/10/28
 */
public class Solution136 {

    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * 算法应该具有线性时间复杂度
     *
     * 实例:
     *  输入: [4,1,2,1,2]
     *  输出: 4
     */
    public int singleNumber(int[] nums) {
        Set<Integer> sets = new HashSet<>();

        for (int num : nums) {
            if (sets.contains(num)) {
                sets.remove(num);
            } else {
                sets.add(num);
            }
        }
        return sets.iterator().next();
    }

    /**
     * 使用异或运算
     * 异或运算性质
     * 1. 一个值和0进行按位异或操作所得为该值
     * 2. 相同值进行异或运行 所得为0
     * 3. 异或运算满足交换率 a^b^c = a^c^b
     */
    public int singleNumber2(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素
     * 算法应该具有线性时间复杂度
     * 示例:
     *  输入: [0,1,0,1,0,1,99]
     *  输出: 99
     */
    public int singleNumber3(int[] nums) {

        return 0;
    }

}
