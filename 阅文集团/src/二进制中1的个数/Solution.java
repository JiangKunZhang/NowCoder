package 二进制中1的个数;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/10/21 19:08
 */
public class Solution {
    /**
     * 计算int对应二进制中1的个数
     * @param n int整型 数字
     * @return int整型
     */
    public int countBit (int n) {
        // write code here
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}