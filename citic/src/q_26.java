import java.util.Scanner;

public class q_26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean res = func(n);
        if (res == true) {
            System.out.println(n + "是3的幂");
        } else {
            System.out.println(n + "不是3的幂");
        }
    }

    /**
     * 判断一个整数是不是3的幂
     * @param n 整数
     * @return 返回值
     */
    public static boolean func(int n) {
        if (n < 1) {
            return false;
        }
        while (n % 3 == 0) {
            n = n / 3;
        }
        return n == 1;
    }
}
