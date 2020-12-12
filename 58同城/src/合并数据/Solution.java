package 合并数据;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/9/21 21:17
 */
public class Solution {
    /**
     * 合并数组
     * @param arrayA int整型ArrayList 数组A
     * @param arrayB int整型ArrayList 数组B
     * @return int整型ArrayList
     */
    public ArrayList<Integer> mergerArrays (ArrayList<Integer> arrayA, ArrayList<Integer> arrayB) {
        // write code here
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arrayA.size(); i++) {
            set.add(arrayA.get(i));
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < arrayB.size(); i++) {
            if (set.contains(arrayB.get(i))) {
                res.add(arrayB.get(i));
            }
        }
        return res;
    }
}
