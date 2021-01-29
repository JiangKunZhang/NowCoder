package 统计;

import java.util.Scanner;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/10/17 19:34
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        int e = 0;
        int s = 0;;
        int k = 0;
        int q = 0;
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                e++;
            } else if (ch >= '0' && ch <= '9') {
                s++;
            } else if (ch == ' ') {
                k++;
            } else {
                q++;
            }
        }
        System.out.println("英文字母:" + e);
        System.out.println("空格:" + k);
        System.out.println("数字:" + s);
        System.out.println("其它字符:" + q);
    }
}
