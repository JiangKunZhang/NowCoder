package 陷阱迷宫;

import java.util.Scanner;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/9/13 21:02
 */
public class Main {
    static int res = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        char[][] map = new char[n][n];
        boolean[][] book = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        dfs(map, 0, 0, book, k);
        System.out.println(res - 1);
    }

    public static void dfs(char[][] map, int x, int y, boolean[][] book, int k) {
        int[][] position = {{1,0},{-1,0},{0,1},{0,-1}};
        res += 1;
        if (map[x][y] == '#') {
            res += k;
        }
        if (x == map.length - 1 && y == map.length - 1) {
            return;
        }
        book[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + position[i][0];
            int newY = y + position[i][1];
            if (newX < 0 || newX >= map.length || newY < 0 || newY >= map.length) {
                continue;
            }
            if (!book[newX][newY]) {
                if (map[newX][newY] == '0') {
                    dfs(map, newX, newY, book, k);
                }
            }
        }
        book[x][y] = false;
    }
}
