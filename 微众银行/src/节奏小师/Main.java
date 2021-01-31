package 节奏小师;

import java.util.Scanner;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/10/15 20:52
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int res = 0;
        int p = 0;
        int g = 0;
        int m = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'P') {
                p++;
                if (p <= 3) {
                    res += 200;
                } else {
                    res += 250;
                }
                continue;
            } else if (ch == 'G') {
                g++;
                p = 0;
                res += 100;
            } else if (ch == 'M') {
                m++;
                p = 0;
            }
        }
        if (m >= 3) {
            System.out.println(0);
        } else {
            System.out.println(res);
        }
    }
}
