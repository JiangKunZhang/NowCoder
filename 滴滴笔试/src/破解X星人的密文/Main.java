package 破解X星人的密文;

import java.awt.*;
import java.util.Scanner;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/9/13 19:41
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        sc.nextLine();
        String input = sc.nextLine();
        int last = input.length() % x;
        int i = 0;
        StringBuilder res = new StringBuilder();
        while (i < input.length()) {
            StringBuilder sb = new StringBuilder();
            int j = 0;
            while (j < x && (i + j) < input.length()) {
                sb.append(input.charAt(i + j));
                j++;
            }
            res.append(sb.reverse());
            i += x;
        }
        System.out.println(res.toString());
    }
}
