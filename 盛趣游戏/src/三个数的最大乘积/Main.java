package 三个数的最大乘积;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/9/21 19:12
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strings = s.split(" ");
        int[] nums = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        int max = nums[0] * nums[1] * nums[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] * nums[j] * nums[k] > max) {
                        max = nums[i] * nums[j] * nums[k];
                    }
                }
            }
        }
        System.out.println(max);
    }
}
