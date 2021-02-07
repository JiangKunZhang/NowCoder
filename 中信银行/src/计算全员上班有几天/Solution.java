package 计算全员上班有几天;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/10/17 16:28
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 获取全体员工全员上班的天数
     * @param workDays string字符串一维数组 每个员工的上班日期，0代表休息1代表上班，数组大小大于0小于10000
     * @return int整型
     */
    public static int countDays (String[] workDays) {
        // write code here
        int res = 0;
        for (int i = 0; i < workDays[0].length(); i++) {
            boolean flag = true;
            for (int j = 0; j < workDays.length; j++) {
                String s = workDays[j];
                char ch = s.charAt(i);
                if (ch == '0') {
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] s = {"111101110111011101110111011010", "111101110111011101110111011010", "111101110111010101010111011010", "111101110101011101110111111010", "111101110111011101110111011110", "111101010111011101110111010111", "101101110111011101110111011110", "010101110111011101110101011110"};
        System.out.println(countDays(s));
    }
}
