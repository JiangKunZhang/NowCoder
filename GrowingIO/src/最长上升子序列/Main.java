package 最长上升子序列;

import java.util.Scanner;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/9/19 22:22
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strings = s.split(" ");
        int[] arr = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            arr[i] = Integer.parseInt(strings[i]);
        }
        int res = func(arr);
        System.out.println(res);
    }

    public static int func(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = 1;
        int max = dp[0];
        for (int i = 1; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j <= i - 1; j++) {
                if (arr[i] > arr[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }
}
