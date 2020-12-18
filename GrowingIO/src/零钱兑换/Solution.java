package 零钱兑换;

import java.util.Arrays;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/9/19 22:30
 */
public class Solution {
    /**
     * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。​你可以认为每种硬币的数量是无限的。
     * @param coins int整型一维数组 不同面值的硬币
     * @param amount int整型 目标总金额
     * @return int整型
     */
    public int coinChange (int[] coins, int amount) {
        // write code here
        Arrays.sort(coins);
        int len = coins.length;
        if (len == 0 || amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int j = 0; j < len; j++) {
            for (int i = coins[j]; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}