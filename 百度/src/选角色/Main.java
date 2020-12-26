package 选角色;

import java.util.*;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/9/14 19:39
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] people = new int[n];
            int[] val = new int[m];
            int[] res = new int[n];
            for (int j = 0; j < n; j++) {
                people[j] = sc.nextInt();
            }
            for (int j = 0; j < m; j++) {
                val[j] = sc.nextInt();
                for (int k = 0; k < n; k++) {
                    if (val[j] >= people[k]) {
                        res[k] += 1;
                    }
                }
            }
            for (int j = 0; j < n; j++) {
                System.out.print(res[j] + " ");
            }
        }
    }
}
