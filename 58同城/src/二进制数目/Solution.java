package 二进制数目;

import java.util.Arrays;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/9/21 20:20
 */
public class Solution {
    /**
     *
     * @param num int整型 非负整数 num
     * @return int整型一维数组
     */
    public static int[] countBits (int num) {
        // write code here
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int count = 0;
            int temp = i;
            while (temp != 0) {
                temp = temp & temp - 1;
                count++;
            }
            res[i] = count;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = countBits(5);
        System.out.println(Arrays.toString(res));
    }
}
