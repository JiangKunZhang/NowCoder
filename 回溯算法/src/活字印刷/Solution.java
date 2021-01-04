package 活字印刷;

import java.util.HashSet;
import java.util.Set;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/5 17:42
 */

/**
 * 此题组合的长度不唯一，最小组合长度为1， 最大组合长度为tiles的长度。
 * 按照题意tiles中每一个位置的字符在组合中只能出现一次， 所以可以用一个标记辅助
 * 当去组合新的组合时，可以与tiles中的每一个位置组合，但是如果当前位置已经在当前组合中出现过，则跳过
 * 虽然此题中每一个位置的字符在组合中只能出现一次，但是tiles中可能有相同的字符，所以需要考虑重复的组合
 * 而set可以天然去重，可以用其去重
 * DFS + 回溯：
 * 1.当前组合不为空, 则插入set中
 * 2.继续给当前组合拼接新的组合，尝试拼接tiles每一个位置的字符
 * 3.如果当前位置已在组合中出现过，返回到2，否则标记当前位置，继续拼接更长的组合
 * 4.回溯，尝试组合其它位置，返回2
 * 当所有位置都已经使用过时，当前递归就结束了，继续向上层DFS回退
 * 最终返回set的大小即为组合数目
 */
public class Solution {
    public int numTilePossibilities(String tiles) {
        if (tiles.length() == 0) return 0;
        Set<String> set = new HashSet<>();
        int[] book = new int[tiles.length()];
        dfs(tiles, book, set, "");
        return set.size();
    }

    public void dfs(String tiles, int[] book, Set<String> set, String curStr) {
        if (curStr.length() != 0) {
            set.add(curStr);
        }
        //标记保证所有位都用完之后，就结束了
        for (int i = 0; i < tiles.length(); i++) {
            //当前位置的字符没用过，进入循环，否则看下一个
            if (book[i] == 0) {
                book[i] = 1;
                dfs(tiles, book, set, curStr + tiles.charAt(i));
                //回溯，尝试其它字符
                book[i] = 0;
            }
        }
    }
}

class test {
    public int numTilePossibilities(String tiles) {
        if (tiles.length() == 0) {
            return 0;
        }
        Set<String> set = new HashSet<>();
        int[] book = new int[tiles.length()];
        StringBuilder sb = new StringBuilder();
        dfs(tiles, book, set, sb);
        return set.size();
    }

    public void dfs(String tiles, int[] book, Set<String> set, StringBuilder sb) {
        if (sb.length() != 0) {
            set.add(sb.toString());
        }
        for (int i = 0; i < tiles.length(); i++) {
            if (book[i] == 0) {
                book[i] = 1;
                dfs(tiles, book, set, sb.append(tiles.charAt(i)));
                book[i] = 0;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
