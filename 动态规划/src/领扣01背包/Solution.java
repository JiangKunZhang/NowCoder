package 领扣01背包;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/2 1:11
 */

/**
 *  状态：
 *      F(i, j): 前i个物品放入大小为j的背包中所获得的最大价值
 *  状态递推：
 *      对于第i个商品，有一种例外，装不下，两种选择，放或者不放
 *      如果装不下：此时的价值与前i-1个的价值是一样的
 *      F(i,j) = F(i-1,j)
 *      如果可以装入：需要在两种选择中找最大的
 *      F(i, j) = max{F(i-1,j), F(i-1, j - A[i]) + V[i]}
 *      F(i-1,j): 表示不把第i个物品放入背包中， 所以它的价值就是前i-1个物品放入大小为j的背包的最大价值
 *      F(i-1, j - A[i]) + V[i]：表示把第i个物品放入背包中，价值增加V[i],但是需要腾出j - A[i]的大小放第i个商品
 *      只要能装下，这时候背包里面的容量够不够都不影响，
 *      容量够的话就是 F(i - 1, j) + V[i]; 不用腾出空间，直接放
 *      容量不够就是F(i - 1, j - A[i]) + V[i]; 需要腾出空间
 *      但是F(i - 1, j - A[i]) + V[i]可以包含第一种情况，所以就把递推式合在一起了。
 *  初始化：
 *      第0行和第0列都为0，表示没有装物品时的价值都为0
 *      F(0,j) = F(i,0) = 0
 *  返回值：
 *      F(n,m)
 */

public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @param V: Given n items with value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int[] V) {
        // write your code here
        int num = A.length;
        if(m == 0 || num == 0)
            return 0;
        //多加一行一列，用于设置初始条件
        int[][] maxValue = new int[num + 1][m + 1];
        //初始化所有位置为0，第一行和第一列都为0，初始条件
        for (int i = 0; i <= num; i++) {
            maxValue[i][0] = 0;
        }
        for (int i = 1; i <= m; i++) {
            maxValue[0][i] = 0;
        }

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= m; j++) {
                //第i个商品在A中对应的索引为i-1: i从1开始
                if (A[i - 1] <= j) {
                    //如果可以装下，分两种情况，装或者不装
                    //如果不装，则即为(i-1, j)
                    //如果装，需要腾出放第i个物品大小的空间： j - A[i-1],装入之后的最大价值即为(i -1, j - A[i-1]) + 第i个商品的价值V[i - 1]
                    //最后在装与不装中选出最大的价值
                    maxValue[i][j] = Math.max(maxValue[i - 1][j], maxValue[i - 1][j - A[i - 1]] + V[i - 1]);
                } else {
                    //如果第i个商品大于j,说明放不下， 所以(i,j)的最大价值和(i-1,j)相同
                    maxValue[i][j] = maxValue[i - 1][j];
                }
            }
        }
        //返回装入前N个商品，物品大小为m的最大价值
        return maxValue[num][m];
    }
}