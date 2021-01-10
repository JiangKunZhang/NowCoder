package 计算当前星期;

import java.util.Calendar;
import java.util.Scanner;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/10/17 21:23
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y1 = sc.nextInt();
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int w = sc.nextInt();
        int y2 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        Calendar date1 = Calendar.getInstance();
        date1.set(y1, m1, d1);
        long mis1 = (long)date1.getTime().getTime();

        Calendar date2 = Calendar.getInstance();
        date2.set(y2, m2, d2);
        long mis2 = (long)date2.getTime().getTime();

        int days = 0;
        if (mis1 > mis2) {
            days = (int) ((mis1 - mis2) / 1000 / 60 / 60 / 24);
        } else {
            days = (int) ((mis2 - mis1) / 1000 / 60 / 60 / 24);
        }
        int res = (days + w) % 7;
        if (res == 0) {
            System.out.println(7);
        } else {
            System.out.println(res);
        }
    }
}
