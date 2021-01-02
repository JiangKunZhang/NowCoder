package wordBreak;

import java.util.List;
import java.util.Set;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/7/30 18:43
 */

/**
 * 方法：动态规划
 * 状态：
 *      子状态：前1，2，3，...,n个字符能否根据词典中的词被成功分词
 *      F(i): 前i个字符能否根据词典中的词被成功分词
 * 状态递推：
 *      F(i): true{j <i && F(j) && substr[j+1,i]能在词典中找到} OR false
 *      在j小于i中，只要能找到一个F(j)为true，并且从j+1到i之间的字符能在词典
 *      中找到，则F(i)为true
 * 初始值：
 *      对于初始值无法确定的，可以引入一个不代表实际意义的空状态，作为状态的起始
 *      空状态的值需要保证状态递推可以正确且顺利的进行，到底取什么值可以通过简单
 *      的例子进行验证
 *      F(0) = true
 * 返回结果：F(n)
 */
public class Solution {
    public boolean wordBreak(String s, List<String> dict) {
        boolean[] canBreak = new boolean[s.length() + 1];
        // 初始化F(0) = true
        canBreak[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // F(i): true{j < i && F(j) && substr[j+1,i]能在词典中找到} OR false
                // 第j+1个字符的索引为j
                if (canBreak[j] && dict.contains(s.substring(j,i))) {
                    canBreak[i] = true;
                    break;
                }
            }
        }
        return canBreak[s.length()];
    }
}
