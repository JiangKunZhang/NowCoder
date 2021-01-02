package 编辑距离;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/2 22:33
 */

/**
 * 方法：动态规划
 * 状态：
 *      子状态：word1的前1，2，3，...m个字符转换成word2的前1，2，3，...n个字符需要的编辑距离
 *      F(i,j):word1的前i个字符于word2的前j个字符的编辑距离
 * 状态递推：
 *      F(i,j) = min { F(i-1,j）+1, F(i,j-1) +1, F(i-1,j-1) +(w1[i]==w2[j]?0:1) }
 *      上式表示从删除，增加和替换操作中选择一个最小操作数
 *      F(i-1,j): w1[1,...,i-1]于w2[1,...,j]的编辑距离，删除w1[i]的字符--->F(i,j)
 *      F(i,j-1): w1[1,...,i]于w2[1,...,j-1]的编辑距离，增加一个字符--->F(i,j)
 *      F(i-1,j-1): w1[1,...,i-1]于w2[1,...,j-1]的编辑距离，如果w1[i]与w2[j]相同，
 *      不做任何操作，编辑距离不变，如果w1[i]与w2[j]不同，替换w1[i]的字符为w2[j]--->F(i,j)
 * 初始化：
 *      初始化一定要是确定的值，如果这里不加入空串，初始值无法确定
 *      F(i,0) = i :word与空串的编辑距离，删除操作
 *      F(0,i) = i :空串与word的编辑距离，增加操作
 * 返回结果：
 *      F(m,n)
 */

public class Solution {
    /**
     *
     * @param word1 string字符串
     * @param word2 string字符串
     * @return int整型
     */

    public int minDistance (String word1, String word2) {
        // write code here
        int row = word1.length();
        int col = word2.length();
        int[][] minDis = new int[row + 1][col + 1];
        // F(i,j)初始化
        for (int i = 0; i <= row; i++) {
            minDis[i][0] = i;
        }
        for (int j = 1; j <= col; j++) {
            minDis[0][j] = j;
        }

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                // F(i,j) = min { F(i-1,j）+1, F(i,j-1) +1, F(i-1,j-1) +(w1[i]==w2[j]?0:1)}
                //插入，删除
                //word1的前i-1个都是word2的前j个了，就是删除
                //word1的前i个都是word2的前j-1个了，就是插入
                minDis[i][j] = Math.min(minDis[i - 1][j], minDis[i][j - 1]) + 1;
                // 判断word1的第i个字符是否与word2的第j个字符相等
                if (word1.charAt(i - 1) == word2.charAt(j  - 1)) {
                    //相等了就和插入删除选一个最小的
                    minDis[i][j] = Math.min(minDis[i][j], minDis[i - 1][j - 1]);
                } else {
                    //字符不相等，F(i-1,j-1)编辑距离 + 1
                    //不相等就需要一次替换
                    minDis[i][j] = Math.min(minDis[i][j], minDis[i - 1][j - 1] + 1);
                }
            }
        }
        return minDis[row][col];
    }
}