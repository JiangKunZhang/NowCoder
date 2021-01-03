package 北京天坛;

import java.util.Scanner;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/9/13 20:50
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        long j = 0;
        for (int i = 1; i <= 3 * n; i++) {
            j += i;
        }
        System.out.println(m * j);
    }
}
