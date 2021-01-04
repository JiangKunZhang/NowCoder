package 电话号码的组合;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/5 17:01
 */
public class Solution {
    String[] mapString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.length() == 0) return list;
        StringBuilder sb = new StringBuilder();
        dfs(digits, list, sb, 0);
        return list;
    }

    public void dfs(String digits, List<String> list, StringBuilder curStr, int index) {
        //边界，找到一种组合，放入数组中，结束此路径，向上回溯
        if (index == digits.length()) {
            list.add(curStr.toString());
            return;
        }
        //找到当前字符在string映射表中的位置
        String strMap = mapString[digits.charAt(index) - '0'];
        //遍历每一种可能的组合
        for (int i = 0; i < strMap.length(); i++) {
            dfs(digits, list, curStr.append(strMap.charAt(i)), index + 1);
            curStr.deleteCharAt(curStr.length() - 1);//当前的放过了，删除掉，通过循环看后面的
        }
    }
}
