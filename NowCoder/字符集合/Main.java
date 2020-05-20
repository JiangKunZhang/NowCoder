package 字符集合;

import java.util.Scanner;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/10 21:48
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String string = scanner.nextLine();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < string.length(); i++) {
                //StringBuffer没有contains方法，先把SB转成String
                String temp = sb.toString();
                //contains方法参数是CharSequence，char加上"" 一个空的字符串就可以了
                if (!temp.contains(string.charAt(i)+"")) {
                    sb.append(string.charAt(i));
                }
            }
            System.out.println(sb);
        }
    }
}
