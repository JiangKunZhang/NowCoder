package 字符串有效判断;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/9/15 19:31
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            Stack<Character> stack = new Stack<>();
            boolean flag = false;
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if ((ch == '(') || (ch == '{') || (ch == '[')) {
                    stack.push(ch);
                } else {
                    if (!stack.isEmpty()) {
                        if ((stack.peek() == '(' && ch == ')') || (stack.peek() == '{' && ch == '}') || (stack.peek() == '[' && ch == ']')) {
                            stack.pop();
                        }
                    } else {
                        System.out.println(false);
                        flag = true;
                        break;
                    }
                }
            }
            if (flag == false)
                System.out.println(stack.isEmpty());
        }
    }
}
