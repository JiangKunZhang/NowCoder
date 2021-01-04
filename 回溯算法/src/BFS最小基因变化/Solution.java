package BFS最小基因变化;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/10 16:47
 */
public class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankDict = new HashSet<>();
        for (String string : bank) {
            bankDict.add(string);
        }
        Set<String> book = new HashSet<>();
        Queue<String> queue = new LinkedList();
        char[] change = {'A','C','G','T'};
        int res = 0;
        queue.offer(start);
        book.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- != 0) {
                String dna = queue.poll();
                if (dna.equals(end)) {
                    return res;
                }
                for (int i = 0; i < 8; i++) {
                    StringBuilder sb = new StringBuilder(dna);
                    for (int j = 0; j < 4; j++) {
                        sb.setCharAt(i, change[j]);
                        String changeDna = sb.toString();
                        if (!bankDict.contains(changeDna) || book.contains(changeDna)) {
                            continue;
                        }
                        queue.offer(changeDna);
                        book.add(changeDna);
                    }
                }
            }
            res++;
        }
        return -1;
    }
}
