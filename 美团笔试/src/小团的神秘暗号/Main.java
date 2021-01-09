package 小团的神秘暗号;

import java.util.Scanner;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/29 16:06
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        boolean headFlag = false;
        boolean tailFlag = false;
        int i;
        for (i = 0; i < n; i++) {
            if (s.charAt(i) == 'M') {
                headFlag = true;
            }
            if (s.charAt(i) == 'T' && (headFlag == true)) {
                break;
            }
        }
        int j;
        for (j = n - 1; j > 0 ; j--) {
            if (s.charAt(j) == 'T') {
                tailFlag = true;
            }
            if (s.charAt(j) == 'M' && (tailFlag == true)) {
                break;
            }
        }
        System.out.println(s.substring(i + 1, j));
    }
}

