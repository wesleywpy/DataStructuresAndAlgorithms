package com.wesley.growth.leetcode.greedy;

/**
 * Solution122
 *
 * 示例 1:
 * 输⼊: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买⼊，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1
 * = 4。随后，在第 4 天（股票价格 = 3）的时候买⼊，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利
 * 润 = 6-3 = 3 。
 *
 * 示例 2:
 * 输⼊: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买⼊，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-
 * 1 = 4 。注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。因为这样属于同时参与了多笔交易，你
 * 必须在再次购买前出售掉之前的股票。
 *
 * 示例 3:
 * 输⼊: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最⼤利润为 0。
 *
 * @author WangPanYong
 * @since 2021/03/31 11:42
 */
public class Solution122 {

    /**
     * 贪心算法
     * 收集正利润的区间，就是股票买卖的区间，⽽我们只需要关注最终利润，不需要记录区间。
     * 局部最优：收集每天的正利润，全局最优：求得最⼤利润。
     * @param prices
     */
    public int maxProfit(int[] prices) {
        int res = 0;

        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - prices[i - 1];
            if (profit < 0) {
                continue;
            }
            res += profit;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1,2,3,4,5};
        int res = new Solution122().maxProfit(prices);
        System.out.println(res);
    }


}
