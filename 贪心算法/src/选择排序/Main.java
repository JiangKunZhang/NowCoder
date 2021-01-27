package 选择排序;

import java.util.Arrays;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/4 15:42
 */
public class Main {

    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void selectSort(int[] array, int n) {
        for (int i = 0; i <= n; i++) {
            int minIndex = i;
            for (int j = i; j <= n; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
        }
    }

    public static void main(String[] args) {
        int[] array = {9,8,7,6,5,4,3,2,1};
        selectSort(array, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
