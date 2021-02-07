package 打印二叉树;

import java.util.Scanner;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/9/10 19:29
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] res = new int[16];
        res[0] = 0;
        res[1] = 1;
        res[2] = 2;
        for (int i = 3; i <= n; i++) {
            int temp = 0;
            for (int j = 1; j <= i; j++) {
                int left = j - 1;
                int right = i - j;
                if ((left == 1) && (right == 1)) {
                    temp += 1;
                } else {
                    if (res[left] == 0 || res[right] == 0) {
                        temp += res[left] + res[right];
                    } else {
                        temp += res[left] * res[right];
                    }
                }
            }
            res[i] = temp;
        }
        System.out.println(res[n]);
    }
}
