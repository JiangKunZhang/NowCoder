package 去除重复字符;

import java.util.HashSet;
import java.util.Set;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/10/21 19:40
 */
public class Solution {
    /**
     *
     * @param str string字符串
     * @return string字符串
     */
    public String removeDuplicatedChars (String str) {
        // write code here
        Set<Character> set = new HashSet<>();
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (!set.contains(chars[i])) {
                set.add(chars[i]);
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}