package 组合总和;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/5 17:27
 */

/**
 * 此题相加的元素可以重复，所以去下一个元素的位置可以从当前位置开始， DFS + 回溯
 * 为了保证组合不重复(顺序不同，元素相同，也算重复)，不再从当前位置向前看
 * 1. 从第一个元素开始相加
 * 2. 让局部和继续累加候选的剩余值
 * 3. 局部和等于目标值，保存组合，向上回退，寻找其它组合
 */
public class Solution {
    public  static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (candidates.length == 0) return list;
        List<Integer> curList = new ArrayList<>();
        dfs(candidates, list, curList, target, 0, 0);
        return list;
    }

    public static void dfs(int[] candidates, List<List<Integer>> list, List<Integer> curList, int target, int curSum, int prev) {
        //边界，如果大于等于目标，则结束
        if (curSum >= target) {
            //等于目标，找到一个组合
            if (curSum == target) {
                list.add(new ArrayList<>(curList));
            }
            return;
        }
        //可以从上一个位置开始，因为元素可以重复
        for (int i = prev; i < candidates.length; i++) {
            //单个值已经大于目标，直接跳过
            if(candidates[i] > target)
                continue;
            //把当前的值放进来
            curList.add(candidates[i]);
            dfs(candidates, list, curList, target, curSum + candidates[i], i);
            //回溯，向上回退
            curList.remove(curList.size() - 1);
        }
    }
}
