package 钱币找零;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/4 16:16
 */

/**
 * 钱币找零
 *
 * 假设1元、2元、5元、10元、20元、50元、100元的纸币分别有c0, c1, c2, c3, c4, c5, c6张。现在要用这些钱来支付K
 * 元，至少要用多少张纸币？
 *
 * 贪心策略:
 * 用贪心算法的思想，很显然，每一步尽可能用面值大的纸币即可。在日常生活中我们自然而然也是这么做的。在程序中已
 * 经事先将Value按照从小到大的顺序排好。
 */
public class Main {
    public static void main(String[] args) {
        int[][] moneyCount = {{100,1},{50,2},{20,3},{1,5},{5,1},{10,2}};
        int money = 135;
        int count = getCount(moneyCount, money);
        System.out.println(count);
    }

    private static int getCount(int[][] moneyCount, int money) {
        Arrays.sort(moneyCount, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        int count = 0;
        //首先选择最大面值的纸币
        for (int i = 0; i < moneyCount.length; i++) {
            //需要的当前面值与面值数量取最小，有可能100面值没那么多，也有可能面值太多了
            int cnt = Math.min(money / moneyCount[i][0], moneyCount[i][1]);
            count += cnt;
            money -= cnt * moneyCount[i][0];
        }
        return count;
    }
}
