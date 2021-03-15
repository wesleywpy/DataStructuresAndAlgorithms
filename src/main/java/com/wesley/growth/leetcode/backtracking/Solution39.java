package com.wesley.growth.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution39
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 说明：
 *  1. 所有数字（包括 target）都是正整数。
 *  2. 解集不能包含重复的组合。
 *
 * @author WangPanYong
 * @since 2021/03/15 15:15
 */
public class Solution39 {

    /**
     * 排重技巧
     * 什么时候使用 used 数组，什么时候使用 begin(start) 变量
     *   排列问题，讲究顺序（即 [2, 2, 3] 与 [2, 3, 2] 视为不同列表时），需要记录哪些数字已经使用过，此时用 used 数组；
     *   组合问题，不讲究顺序（即 [2, 2, 3] 与 [2, 3, 2] 视为相同列表时），需要按照某种顺序搜索，此时使用 begin 变量。
     * 注意：具体问题应该具体分析， 理解算法的设计思想
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        // 排序是剪枝的前提
        Arrays.sort(candidates);
        dfs(candidates, target, 0, path, res);
        return res;
    }


    /**
     * 遇到这一类相同元素不计算顺序的问题，我们在搜索的时候就需要 按某种顺序搜索。具体的做法是：每一次搜索的时候设置 下一轮搜索的起点
     * @param start 搜索起点
     * @param path 路径
     */
    private void dfs(int[] nums, int target, int start, List<Integer> path, List<List<Integer>> res) {
        // 目标组合
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 退出
        if (target < 0) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            // 重点理解这里剪枝，前提是候选数组已经有序，
            // 如果 target 减去一个数得到负数，那么减去一个更大的树依然是负数，同样搜索不到结果。
            if (target - nums[i] < 0) {
                break;
            }

            // 添加路径节点
            path.add(nums[i]);

            // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
            dfs(nums, target - nums[i], i, path, res);

            // 回溯过程中，将当前的节点从 path 中删除
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 7};
        List<List<Integer>> res = new Solution39().combinationSum(nums, 7);
        System.out.println(res);
    }


}
