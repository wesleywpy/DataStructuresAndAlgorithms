package com.wesley.growth.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution90
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * @author WangPanYong
 * @since 2021/03/16 13:56
 */
public class Solution90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        // 排序是剪枝的前提
        Arrays.sort(nums);
        dfs(nums, 0, path, res);
        return res;
    }

    private void dfs(int[] nums, int start, List<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {

//            System.out.print(" ==> start="+ start +"    ");
            // 剪枝：前提nums[]已排序, nums[i] == nums[i - 1] 说明 同一树层相同数值的结点 因此跳过
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            // 添加路径结点
            path.add(nums[i]);
//            System.out.print("i="+ i +", start="+ start +"    ");
//            System.out.println(path);

            // 因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i
            dfs(nums, i + 1, path, res);

            // 回溯
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> res = new Solution90().subsetsWithDup(nums);
        System.out.println(res);
    }

}
