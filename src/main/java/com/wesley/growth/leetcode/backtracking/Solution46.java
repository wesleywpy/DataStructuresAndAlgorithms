package com.wesley.growth.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution46
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * @author WangPanYong
 * @since 2021/03/11 16:59
 */
public class Solution46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums.length == 0) {
            return res;
        }

        List<Integer> path = new ArrayList<>();
//        dfs1(nums, -1, path, res);
//        dfs2(nums, path, res);
//        generatePermutition(nums, path, res);

        boolean[] used = new boolean[nums.length];
        generatePermutition2(nums, path, res, used);
        return res;
    }

    /**
     * 深度优先遍历 版本1
     * @param nums 目标数组
     * @param index 下标
     * @param path 路径
     */
    private void dfs1(int[] nums, int index, List<Integer> path, List<List<Integer>> res) {
        // 路径长度 等于 数组长度 已递归到底, 直接返回
        if (path.size() == nums.length) {
            return;
        }

        // 添加路径节点 排除根节点
        if (index != -1) {
            path.add(nums[index]);
        }

        // 添加路径节点之后 路径长度==数组长度 则放入结果列表
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
        }

        for (int i = 0; i < nums.length; i++) {
            dfs1(nums, i, path, res);
        }

        // 回溯的过程中，将当前的节点从 path 中删除
        if (index != -1) {
            path.remove(path.size() - 1);
        }
    }

    /**
     * 深度优先遍历 版本2
     * 回溯算法代码模板
     * @param nums 目标数组
     * @param path 路径
     */
    private void dfs2(int[] nums, List<Integer> path, List<List<Integer>> res) {
        // 路径长度 == 数组长度 则放入结果列表
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 添加路径节点
            path.add(nums[i]);
            //递归
            dfs2(nums, path, res);
            // 回溯的过程中，将当前的节点从 path 中删除
            path.remove(path.size() - 1);
        }
    }

    /**
     * 题解1
     * @param nums 目标数组
     * @param path 路径
     */
    private void generatePermutition(int[] nums, List<Integer> path, List<List<Integer>> res) {
        // 路径长度 == 数组长度 则放入结果列表
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 剪枝，判断重复使用的数字
            if (path.contains(nums[i])) {
                continue;
            }
            // 添加路径节点
            path.add(nums[i]);
            //递归
            generatePermutition(nums, path, res);
            // 回溯的过程中，将当前的节点从 path 中删除
            path.remove(path.size() - 1);
        }
    }

    /**
     * 时间复杂度 O(n! * n^2)
     * @param used 用数组标记排重 降低时间复杂度
     */
    private void generatePermutition2(int[] nums, List<Integer> path, List<List<Integer>> res, boolean[] used) {
        // 路径长度 == 数组长度 则放入结果列表
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 剪枝，判断重复使用的数字
            if (used[i]) {
                continue;
            }

            // 添加路径节点
            path.add(nums[i]);

            used[i] = true;
            //递归
            generatePermutition2(nums, path, res, used);
            // 回溯的过程中，将当前的节点从 path 中删除
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Solution46().permute(nums));
    }

}
