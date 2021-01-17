package 发苹果;

import java.util.Scanner;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/9/21 19:23
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strings = s.split(" ");
        int[] nums = new int[strings.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        int count = 0;
        boolean[] book = new boolean[nums.length];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                if (nums[i] > nums[i - 1]) {
                    book[i] = true;
                } else {
                    book[i - 1] = true;
                }
//                if (book[i] == false)
//                    count++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (book[i] == true) {
                count++;
            }
        }
        System.out.println(nums.length + count);
    }
}
