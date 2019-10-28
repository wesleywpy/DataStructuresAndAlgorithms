package com.wesley.growth.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author Created by Yani on 2019/10/28
 */
public class Solution118 {

    /**
     * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
     * 在杨辉三角中，每个数是它左上方和右上方的数的和。
     * 示例:
     * [
     *      [1],
     *     [1,1],
     *    [1,2,1],
     *   [1,3,3,1],
     *  [1,4,6,4,1]
     * ]
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        if (numRows == 0) {
            return result;
        }

        List<Integer> first = new ArrayList<>(1);
        first.add(1);
        result.add(first);

        Integer[] pre = first.toArray(new Integer[]{});
        for (int i = 2; i <= numRows; i++) {
            Integer[] cur = new Integer[i];
            cur[0] = 1;
            cur[i - 1] = 1;
            for (int j = 1; j < (i - 1); j++) {
                cur[j] = pre[j - 1] + pre[j];
            }
            result.add(Arrays.asList(cur));
            pre = cur;
        }

        return result;
    }


}
