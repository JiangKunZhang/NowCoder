package 输出快速排序第N趟排序结果;

import java.util.*;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/10/17 16:58
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 快速排序第n趟结果
     * @param array int整型一维数组 待排序数组，数组大小大于0小于100
     * @param n int整型 趟数
     * @return int整型一维数组
     */
    static int count = 1;
    static List<int[]> list = new ArrayList<>();
    static Queue<Integer> queue = new LinkedList<>();
    public static int[] nthResultOfQuickSort (int[] array, int n) {
        // write code here
        quickSort(array, n);
        return list.get(0);
    }

    public static void quickSort(int[] array, int n) {
        quick(array, 0, array.length - 1, n);
    }

    public static void quick(int[] array, int left, int right, int n) {

        if (left >= right) {
            return;
        }

        int par = partition(array, left, right);
        queue.add(left);
        queue.add(right);
        while (count <= n) {
            int s = queue.size();
            for (int i = 0; i < s; i++) {
                int l = queue.poll();
                int r = queue.poll();
                int m = partition(array, l, r);
                queue.add(l);
                queue.add(m - 1);
                queue.add(m + 1);
                queue.add(r);
            }
            count++;
        }
        list.add(Arrays.copyOf(array, array.length));
    }

    public static int partition(int[] array, int left, int right) {
        int temp = array[left];
        while (left < right) {
            while (left < right && array[right] >= temp) {
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] <= temp) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = temp;
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {42,35,63,96,56,11,17,42,88};
        int[] res = nthResultOfQuickSort(arr, 3);
        System.out.println(Arrays.toString(res));
        }
}
