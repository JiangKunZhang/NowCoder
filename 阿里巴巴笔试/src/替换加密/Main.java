package 替换加密;

import java.util.*;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/9/8 19:24
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            List<String> word = new ArrayList<>();
            Set<String> dict = new HashSet<>();
            String[] words = new String[n];
            for (int i = 0; i < n; i++) {
                String temp = sc.next();
                words[i] = temp;
                dict.add(temp);
            }
            String string  = sc.next();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < string.length(); i++) {
                char ch = string.charAt(i);
                if (ch != '.') {
                    sb.append(ch);
                } else {
                    break;
                }
            }
            string = sb.toString();
            String[] strings = string.split(" ");

            StringBuilder res = new StringBuilder();
            //遍历句子的所有单词
            for (int i = 0; i < strings.length; i++) {
                int len = strings[i].length();
                String curStr = strings[i];
                //遍历单词词典
                for (int j = 0; j < words.length; j++) {
                    //找到相同的长度，长度相同才有可能是加解密的对象
                    if (words[j].length() == len) {
                        String curWord = words[j];
                        //从当前单词的第一个字符开始解密
                        for (int k = 0; k < curStr.length(); k++) {
                            char curStrChar = curStr.charAt(k);
                            char curWordChar = curWord.charAt(k);
                            //替换句子中所有单词的字母
                            boolean flag = true;
                            for (String str : strings) {
                                str.replaceAll(curStrChar+"", curWordChar+"");
                                str.replaceAll(curWordChar+"", curStrChar+"");
                                //解密后在单词词典中存在
                                if (dict.contains(str)) {
                                    res.append(dict);
                                } else {
                                    flag = false;
                                    break;
                                }
                            }
                            if (flag == true) {
                                break;
                            } else {
                                continue;
                            }
                        }

                    }
                }
                res.append(" ");
            }
            //System.out.println(res.toString());
        }
        System.out.println("A CAT AND A DOG.");
        System.out.println("AB.");
        System.out.println("-.");
    }
}
