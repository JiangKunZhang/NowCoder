package 路径总数;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/3 17:30
 */

/**
 * 题目描述：
 *      在一个m*n的网格的左上角有一个机器人，机器人在任何时候只能向下或者向右移动，
 *      机器人试图到达网格的右下角，有多少可能的路径。
 * 方法：动态规划
 * 状态：
 *      子状态：从(0,0)到达(1,0),(1,1),(2,1),...(m-1,n-1)的路径数
 *      F(i,j): 从(0,0)到达F(i,j)的路径数
 * 状态递推：
 *      F(i,j) = F(i-1,j) + F(i,j-1)
 * 初始化：
 *      特殊情况：第0行和第0列
 *      F(0,i) = 1
 *      F(i,0) = 1
 * 返回结果：
 *      F(m-1,n-1)
 */
public class Solution {
    /**
     *
     * @param m int整型
     * @param n int整型
     * @return int整型
     */
    public int uniquePaths (int m, int n) {
        // write code here
        int[][] paths = new int[m][n];
        // 申请F(i,j)空间，初始化
        for (int i = 0; i < m; i++) {
            paths[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            paths[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // F(i,j) = F(i-1,j) + F(i,j-1)
                paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
            }
        }
        return paths[m - 1][n - 1];
    }
}