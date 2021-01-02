package triangle;

import java.util.ArrayList;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/7/30 19:23
 */

/**
 * 方法：动态规划
 * 状态：
 *      子状态：从(0,0)到(1,0),(1,1),(2,0),...(n,n)的最短路径和
 *      F(i,j): 从(0,0)到(i,j)的最短路径和
 * 状态递推：
 *      F(i,j) = min( F(i-1, j-1), F(i-1, j)) + triangle[i][j]
 * 初始值：
 *      F(0,0) = triangle[0][0]
 * 返回结果：
 *      min(F(n-1, i))
 *      最后一行最小的元素
 */

public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle == null) return 0;

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int row = triangle.size();
        for (int i = 0; i < row; i++) {
            result.add(new ArrayList<>());
        }
        // F[0][0]初始化
        result.get(0).add(triangle.get(0).get(0));
        for (int i = 1; i < row; i++) {
            //上一行的最小值
            int curSum = 0;
            for (int j = 0; j < triangle.get(i).size(); j++) {
                // 处理左边界和右边界
                if (j == 0) {
                    curSum = result.get(i - 1).get(0);
                } else if (j == i) {
                    curSum = result.get(i - 1).get(j - 1);
                } else {
                    curSum = Math.min(result.get(i - 1).get(j - 1), result.get(i - 1).get(j));
                }
                // F(i,j) = min( F(i-1, j-1), F(i-1, j)) + triangle[i][j]
                result.get(i).add(curSum  + triangle.get(i).get(j));
            }
        }
        int size = triangle.size();
        // min(F(n-1, i))
        int allMin = result.get(size - 1).get(0);
        //在最后一行找最小的值
        for (int i = 1; i < result.get(size - 1).size(); i++) {
            allMin = Math.min(result.get(size - 1).get(i), allMin);
        }
        return allMin;
    }
}
