package Test;

import java.util.Arrays;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/10/14 19:11
 */
public class Main {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        int len = array.length;
        int k = 3;
        int count = k % len;
        int[] res = new int[array.length];
        int rear = len - count;
        int index = 0;
        for (int i = rear; i < len; i++) {
            res[index++] = array[i];
        }
        for (int i = 0; i < rear; i++) {
            res[index++] = array[i];
        }
        System.out.println(Arrays.toString(res));
    }
}
