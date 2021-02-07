package 实现进制转换;

import java.util.Scanner;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/9/10 19:11
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        long res = 0;
        int index = 0;
        boolean flag = false;
        boolean check = false;
        if (input.charAt(0) == '-') {
            flag = true;
            input = input.substring(1, input.length());
        }
        for (int i = input.length() - 1; i >= 0; i--) {
            int temp = 0;
            char ch = input.charAt(i);
            if (!((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z'))) {
                check = true;
                break;
            }
            if (ch >= '0' && ch <= '9') {
                temp = ch - '0';
            } else {
                temp = ch - 'a' + 10;
            }
            res += temp * Math.pow(36, index);
            index++;
        }
        if (check == false) {
            if (flag == true) {
                System.out.println(res * -1);
            } else {
                System.out.println(res);
            }
        } else {
            System.out.println(0);
        }
    }
}
