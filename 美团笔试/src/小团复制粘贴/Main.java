package 小团复制粘贴;

import java.util.Scanner;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/29 16:48
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n + 1];
        int[] B = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            A[i] = sc.nextInt();
            B[i] = -1;
        }
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int flag = sc.nextInt();
            if (flag == 1) {
                int k = sc.nextInt();
                int x = sc.nextInt();
                int y = sc.nextInt();
                for (int j = 0; j < k; j++) {
                    B[y++] = A[x++];
                }
            }
            if (flag == 2) {
                int index = sc.nextInt();
                System.out.println(B[index]);
            }
        }
    }
}
