package 连续段个数;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/9/8 19:07
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BigInteger bigInteger1 = new BigInteger(Integer.toString(n));
        BigInteger bigInteger2 = new BigInteger(Integer.toString(n - 1));
        System.out.println(bigInteger1.multiply(bigInteger2).add(new BigInteger(Integer.toString(1))));
    }
}
