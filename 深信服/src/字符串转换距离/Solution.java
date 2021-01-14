package 字符串转换距离;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/10/11 19:20
 */

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param a string字符串 字符串1
     * @param b string字符串 字符串2
     * @return int整型
     */
    public int minDistance (String a, String b) {
        // write code here
        int row = a.length();
        int col = b.length();
        int[][] minDis = new int[row + 1][col + 1];
        //初始化
        for (int i = 0; i <= row; i++) {
            minDis[i][0] = i;
        }
        for (int i = 1; i <= col; i++) {
            minDis[0][i] = i;
        }

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                minDis[i][j] = Math.min(minDis[i - 1][j], minDis[i][j - 1]) + 1;
                //判断a的第i个字符和b的第j个字符是不是相等
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    //相等了就和插入删除选择一个小的
                    minDis[i][j] = Math.min(minDis[i][j], minDis[i - 1][j - 1]);
                } else {
                    //不相等就需要一次替换
                    minDis[i][j] = Math.min(minDis[i][j], minDis[i - 1][j - 1] + 1);
                }
            }
        }
        return minDis[row][col];
    }
}