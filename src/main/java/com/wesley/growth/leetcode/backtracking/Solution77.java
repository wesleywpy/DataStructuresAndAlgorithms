package com.wesley.growth.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution77
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * @author WangPanYong
 * @since 2021/03/15 10:17
 */
public class Solution77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();

        // 无意义
        if (k <= 0 || k > n) {
            return res;
        }

        LinkedList<Integer> path = new LinkedList<>();
        dfs(n, k, 1, path, res);
        return res;
    }

    /**
     * Solution46
     * {@link Solution46#backtrackTemplate(int[], List, List)}.
     * @param start 起始位置
     */
    private void dfs(int n, int k, int start, LinkedList<Integer> path, List<List<Integer>> res) {
        // 路径长度 等于 目标长度 则放入结果列表
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 剪枝
        // 搜索起点的上界 + 接下来要选择的元素个数 - 1 = n
        // 接下来要选择的元素个数 = k - path.size()
        // 整理得到: 搜索起点的上界 = n - (k - path.size()) + 1
        for (int i = start; i <= n - (k - path.size()) + 1; i++) {
            // 添加路径节点
            path.addLast(i);

            dfs(n, k, i+1, path, res);

            // 回溯的过程中，将当前的节点从 path 中删除
            path.removeLast();
        }
    }


    public static void main(String[] args) {
        List<List<Integer>> res = new Solution77().combine(4, 2);
        System.out.println(res);
    }

}
