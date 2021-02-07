package 字母异位词;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/10/17 16:43
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param strs string字符串一维数组
     * @return string字符串ArrayList<ArrayList<>>
     */
    public static ArrayList<ArrayList<String>> groupAnagrams (String[] strs) {
        // write code here
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        boolean[] used = new boolean[strs.length];
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            char[] arr = s.toCharArray();
            boolean[] book = new boolean[arr.length];
            Set<String> set = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            dfs(set, sb, book, 0, arr);
            ArrayList<String> cur = new ArrayList<>();
            for (int j = 0; j < strs.length; j++) {
                if (set.contains(strs[j]) && used[j] == false) {
                    cur.add(strs[j]);
                    used[j] = true;
                }
            }
            if (cur.size() > 0) res.add(cur);
        }
        return res;
    }

    public static void dfs(Set<String> set, StringBuilder sb, boolean[] book, int index, char[] arr) {
        if (index == arr.length) {
            set.add(sb.toString());
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (book[i] == false) {
                book[i] = true;
                sb.append(arr[i]);
                dfs(set, sb, book, index + 1, arr);
                book[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String[] s = {"eat", "tea", "tan", "ate", "nat", "bat", "test", "stet"};
        ArrayList<ArrayList<String>> res = groupAnagrams(s);
    }
}
