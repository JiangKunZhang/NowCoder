package 提取年份;

import java.util.*;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/9/17 19:41
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> res = new LinkedList<>();
        String s = sc.nextLine();
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                int num = ch - '0';
                temp = temp * 10 + num;
            } else {
                if (temp >= 1000 && temp <= 3999) {
                    res.add(temp);
                }
                temp = 0;
            }
        }
        if (res.size() > 0) {
            System.out.print(res.get(0));
            for (int i = 1; i < res.size(); i++) {
                System.out.print(" " + res.get(i));
            }
        }
    }
}
