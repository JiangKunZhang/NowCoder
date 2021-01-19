package 做对的题数;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/9/25 19:08
 */

class Interval {
    int start;
    int end;
}

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回Interval类，start代表汪仔最少做对了多少道题，end代表汪仔最多做对了多少道题。
     * @param n int整型 选择题总数
     * @param k int整型 朋友做对的题数
     * @param str1 string字符串 长度为n只包含ABCD的字符串，其中第i个代表汪仔第i题做出的选择
     * @param str2 string字符串 长度为n只包含ABCD的字符串，其中第i个代表朋友第i题做出的选择
     * @return Interval类
     */
    public Interval solve (int n, int k, String str1, String str2) {
        // write code here
        if (str1.equals(str2)) {
            Interval res = new Interval();
            res.start = k;
            res.end = k;
            return res;
        }

        int count = 0;
        int m = 0;
        for (int i = 0; i < str1.length(); i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);
            if (ch1 == ch2) count++;
            if (ch1 != ch2) m++;
        }

        Interval res = new Interval();
        res.start = Math.min(count, k);
        res.end = m - k;
        return res;
    }
}
