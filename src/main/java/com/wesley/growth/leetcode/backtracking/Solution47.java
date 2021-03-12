package com.wesley.growth.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution46
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 * @author WangPanYong
 * @since 2021/03/11 16:59
 */
public class Solution47 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums.length == 0) {
            return res;
        }

        Arrays.sort(nums);
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        generatePermutition(nums, path, res, used);
        return res;
    }

    /**
     * 时间复杂度 O(n! * n^2)
     * @param used 用数组标记排重 降低时间复杂度
     */
    private void generatePermutition(int[] nums, List<Integer> path, List<List<Integer>> res, boolean[] used) {
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

            System.out.println(path);
            System.out.println(""+ used[0] +"," + used[1] +"," + used[2]);
            // used[i - 1] == true，说明同一树支nums[i - 1]使用过
            // used[i - 1] == false，说明同一树层nums[i - 1]使用过
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) {
                continue;
            }

            // 添加路径节点
            path.add(nums[i]);

            used[i] = true;
            //递归
            generatePermutition(nums, path, res, used);
            // 回溯的过程中，将当前的节点从 path 中删除
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(new Solution47().permute(nums));
    }

}
