package 岛屿数量;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/5 15:50
 */

/**
 * 本题的意思是连在一起的陆地都算做一个岛屿，本题可以采用类似渲染的做法，尝试以每个点作为渲染的起点，可以渲染的
 * 陆地都算做一个岛屿，最后看渲染了多少次，即深度优先算法执行了多少次
 * 搜索过之后就把那个点变成 '0' 后面就不会重新搜索
 */
public class Solution {
    int[][] position = {{1,0},{-1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        int cnt = 0;
        int row = grid.length;
        int col = grid[0].length;
        //以每一个网格点为渲染起点开始
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    cnt++;
                    dfs(grid, row, col, i, j);
                }
            }
        }
        return cnt;
    }

    public void dfs(char[][] grid, int row, int col, int curX, int curY) {
        //处理当前逻辑
        grid[curX][curY] = '0';
        //遍历每一种可能，四个方向
        for (int i = 0; i < 4; i++) {
            int newX = curX + position[i][0];
            int newY = curY + position[i][1];
            //判断新位置是否越界
            if (newX < 0 || newX >= row || newY < 0 || newY >= col) {
                continue;
            }
            //如果符合要求，并且之前也没有渲染过，则继续渲染
            if (grid[newX][newY] == '1') {
                dfs(grid, row, col, newX, newY);
            }
        }
    }
}
