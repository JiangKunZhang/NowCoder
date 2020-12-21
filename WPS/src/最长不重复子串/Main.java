package 最长不重复子串;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/9/29 19:30
 */
public class Main {
    public static void main(String[] args) {
        int[] array = {6,5,4,3,2,1};
        quick(array);
        System.out.println(Arrays.toString(array));
    }

    public static void quick(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int[] array, int start, int end) {
        if (start > end) return;
        int par = partition(array, start, end);
        quickSort(array, start, par - 1);
        quickSort(array, par + 1, end);
    }

    public static int partition(int[] array, int start, int end) {
        int temp = array[start];
        while (start < end) {
            while (start < end && array[end] >= temp) {
                end--;
            }
            array[start] = array[end];
            while (start < end && array[start] <= temp) {
                start++;
            }
            array[end] = array[start];
        }
        array[start] = temp;
        return start;
    }
}
