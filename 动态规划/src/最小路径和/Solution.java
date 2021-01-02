package 最小路径和;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/3 17:11
 */

/**
 * 题目描述：
 *      给定一个m*n的网格，网格用非负数填充，找到一条从左上角到右下角的最短路径。
 *      注：每次只能向下或者向右移动。
 * 方法：动态规划
 * 状态：
 *      子状态：从(0,0)到达(1,0),(1,1),(2,1),...(m-1,n-1)的最短路径
 *      F(i,j): 从(0,0)到达F(i,j)的最短路径
 * 状态递推：
 *      F(i,j) = min{F(i-1,j) , F(i,j-1)} + (i,j)
 * 初始化：
 *      F(0,0) = (0,0)
 *      特殊情况：第0行和第0列
 *      F(0,i) = F(0,i-1) + (0,i)
 *      F(i,0) = F(i-1,0) + (i,0)
 * 返回结果：
 *      F(m-1,n-1)
 */
public class Solution {
    /**
     *
     * @param grid int整型二维数组
     * @return int整型
     */
    public int minPathSum (int[][] grid) {
        // write code here
        // 获取行和列大小
        int row = grid.length;
        int col = grid[0].length;
        // F(i,j)
        int[][] minPath = new int[row][col];
        // F(0,0), F(0,i), F(i,0)初始化
        minPath[0][0] = grid[0][0];
        for (int i = 1; i < row; i++) {
            minPath[i][0] = minPath[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < col; i++) {
            minPath[0][i] = minPath[0][i - 1] + grid[0][i];
        }
        // F(i,j) = min{F(i-1,j) , F(i,j-1)} + (i,j)
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                minPath[i][j] = Math.min(minPath[i - 1][j], minPath[i][j - 1]) + grid[i][j];
            }
        }
        return minPath[row - 1][col - 1];
    }
}