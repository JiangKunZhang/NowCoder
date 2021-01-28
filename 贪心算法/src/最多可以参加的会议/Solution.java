package 最多可以参加的会议;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/4 17:29
 */
public class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int i = 0;
        int sum = 1;
        for (int j = 1; j < events.length; j++) {
            if (events[j][0] >= events[i][1]) {
                i = j;
                sum++;
            }
        }
        return sum;
    }
}
