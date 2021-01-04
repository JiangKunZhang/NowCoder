package 广度优先搜索;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/10 12:34
 *
 * 迷宫问题
 */
public class Solution {
     static class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static boolean BFS(int[][] mat, int startX, int startY, int endX, int endY) {
        int row = mat.length;
        int col = mat[0].length;

        int[][] position = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int[][] book = new int[row][col];
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(startX, startY));
        book[startX][startY] = 1;

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            if (pair.x == endX && pair.y == endY) {
                return true;
            }
            for (int i = 0; i < 4; i++) {
                int newX = pair.x + position[i][0];
                int newY = pair.y + position[i][1];
                if (newX >= row || newX < 0 || newY >= col || newY < 0) {
                    continue;
                }
                if (mat[newX][newY] == 0 && book[newX][newY] == 0) {
                    queue.offer(new Pair(newX, newY));
                    book[newX][newY] = 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] mat = {{0,0,1,0},{1,0,0,1},{0,0,0,0},{1,1,0,0}};
        Scanner sc = new Scanner(System.in);
        int sx = sc.nextInt();
        int sy = sc.nextInt();
        int ex = sc.nextInt();
        int ey = sc.nextInt();
        boolean res = BFS(mat, sx, sy, ex, ey);
        System.out.println(res);
    }
}
