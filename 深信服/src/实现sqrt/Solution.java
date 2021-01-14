package 实现sqrt;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/10/11 19:17
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param num int整型
     * @return int整型
     */
    public int getSqrt (int num) {
        // write code here
        if (num == 1) {
            return 1;
        }
        double temp = num;
        double number = num;
        number = number / 2 + temp / (2 * number);
        while (number * number - temp > 0.000001) {
            number = number / 2 + temp / (2 * number);
        }
        return (int)number;
    }
}
