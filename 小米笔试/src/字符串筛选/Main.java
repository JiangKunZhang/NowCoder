package 字符串筛选;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/9/15 19:41
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine();
            Set<Character> set = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if (!set.contains(ch)) {
                    set.add(ch);
                    sb.append(ch);
                }
            }
            System.out.println(sb.toString());
        }
    }
}
