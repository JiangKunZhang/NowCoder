package BFS腐烂的橘子;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/10 13:36
 */
public class Solution {

    class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int orangesRotting(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int step = 0;
        int row = grid.length;
        int col = grid[0].length;
        //可以蔓延的方向
        int[][] position = {{1,0},{-1,0},{0,1},{0,-1}};
        //用Entry存放位置
        Queue<Pair> queue = new LinkedList<>();

        //已经腐烂的位置入队
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new Pair(i,j));
                }
            }
        }

        int flag = 0;
        while (!queue.isEmpty()) {
            flag = 0;
            int size = queue.size();
            //用当前这一批已经腐烂的橘子带出下一批要腐烂的橘子
            //故要遍历队列中的所有位置
            while (size-- != 0) {
                Pair pair = queue.poll();
                //当前位置向四个方向蔓延
                for (int i = 0; i < 4; i++) {
                    int newX = pair.x + position[i][0];
                    int newY = pair.y + position[i][1];
                    //如果位置越界,则跳过
                    if (newX >= row || newX < 0 || newY >= col || newY < 0) {
                        continue;
                    }
                    //如是新鲜的橘子，进行腐烂
                    if (grid[newX][newY] == 1) {
                        //标记有新的被腐烂
                        flag = 1;
                        grid[newX][newY] = 2;
                        queue.offer(new Pair(newX, newY));
                    }
                }
            }
            //如果有新的腐烂，才++
            if (flag == 1) {
                step++;
            }
        }
        //判断是否还有无法腐烂的
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return step;
    }
}
