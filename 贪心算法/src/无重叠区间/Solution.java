package 无重叠区间;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/4 17:36
 */
public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int i = 0;
        int sum = 1;
        //找到所有不重叠的
        for (int j = 1; j < intervals.length; j++) {
            if (intervals[j][0] >= intervals[i][1]) {
                i = j;
                sum++;
            }
        }
        //总数减去不重叠的就是重叠的
        return intervals.length - sum;
    }
}
