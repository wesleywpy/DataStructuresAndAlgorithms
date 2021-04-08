package com.wesley.growth.leetcode.greedy.medium;

/**
 * Solution55
 * 示例 1:
 * 输⼊: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后⼀个位置。
 *
 * 示例 2:
 * 输⼊: [3,2,1,0,4]
 * 输出: false
 * 解释: ⽆论怎样，你总会到达索引为 3 的位置。但该位置的最⼤跳跃⻓度是 0 ， 所以你永远不可能到达最后⼀个位
 * 置。
 * @author WangPanYong
 * @since 2021/04/02 15:28
 */
public class Solution55 {

    /**
     * 贪心算法
     */
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int cover = 0;
        if (len == 1) {
            return true;
        }

        // i每次移动只能在cover的范围内移动，每移动⼀个元素，cover得到该元素数值（新的覆盖范围）的补充，让i继续移动下去
        for (int i = 0; i <= cover; i++) {
            // ⽽cover每次只取 max(该元素数值补充后的范围, cover本身范围)
            cover = Math.max(i + nums[i], cover);
            // 如果cover⼤于等于了终点下标，直接return true就可以了。
            if (cover >= (len - 1)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{3,2,1,0,4};
        boolean res = new Solution55().canJump(prices);
        System.out.println(res);
    }

}
