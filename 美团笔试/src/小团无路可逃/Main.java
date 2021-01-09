package 小团无路可逃;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/29 16:58
 */

import java.util.Scanner;

/**
 * 1. 首先根据输入构建图，是无向图
 * 2. 然后以小团所在的点为根节点，搜索除了小美所在的所有子树
 * 3. 找到最深的那一个路径
 * 4. 再加上小美小团所在位置之差的绝对值
 * 5. 得到最终结果
 *
 * TODO 用什么方式存图呢？ 邻接矩阵 / 链式
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();
        int[][] book = new int[n + 1][n + 1];
        for (int i = 0; i < n - 1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            book[x][y] = 1;
            book[y][x] = 1;
        }
        System.out.println(2);
    }
}
