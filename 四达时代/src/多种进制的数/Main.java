package 多种进制的数;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/9/19 20:03
 */
public class Main {
    public static void main(String[] args) {
        Map<Integer, Character> map = new HashMap<>();
        map.put(10,'A');
        map.put(11,'B');
        map.put(12,'C');
        map.put(13,'D');
        map.put(14,'E');
        map.put(15,'F');
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            int temp = sc.nextInt();
            if (arr[i] >= 10) {
                i++;
            }
            arr[i] = temp;
        }
        for (int i = 1; i < 16; i++) {
            if (i < arr[len - 1]) {
                if (i < 10) {
                    System.out.println(i);
                } else {
                    System.out.println(map.get(i));
                }
            }
        }
        for (int i = 10; i <= Math.pow(10, len) - 1; i++) {
            String num = String.valueOf(i);
            StringBuilder sb = new StringBuilder();
            boolean flag = false;
            for (int j = num.length() - 1; j >= 0; j--) {
                char ch = num.charAt(j);
                int temp = ch - '0';
                if (arr[j] < 10) {
                    if (temp < arr[j]) {
                        sb.append(temp);
                    } else {
                        flag = true;
                        break;
                    }
                } else {
                    char ch1;
                    String s;
                    if (j - 1 >= 0) {
                        ch1 = num.charAt(j - 1);
                        char ch2 = num.charAt(j);
                        s = ch1 + "" + ch2 + "";
                    } else {
                        char ch2 = num.charAt(j);
                        s = ch2 + "";
                    }
                    int tmp = Integer.parseInt(s);
                    if (tmp < arr[j]) {
                        if (tmp < 10) {
                            sb.append(temp);
                        } else {
                            sb.append(map.get(tmp));
                        }
                    } else {
                        flag = true;
                        break;
                    }
                }
            }
            if (!flag) {
                System.out.println(sb.reverse().toString());
            }
        }
    }
}
