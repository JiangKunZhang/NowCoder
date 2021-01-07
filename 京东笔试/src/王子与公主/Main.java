package 王子与公主;

import java.util.Scanner;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/9/17 20:10
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            String[][] map = new String[n][m];
            int sx = 0;
            int sy = 0;
            for (int j = 0; j < n; j++) {
                String s = sc.next();
                char[] c = s.toCharArray();
                for (int k = 0; k < c.length; k++) {
                    String temp = c[k] + "";
                    map[j][k] = temp;
                    if (temp.equals("S")) {
                        sx = j;
                        sy = k;
                    }
                }
            }
            boolean res = false;
            res = dfs(map, n, m, sx, sy);
            if (res) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean dfs(String[][] map, int n, int m, int sx, int sy) {
        if (sx < 0 || sx >= n || sy < 0 || sy >= m || map[sx][sy].equals("#")) {
            return false;
        }
        if (map[sx][sy].equals("E")) {
            return true;
        }
        return dfs(map, n, m, sx + 1, sy) || dfs(map, n, m, sx, sy + 1) || dfs(map, n, m, sx - 1, sy) || dfs(map, n, m, sx, sy - 1);
    }
}
