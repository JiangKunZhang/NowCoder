package 分割平衡字符串;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/4 15:47
 */

/**
 * 题目要求通过分割得到的最大数量，即尽可能多的分割。
 * 贪心策略: 不要有嵌套的平衡，只要达到平衡，就立即分割。
 * 故可以定义一个变量balance，在遇到不同的字符时，向不同的方向变化，当balance为0时达到平衡，分割数更新。
 * 比如：
 * 从左往右扫描字符串s，遇到L,balance - 1，遇到R，balance + 1
 * 当balance为0时即，更新记录cnt ++
 * 如果最后cnt==0，说明s只需要保持原样，返回1
 */
public class Solution {
    public int balancedStringSplit(String s) {
        int count = 0;
        int balance = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') balance++;
            if (s.charAt(i) == 'R') balance--;
            if (balance == 0) count++;
        }
        return count;
    }
}
