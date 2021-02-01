package SmartBrowser;

import java.util.Scanner;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/10/25 12:08
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strings = s.split("v");
        int res = 0;
        for (String string : strings) {
            res += string.length() * 2 - 1;
        }
        System.out.println(res);
    }
}
