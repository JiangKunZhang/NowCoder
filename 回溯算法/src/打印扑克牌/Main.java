package 打印扑克牌;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/4 23:03
 */
public class Main {
    public static void main(String[] args) {
        int[] book = new int[4];
        int[] box = new int[4];
        dfs(1, 3, box, book);
    }

    public static void dfs(int index, int n, int[] box, int[] book) {
        if (index == n + 1) {
            for (int i = 1; i <= n; i++) {
                System.out.print(box[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (book[i] == 0) {//第i号牌仍在手上
                box[index] = i;
                book[i] = 1;//现在第i号牌已经被用了
                dfs(index + 1, n, box, book);//处理下一个盒子
                book[i] = 0;//从下一个盒子回退到当前盒子，取出当前盒子的牌，尝试放入其它牌
            }
        }
    }
}
