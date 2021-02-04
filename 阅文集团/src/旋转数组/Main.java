package 旋转数组;

import java.util.Scanner;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/10/21 19:26
 */
public class Main {
    //顺时针旋转数组
    public static int[][] RotateMatrix (int[][] matrix) {
        // write code here
        int n = matrix[0].length;
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
                res[x++][y] = matrix[startX][startY++];
            }
            startX = i;
            startY = mod - 1 + i;
            x = mod - 1 + i;
            y = mod - 1 + i;
            for (int j = 0; j < mod; j++) {
                res[x][y--] = matrix[startX++][startY];
            }
            startX = mod - 1 + i;
            startY = mod - 1 + i;
            x = mod - 1 + i;
            y = i;
            for (int j = 0; j < mod; j++) {
                res[x--][y] = matrix[startX][startY--];
            }
            startX = mod - 1 + i;
            startY = i;
            x = i;
            y = i;
            for (int j = 0; j < mod; j++) {
                res[x][y++] = matrix[startX--][startY];
            }
        }
        int middle = n / 2;
        if (n % 2 == 1) {
            res[middle][middle] = matrix[middle][middle];
        }
        return res;
    }

    public static void main(String[] args) {
        //int[][] map = {{0,1},{2,3}};
        //int[][] map = {{0,1,2},{3,4,5},{6,7,8}};
        //int[][] map = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            String[] strings = s.split(",");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(strings[j]);
            }
        }
        int[][] res = RotateMatrix(map);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res.length; j++) {
                if (i == 0 && j == 0) {
                    System.out.print(res[i][j]);
                } else {
                    System.out.print("," + res[i][j]);
                }
            }
        }
    }
}
