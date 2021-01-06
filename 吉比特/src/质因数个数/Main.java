package 质因数个数;

import java.util.Scanner;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/9/25 21:24
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = 0;
        while (true) {
            boolean flag = false;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    num++;
                    n /= i;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                num++;
                break;
            }
        }
        System.out.println(num);
    }
}
