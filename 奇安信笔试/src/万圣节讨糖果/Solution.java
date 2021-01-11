package 万圣节讨糖果;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/9/12 10:33
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * M包糖果，抛M次硬币，硬币连续n次为正面，最多能得到多少颗糖果
     * @param candies int整型一维数组 每包糖果的数量
     * @param coin int整型一维数组 抛硬币的结果
     * @param n int整型 连续是正面的次数
     * @return int整型
     */
    public static int maxCandies (int[] candies, int[] coin, int n) {
        // write code here
        if (n > candies.length) n = candies.length;
        int[] max = new int[candies.length - n + 1];
        int[] countZero = new int[candies.length - n + 1];
        for (int i = n - 1; i < candies.length; i++) {
            int temp = 0;
            int count = 0;
            for (int j = i - n + 1; j <= i; j++) {
                temp += candies[j];
                if (coin[j] == 0) {
                    count++;
                }
            }
            max[i - n + 1] = temp;
            countZero[i - n + 1] = count;
        }
        int index = 0;
        for (int i = 1; i < max.length; i++) {
            if (max[i] > max[index]) {
                index = i;
                //如果相等
            } else if (max[i] == max[index]) {
                //找0最少的
                if (countZero[i] < countZero[index]) {
                    index = i;
                } else if (countZero[i] == countZero[index]) {
                    if (max[i] > max[index]) {
                        index = i;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (index + i < coin.length)
                coin[index + i] = 0;
        }
        int res = 0;
        for (int i = 0; i < candies.length; i++) {
            if (coin[i] == 0) {
                res += candies[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] candies = {3,3,3,3,3,3,3,3};
        int[] coins = {1,1,1,1,1,1,1,1};
        System.out.println(maxCandies(candies, coins, 11));
    }
}