package com.wesley.growth.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution216
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * 说明：
 *   所有数字都是正整数。
 *   解集不能包含重复的组合。
 * @author WangPanYong
 * @since 2021/03/16 09:33
 */
public class Solution216 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(k, n, 1, path, res);
        return res;
    }


    /**
     * @param k 组合的个数
     * @param target 所有数相加之和
     * @param start 起始搜索位置
     */
    private void dfs(int k, int target, int start, List<Integer> path, List<List<Integer>> res) {
        // 路径节点数 等于 k 返回
        if (path.size() == k && target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 路径节点数 大于 k 直接返回
        if (path.size() > k) {
            return;
        }

        if (target < 0) {
            return;
        }

//        System.out.println(path);
        for (int i = start; i <= 9; i++) {
            // 如果 target 减去一个数得到负数，那么减去一个更大的树依然是负数，同样搜索不到结果。
            if (target - i < 0) {
                break;
            }

            // 添加路径节点
            path.add(i);

            // 因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i
            dfs(k, target - i, i + 1, path, res);

            // 回溯过程，将当前节点从 path 中删除
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new Solution216().combinationSum3(3, 12);
        System.out.println(res);
    }

}
