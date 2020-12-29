package 编程题3;

import java.util.Scanner;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/16 19:46
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.next();
        int k = sc.nextInt();
        if (k >= string.length()) {
            System.out.println(0);
            return;
        }
        for (int i = 0; i < k; i++) {
            StringBuilder sb = new StringBuilder(string);
            boolean flag = false;
            for (int j = 0; j < sb.length() - 1; j++) {
                if ((sb.charAt(j + 1) - '0') < (sb.charAt(j) - '0')) {
                    flag = true;
                    sb.setCharAt(j, '-');
                    string = sb.toString().replaceFirst("-", "");
                    break;
                }
            }
            if (flag == false) {
                string = string.substring(0, string.length() - 1);
            }
        }
        StringBuilder stringBuilder = new StringBuilder(string);
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (string.charAt(i) == '0') {
                stringBuilder.setCharAt(i, '-');
            } else {
                break;
            }
        }
        string = stringBuilder.toString().replaceAll("-", "");
        if (string.length() == 0) {
            System.out.println(0);
        } else {
            System.out.println(string);
        }
    }
}
