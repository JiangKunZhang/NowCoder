package 斐波那契数列;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/7/30 16:43
 */
public class Solution {
    public int Fibonacci1(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int[] F = new int[n + 1];
        F[0] = 0;
        F[1] = 1;
        for (int i = 2; i <= n; i++) {
            F[i] = F[i - 1] + F[i - 2];
        }
        return F[n];
    }
}
