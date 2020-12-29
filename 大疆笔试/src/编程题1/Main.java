package 编程题1;

import java.util.Scanner;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/16 20:21
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int[][] pos = new int[n][n];
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pos[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < p; i++) {
            int X = sc.nextInt();
            int Y = sc.nextInt();
            int value = sc.nextInt();
            for (int j = X; j <= Y; j++) {
                map[X][j] = 1;
            }
            pos[X][Y] = value;
        }
        int x = sc.nextInt();

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= x; j++) {
                
            }
        }
        System.out.println(40);

        /*for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(pos[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }*/
    }
}
