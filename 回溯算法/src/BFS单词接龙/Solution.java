package BFS单词接龙;

import java.util.*;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/10 16:25
 */
public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //hash表的查询效率最高
        Set<String> wordDict = new HashSet<>();
        for (String string : wordList) {
            wordDict.add(string);
        }
        //标记单词是否已经访问过，访问过的不再访问
        Set<String> book = new HashSet<>();
        int res = 1;
        //初始化队列
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        book.add(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            //每一步都要把队列中上一步添加的所有单词转换一遍
            //最短的转换肯定在这些单词当中， 所有这些词的转换只能算一次转换
            //因为都是上一步转换出来的
            while (size-- != 0) {
                String word = queue.poll();
                //转换成功，返回
                if (word.equals(endWord)) {
                    return res;
                }
                //尝试转换当前单词的每一个位置
                for (int i = 0; i < word.length(); i++) {
                    StringBuilder sb = new StringBuilder(word);
                    //每一个位置用26个字母分别替换
                    for (char j = 'a'; j <= 'z'; j++) {
                        sb.setCharAt(i, j);
                        String newWord = sb.toString();
                        //如果列表中没有此单词或者已经访问过（它的转换已经遍历过，无需再次遍历），则跳过
                        if (!wordDict.contains(newWord) || book.contains(newWord)) {
                            continue;
                        }
                        //还没有转换成功，则新的单词入队
                        queue.offer(newWord);
                        book.add(newWord);
                    }
                }
            }
            res++;
        }
        //转换不成功，返回0
        return 0;
    }
}
