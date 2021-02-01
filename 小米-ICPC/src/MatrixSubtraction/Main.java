package MatrixSubtraction;

import java.util.Scanner;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/10/25 12:35
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int[][] matrix = new int[n][m];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    matrix[j][k] = sc.nextInt();
                }
            }
            for (int j = 0; j < n - a + 1; j++) {
                for (int k = 0; k < m - b + 1; k++) {
                    int sx = j;
                    int sy = k;
                    int ex = j + a - 1;
                    int ey = k + b - 1;
                    getMin(matrix, sx, sy, ex, ey);

                }
            }

            boolean flag = true;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (matrix[i][j] != 0) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag == false) {
                System.out.println("QAQ");
            } else {
                System.out.println("^_^");
            }
        }
    }

    public static int getMin(int[][] map, int sx, int sy, int ex, int ey) {
        int min = Integer.MAX_VALUE;
        for (int i = sx; i <= ex; i++) {
            for (int j = sy; j < ey; j++) {
                if (map[i][j] < min) {
                    min = map[i][j];
                }
            }
        }

        for (int i = sx; i <= ex; i++) {
            for (int j = sy; j < ey; j++) {
                map[i][j] -= min;
            }
        }

        return min;
    }
}
