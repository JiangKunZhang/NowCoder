package BFS打开转盘锁;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/10 17:12
 */
public class Solution {
    public int openLock(String[] deadends, String target) {
        // 哈希表的查找更快
        Set<String> lock = new HashSet<>();
        for (String string : deadends) {
            lock.add(string);
        }
        //如果"0000"在死亡字符串中，则永远到达不了
        if (lock.contains("0000")) {
            return -1;
        }
        //加标记，已经搜索过的字符串不需要再次搜索
        Set<String> book = new HashSet<>();
        //初始化队列
        Queue<String> queue = new LinkedList<>();
        int res = 0;

        queue.offer("0000");
        book.add("0000");
        while (!queue.isEmpty()) {
            int size = queue.size();
            //从上一步转换之后的字符串都需要进行验证和转换
            //并且只算做一次转换，类似于层序遍历，转换的步数和层相同
            //同一层的元素都是经过一步转换得到的
            while (size-- != 0) {
                String number = queue.poll();

                if (number.equals(target)) {
                    return res;
                }
                //四位密码锁，每个位置每次都可以转一次
                for (int i = 0; i < 4; i++) {
                    char ch1 = number.charAt(i);
                    char ch2 = number.charAt(i);
                    //当前位置可以向前或者向后拨一位
                    if (ch1 == '9') {
                        ch1 = '0';
                    } else {
                        ch1++;
                    }

                    if (ch2 == '0') {
                        ch2 = '9';
                    } else {
                        ch2--;
                    }

                    StringBuilder sb1 = new StringBuilder(number);
                    StringBuilder sb2 = new StringBuilder(number);

                    sb1.setCharAt(i, ch1);
                    sb2.setCharAt(i, ch2);
                    if (!lock.contains(sb1.toString()) && !book.contains(sb1.toString())) {
                        queue.offer(sb1.toString());
                        book.add(sb1.toString());
                    }
                    if (!lock.contains(sb2.toString()) && !book.contains(sb2.toString())) {
                        queue.offer(sb2.toString());
                        book.add(sb2.toString());
                    }
                }
            }
            res++;
        }
        return -1;
    }
}
