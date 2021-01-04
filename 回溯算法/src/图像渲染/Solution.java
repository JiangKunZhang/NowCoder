package 图像渲染;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/4 23:30
 */

/**
 * 把和初始坐标开始，颜色值相同的点的颜色全部改为新的颜色
 * 并且只要某个点颜色被更改，则继续以此点向周围渲染
 */
public class Solution {
    //四个方向的位置更新
    public int[][] nextPosition = {{1,0},{-1,0},{0,1},{0,-1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        int row = image.length;
        int col = image[0].length;
        //建立标记
        int[][] book = new int[row][col];
        dfs(image, book, row, col, sr, sc, newColor, oldColor);
        return image;
    }

    public void dfs(int[][] image, int[][] book, int row, int col, int sr, int sc, int newColor, int oldColor) {
        //处理当前逻辑，修改颜色，并且标记已经修改过了
        image[sr][sc] = newColor;
        book[sr][sc] = 1;

        //遍历每一种可能，四个方向
        for (int i = 0; i < 4; i++) {
            int newSr = sr + nextPosition[i][0];
            int newSc = sc + nextPosition[i][1];
            //判断新位置是否越界
            if (newSr < 0 || newSr >= row || newSc < 0 || newSc >= col) {
                continue;
            }
            //如果颜色符合要求，并且之前也没有渲染过，则继续渲染
            if (image[newSr][newSc] == oldColor && book[newSr][newSc] == 0) {
                dfs(image, book, row, col, newSr, newSc, newColor, oldColor);
            }
        }
    }
}
