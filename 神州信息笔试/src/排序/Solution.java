package 排序;

import java.util.LinkedList;
import java.util.List;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/9/15 15:24
 */
public class Solution {
    /**
     *
     * @param inData string字符串 请求参数
     * @return int整型
     */
    public static int sort (String inData) {
        // write code here
        String[] strings = inData.split(" ");
        int[] nums = new int[strings.length];
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < strings.length; i++) {
            list.add(Integer.parseInt(strings[i]));
        }
        int len = list.size();
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (check(list)) {
                removeMin(list);
                res++;
            }
        }
        return res;
    }

    public static void removeMin(List<Integer> list) {
        int minIndex = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(minIndex)) {
                minIndex = i;
            }
        }
        list.remove(minIndex);
    }

    public static boolean check(List<Integer> list) {
        int minIndex = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(minIndex)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int res = sort("100 122 55 300");
        System.out.println(res);
    }
}
