package 数组内数据平移;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/9/15 15:42
 */
public class Solution {
    /**
     * 数组内数据循环平移
     * @param arr int整型一维数组 输入数组
     * @param pushOffset int整型 位移长度
     * @return int整型一维数组
     */
    public int[] pushIntArray (int[] arr, int pushOffset) {
        // write code here
        int count = pushOffset % arr.length;
        int[] res = new int[arr.length];
        int index = 0;
        for (int i = count; i < arr.length; i++) {
            res[i] = arr[index++];
        }
        for (int i = 0; i < count; i++) {
            res[i] = arr[index++];
        }
        return res;
    }
}
