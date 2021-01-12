package 刚哥的直播;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/9/23 19:20
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            BigInteger temp = new BigInteger(String.valueOf(m));
            for (int i = m - 1; i >= (m - n + 1); i--) {
                BigInteger ii = new BigInteger(String.valueOf(i));
                temp = temp.multiply(ii);
            }
            BigInteger tmp = new BigInteger(String.valueOf(1));
            for (int i = 1; i <= n; i++) {
                BigInteger ii = new BigInteger(String.valueOf(i));
                tmp = tmp.multiply(ii);
                //System.out.println(tmp);
            }
            System.out.println(temp.divide(tmp).toString());
        }
    }
}
