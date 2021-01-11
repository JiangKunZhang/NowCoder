package 最大干净矩形的面积;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/9/12 11:10
 */
public class Solution {
    /**
     * 获得剩余区域内的最大干净矩形面积
     * @param x1 int整型
     * @param y1 int整型
     * @param x2 int整型
     * @param y2 int整型
     * @param x3 int整型
     * @param y3 int整型
     * @param x4 int整型
     * @param y4 int整型
     * @return int整型
     */
    public static int getMaxArea (int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        // write code here
        int[][] map = new int[11][11];
        int y1Min = y1 < y2 ? y1 : y2;
        int y1Max = y1 > y2 ? y1 : y2;
        int x1Min = x1 < x2 ? x1 : x2;
        int x1Max = x1 > x2 ? x1 : x2;
        int y2Min = y3 < y4 ? y3 : y4;
        int y2Max = y3 > y4 ? y3 : y4;
        int x2Min = x3 < x4 ? x3 : x4;
        int x2Max = x3 > x4 ? x3 : x4;
        for (int i = y1Min; i <= y1Max; i++) {
            for (int j = x1Min; j <= x1Max; j++) {
                map[i][j] = 1;
            }
        }
        for (int i = y2Min; i <= y2Max; i++) {
            for (int j = x2Min; j <= x2Max; j++) {
                map[i][j] = 1;
            }
        }
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (i == 0 || i == 10 || j == 0 || j == 10) {
                    if (map[i][j] == 0) {
                        dfs(map, i, j);
                    }
                }
            }
        }

        return 0;
    }

    public static int dfs(int[][] map, int i, int j) {

        return 0;
    }

    public static void main(String[] args) {
        getMaxArea(0,0,1,1,9,9,10,10);
    }
}