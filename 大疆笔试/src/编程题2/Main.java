package 编程题2;

import java.util.Scanner;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/16 19:34
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] A = new int[n];
        int[] V = new int[n];
        for (int i = 0; i < n; i++) {
            V[i] = sc.nextInt();
            A[i] = sc.nextInt();
        }
        int[][] maxValue = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            maxValue[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            maxValue[0][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A[i - 1] <= j) {
                    maxValue[i][j] = Math.max(maxValue[i - 1][j - A[i - 1]]  + V[i - 1], maxValue[i - 1][j]);
                } else {
                    maxValue[i][j] = maxValue[i - 1][j];
                }
            }
        }
        System.out.println(maxValue[n][m]);
    }
}
