package com.wesley.growth.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution78
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * @author WangPanYong
 * @since 2021/03/16 10:09
 */
public class Solution78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(nums, 0, path, res);
        return res;
    }

    /**
     * 位运算 技巧
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets2(int[] nums) {
        int size = nums.length;
        int n = 1 << size;
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                if (((i >> j) & 1) == 1) {
                    cur.add(nums[j]);
                }
            }
            res.add(cur);
        }
        return res;
    }


    private void dfs(int[] nums, int start, List<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));
//        System.out.println(path);
        for (int i = start; i < nums.length; i++) {
            // 添加路径节点
            path.add(nums[i]);

            // 因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i
            dfs(nums, i + 1, path, res);

            // 回溯
            path.remove(path.size() - 1);
        }
    }



    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = new Solution78().subsets2(nums);
        System.out.println(res);
    }

}
