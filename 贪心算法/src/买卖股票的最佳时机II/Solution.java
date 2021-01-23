package 买卖股票的最佳时机II;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/4 15:52
 */

/**
 * 贪心策略
 * 连续上涨交易日： 则第一天买最后一天卖收益最大，等价于每天都买卖
 * 连续下降交易日： 则不买卖收益最大，即不会亏钱。
 * 故可以遍历整个股票交易日价格列表，在所有上涨交易日都买卖（赚到所有利润），所有下降交易日都不买卖（永不亏
 * 钱）。
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            //第一天买最后一天卖收益最大，等价于每天都买卖
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}