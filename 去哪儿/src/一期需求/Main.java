package 一期需求;

import java.util.Scanner;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/9/23 20:43
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder a = new StringBuilder();
        for (int i = 0; i < n; i++) {
            a.append(sc.next());
        }
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < n; i++) {
            b.append(sc.next());
        }
        String aa = a.toString();
        String bb = b.toString();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (aa.charAt(i) == bb.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1],dp[i + 1][j]);
                }
            }
        }
        System.out.println(dp[n][n]);
    }
}