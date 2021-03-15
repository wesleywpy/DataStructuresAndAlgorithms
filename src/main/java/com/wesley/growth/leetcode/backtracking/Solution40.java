package com.wesley.growth.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution40
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 *
 * @author WangPanYong
 * @since 2021/03/15 16:51
 */
public class Solution40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        // 排序是剪枝的前提
        Arrays.sort(candidates);
        dfs(candidates, target, 0, path, res);
        return res;
    }

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
            // 如果 target 减去一个数得到负数，那么减去一个更大的树依然是负数，同样搜索不到结果。
            if (target - nums[i] < 0) {
                break;
            }

            // 小剪枝：同一层相同数值的结点，从第 2 个开始，候选数更少，结果一定发生重复，因此跳过
            if (i > start && nums[i] == nums[i-1]) {
                continue;
            }

            // 添加路径节点
            path.add(nums[i]);

            // 因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i
            dfs(nums, target - nums[i], i + 1, path, res);

            // 回溯过程中，将当前的节点从 path 中删除
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 2, 1, 2};
        System.out.println(new Solution40().combinationSum2(nums, 5));
    }

}
