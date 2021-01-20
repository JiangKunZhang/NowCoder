package 多机调度问题;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/4 16:27
 */

/**
 * 多机调度问题
 *
 * 某工厂有n个独立的作业，由m台相同的机器进行加工处理。作业i所需的加工时间为ti，任何作业在被处理时不能中
 * 断，也不能进行拆分处理。现厂长请你给他写一个程序：算出n个作业由m台机器加工处理的最短时间
 * 输入
 * 第一行T（1<T<100)表示有T组测试数据。每组测试数据的第一行分别是整数n，m（1<=n<=10000，
 * 1<=m<=100），接下来的一行是n个整数ti（1<=t<=100)。
 * 输出
 * 所需的最短时间
 *
 * 这个问题还没有有效的解法(求最优解)，但是可以用贪心选择策略设计出较好的近似算法(求次优解)。
 * 贪心策略
 *
 * 当n<=m时，只要将作业分给每一个机器即可；当n>m时，首先将n个作业从大到小排序，然后依此顺序将作业分配给空闲
 * 的处理机。也就是说从剩下的作业中，选择需要处理时间最长的，然后依次选择处理时间次长的，直到所有的作业全部处
 * 理完毕，或者机器不能再处理其他作业为止。如果我们每次是将需要处理时间最短的作业分配给空闲的机器，那么可能就
 * 会出现其它所有作业都处理完了只剩所需时间最长的作业在处理的情况，这样势必效率较低。
 */
public class Main {
    public static void main(String[] args) {
        int n = 6;
        int m = 3;
        Integer[] taskTime = {2, 5, 13, 15, 16, 20};
        int maxTime = greedStrategy(taskTime, m);
        System.out.println(maxTime);
    }

    private static int greedStrategy(Integer[] taskTime, int m) {
        Arrays.sort(taskTime, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        if (taskTime.length <= m) {
            return taskTime[0];
        }
        int[] works = new int[m];
        // 为每一个作业选择机器
        for (int i = 0; i < taskTime.length; i++) {
            // 选择最小的机器
            //首先假设用第一个机器处理
            int minIndex = 0;
            // 从剩余机器中选择作业时间最小的
            for (int j = 1; j < m; j++) {
                if (works[j] < works[minIndex]) {
                    minIndex = j;
                }
            }
            // 将当前作业交给最小的机器执行
            works[minIndex] += taskTime[i];
        }
        // 从所有机器中选出最后执行完作业的机器
        int maxTime = works[0];
        for (int i = 1; i < m; i++) {
            if (works[i] > maxTime) {
                maxTime = works[i];
            }
        }
        return maxTime;
    }
}
