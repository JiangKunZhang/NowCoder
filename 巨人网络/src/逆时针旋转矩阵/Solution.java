package 逆时针旋转矩阵;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/9/14 16:23
 */
public class Solution {
    /**
     * 逆时针旋转矩阵
     * @param matrix int整型二维数组 输入矩阵
     * @return int整型二维数组
     */
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
            int x = mod - 1 + i;
            int y = i;
            for (int j = 0; j < mod; j++) {
                res[x--][y] = matrix[startX][startY++];
            }
            startX = i;
            startY = mod - 1 + i;
            x = i;
            y = i;
            for (int j = 0; j < mod; j++) {
                res[x][y++] = matrix[startX++][startY];
            }
            startX = mod - 1 + i;
            startY = mod - 1 + i;
            x = i;
            y = mod - 1 + i;
            for (int j = 0; j < mod; j++) {
                res[x++][y] = matrix[startX][startY--];
            }
            startX = mod - 1 + i;
            startY = i;
            x = mod - 1 + i;
            y = mod - 1 + i;
            for (int j = 0; j < mod; j++) {
                res[x][y--] = matrix[startX--][startY];
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
        int[][] map = {{0,1,2,3},{4,5,6,7},{8,9,10,11},{12,13,14,15}};
        //int[][] map = {{0,1,2},{3,4,5},{6,7,8}};
        int[][] res = RotateMatrix(map);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res.length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
