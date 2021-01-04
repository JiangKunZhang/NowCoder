package 被围绕的区域;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/5 14:43
 */

/**
 * 从每一个边缘的o开始，只要和边缘的o联通，则它就没有被包围。
 * 1.首先寻找边上的每一个o，如果没有，表示所有的o都被包围
 * 2.对于边上的每一个o进行dfs进行扩散，先把边上的每一个o用特殊符号标记，比如*，#等，
 * 3.把和它相邻的o都替换为特殊符号，每一个新的位置都做相同的dfs操作
 * 4.所有扩散结束之后，把特殊符号的位置（和边界连通）还原为o,原来为o的位置（和边界不连通）替换为x即可
 */

public class Solution {
    //四个方向的位置更新：顺时针更新
    int[][] position = {{1,0},{-1,0},{0,1},{0,-1}};
    public void solve(char[][] board) {
        if (board == null) {
            return;
        }

        //寻找边上的每一个0，如果没有，
        //表示所有的0都被包围
        int row = board.length;
        int col = board[0].length;

        //寻找第一列和最后一列
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                dfs(board, row, col, i, 0);
            }
            if (board[i][col - 1] == 'O') {
                dfs(board, row, col, i, col - 1);
            }
        }
        //寻找第一行和最后一行
        for (int i = 0; i < col; i++) {
            if (board[0][i] == 'O') {
                dfs(board, row, col, 0, i);
            }
            if (board[row - 1][i] == 'O') {
                dfs(board, row, col, row - 1, i);
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board, int row, int col, int curX, int curY) {
        //当前位置设为'A'
        board[curX][curY] = 'A';

        //向四个方向扩散
        for (int i = 0; i < 4; i++) {
            int newX = curX + position[i][0];
            int newY = curY + position[i][1];
            //判断边界
            if (newX < 0 || newX >= row || newY < 0 || newY >= col) {
                continue;
            }
            //是'O'说明和边联通，继续搜索是否还有联通的
            if (board[newX][newY] == 'O') {
                dfs(board, row, col, newX, newY);
            }
        }
    }
}
