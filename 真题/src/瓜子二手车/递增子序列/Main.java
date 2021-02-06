package 瓜子二手车.递增子序列;

import java.util.Scanner;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/7 12:05
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        int first = array[0];
        int second = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            if (first > array[i]) {
                first = array[i];
                second = Integer.MAX_VALUE;
            } else if (first < array[i] && array[i] < second) {
                second = array[i];
            } else if (first < array[i] && second < array[i]) {
                System.out.println(true);
                return;
            }
        }
        System.out.println(false);
    }
}
