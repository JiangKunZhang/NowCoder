import java.util.Arrays;

public class q_27 {
    public static void main(String[] args) {
        int[] array = {9,8,7,6,5,4,3,2,1};
        bubbleSort(array, array.length);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 冒泡排序
     * @param array 数组
     * @param len 数组长度
     */
    private static void bubbleSort(int[] array, int len) {
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
