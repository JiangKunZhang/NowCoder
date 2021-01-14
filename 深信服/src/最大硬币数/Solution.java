package 最大硬币数;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/10/11 19:34
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param piles int整型一维数组
     * @return int整型
     */
    public int maxCoins (int[] piles) {
        // write code here
        Integer[] array = new Integer[piles.length];
        for (int i = 0; i < piles.length; i++) {
            array[i] = piles[i];
        }
        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int i = 1;
        int sum = 0;
        int n = piles.length / 3;
        for (int j = 0; j < n; j++) {
            //每次就拿第二大
            sum += array[i];
            i += 2;
        }
        return sum;
    }
}