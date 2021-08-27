package com.wesley.growth.leetcode.array.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution904
 *
 * @author WangPanYong
 * @since 2021/08/26 11:22
 */
public class Solution904 {

    /**
     *
     * 在一排树中，第 i 棵树产生 tree[i] 型的水果。
     * 你可以从你选择的任何树开始，然后重复执行以下步骤：
     *
     * 把这棵树上的水果放进你的篮子里。如果你做不到，就停下来。
     * 移动到当前树右侧的下一棵树。如果右边没有树，就停下来。
     * 请注意，在选择一颗树后，你没有任何选择：你必须执行步骤 1，然后执行步骤 2，然后返回步骤 1，然后执行步骤 2，依此类推，直至停止。
     *
     * 你有两个篮子，每个篮子可以携带任何数量的水果，但你希望每个篮子只携带一种类型的水果。
     *
     * 用这个程序你能收集的水果树的最大总量是多少？
     *
     */

    public int totalFruit(int[] fruits) {
        if (fruits == null || fruits.length == 0) {
            return 0;
        }

        int left = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < fruits.length; i++) {
            map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);
            // 不符合条件：水果种类大于2
            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                // 左边界
                left++;
            }
            // 更新结果
            res = Math.max(res, i - left + 1);
        }

        return res;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{3, 3, 3, 1, 2, 1, 1, 3, 3, 4};
        int[] nums = new int[]{1, 2, 3, 2, 2};
        new Solution904().totalFruit(nums);
    }
}
