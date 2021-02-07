package 求指定范围内素数和;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/10/17 16:21
 */
class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * primeSum函数返回素数和
     * @param n int整型 n为正整数，且n>1
     * @param m int整型 m为正整数，且m>n
     * @return int整型
     */
    public static  int primeSum (int n, int m) {
        // write code here
        int res = 0;
        for (int i = n; i <= m; i++) {
            if (isPrime(i)) {
                res += i;
            }
        }
        return res;
    }

    public static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int res = primeSum(10,20);
        System.out.println(res);
    }
}
