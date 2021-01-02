package 回文串分割;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/1 22:26
 */

/**
 * 方法：动态规划
 * 状态：
 *      子状态：到第1,2,3,...,n个字符需要的最小分割数
 *      F(i): 到第i个字符需要的最小分割数
 * 状态递推：
 *      F(i) = min{F(i), 1 + F(j)}, where j<i && j+1到i是回文串
 *      上式表示如果从j+1到i判断为回文字符串，且已经知道从第1个字符
 *      到第j个字符的最小切割数，那么只需要再切一次，就可以保证
 *      1-->j, j+1-->i都为回文串。
 * 初始化：
 *      F(i) = i - 1
 *      上式表示到第i个字符需要的最大分割数
 *      比如单个字符只需要切0次，因为单子符都为回文串
 *      2个字符最大需要1次，3个2次......
 * 返回结果：
 *      F(n)
 */

public class Solution {
    /**
     *
     * @param s string字符串
     * @return int整型
     */
    public int minCut (String s) {
        // write code here
        if (s == null) return 0;
        if (isPal(s, 0, s.length() - 1)) return 0;
        int[] minCut = new int[s.length() + 1];
        // F(i)初始化
        // F(0）= -1，必要项，如果没有这一项，对于重叠字符串 "aaaaa" 会产生错误的结果
        for (int i = 0; i <= s.length(); i++) {
            minCut[i] = i - 1;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // F(i) = min{F(i), F(j) + 1}, where j<i && j+1到i是回文串
                // 从最长串判断，如果从第j+1到i为回文字符串
                // 则再加一次分割，从1到j，j+1到i的字符就全部分成了回文字符串
                // j + 1 个字符索引是 j ，第 i 个字符索引是 i - 1
                if (isPal(s, j, i - 1)) {
                    minCut[i] = Math.min(minCut[i], minCut[j] + 1);
                }
            }
        }
        return minCut[s.length()];
    }

    //回文串的判定
    public boolean isPal(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
