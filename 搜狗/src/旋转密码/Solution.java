package 旋转密码;

import com.sun.org.apache.xalan.internal.xsltc.dom.SimpleResultTreeImpl;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/9/25 19:36
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回一行字符串，表示原文。
     * @param s1 string字符串一维数组 N*N的01矩阵，表示解密纸，0表示透明，1表示涂黑
     * @param s2 string字符串一维数组 字符矩阵，表示密文
     * @return string字符串
     */
    public static String rotatePassword (String[] s1, String[] s2) {
        // write code here
        int[][] map = new int[s1.length][s1.length];
        for (int i = 0; i < s1.length; i++) {
            String s = s1[i];
            for (int j = 0; j < s.length(); j++) {
                int temp = s.charAt(j) - '0';
                map[i][j] = temp;
            }
        }
        String temp1 = getRes(map, s2);
        for (int i = 0; i < 3; i++) {
            int[][] temp = func(map);
            temp1 += getRes(temp, s2);
            map = temp;
        }
        return temp1;
    }

    public static String getRes(int[][] map, String[] s2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < map.length; i++) {
            String t = s2[i];
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == 0) {
                    sb.append(t.charAt(j));
                }
            }
        }
        return sb.toString();
    }

    public static int[][] func(int[][] map) {
        int n = map[0].length;
        int[][] res = new int[n][n];
        int count = n / 2;
        //找出圈数
        for (int i = 0; i < count; i++) {
            //处理一圈
            int mod = (n - i * 2);
            int startX = i;
            int startY = i;
            int x = i;
            int y = mod - 1 + i;
            for (int j = 0; j < mod; j++) {
                res[x++][y] = map[startX][startY++];
            }
            startX = i;
            startY = mod - 1 + i;
            x = mod - 1 + i;
            y = mod - 1 + i;
            for (int j = 0; j < mod; j++) {
                res[x][y--] = map[startX++][startY];
            }
            startX = mod - 1 + i;
            startY = mod - 1 + i;
            x = mod - 1 + i;
            y = i;
            for (int j = 0; j < mod; j++) {
                res[x--][y] = map[startX][startY--];
            }
            startX = mod - 1 + i;
            startY = i;
            x = i;
            y = i;
            for (int j = 0; j < mod; j++) {
                res[x][y++] = map[startX--][startY];
            }
        }
        int middle = n / 2;
        if (n % 2 == 1) {
            res[middle][middle] = map[middle][middle];
        }
        return res;
    }

    public static void main(String[] args) {
/*
["1101","1010","1111","1110"],["ABCD","EFGH","IJKL","MNPQ"]
 */
        String[] s1 = {"1101","1010","1111","1110"};
        String[] s2 = {"ABCD","EFGH","IJKL","MNPQ"};
        System.out.println(rotatePassword(s1, s2));
    }
}
