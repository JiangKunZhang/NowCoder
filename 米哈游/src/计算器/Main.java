package 计算器;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/10/17 20:30
 */

class Calc {
    private Stack<Long> numStack = null;
    private Stack<Character> symStack = null;
    public long calculate(String numStr) {
        numStr = removeStr(numStr);

        if (numStr.length() > 1 && !"=".equals(numStr.charAt(numStr.length() - 1) + "")) {
            numStr += "=";
        }
        if (!isStan(numStr)) {
            return 0;
        }
        numStack = new Stack<>();
        symStack = new Stack<>();
        StringBuffer temp = new StringBuffer();
        for (int i = 0; i <  numStr.length(); i++) {
            char ch = numStr.charAt(i);
            if (isNumber(ch)) {
                temp.append(ch);
            } else {
                String tempStr = temp.toString();
                if (!tempStr.isEmpty()) {
                    long num = Long.parseLong(tempStr);
                    numStack.push(num);
                    temp = new StringBuffer();
                }
                while (!comparePri(ch) && !symStack.empty()) {
                    long b = numStack.pop();
                    long a = numStack.pop();
                    switch ((char)symStack.pop()) {
                        case '+': numStack.push(a + b); break;
                        case '-': numStack.push(a - b); break;
                        case '*': numStack.push(a * b); break;
                        case '/': numStack.push(a / b); break;
                        default:break;
                    }
                }
                if (ch != '=') {
                    symStack.push(new Character(ch));
                    if (ch == ')') {
                        symStack.pop();
                        symStack.pop();
                    }
                }
            }
        }
        return numStack.pop();
    }

    private boolean isStan(String numStr) {
        if (numStr == null || numStr.isEmpty()) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        boolean b = false;
        for (int i = 0; i < numStr.length(); i++) {
            char n = numStr.charAt(i);
            if (!(isNumber(n) || "(".equals(n + "") || ")".equals(n + "") || "+".equals(n + "") || "-".equals(n + "")
            || "*".equals(n + "") || "/".equals(n + "") || "=".equals(n + ""))) {
                return false;
            }
            if ("(".equals(n + "")) {
                stack.push(n);
            }
            if (")".equals(n + "")) {
                if (stack.isEmpty() || !"(".equals((char)stack.pop() + ""))
                    return false;
            }
            if ("=".equals(n + "")) {
                if (b) {
                    return false;
                }
                b = true;
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        if (!"(".equals(numStr.charAt(numStr.length() - 1) + ""))
            return false;
        return true;
    }

    private boolean comparePri(char symbol) {
        if (symStack.empty()) {
            return true;
        }
        char top = (char)symStack.peek();
        if (top == '(') {
            return true;
        }
        switch (symbol) {
            case '(': return true;
            case '*':{
                if (top == '+' || top == '-') {
                    return true;
                } else {
                    return false;
                }
            }
            case '/': {
                if (top == '+' || top == '-') {
                    return true;
                } else {
                    return false;
                }
            }
            case '+': return false;
            case '-': return false;
            case ')' : return false;
            case '=' : return false;
            default:break;
        }
        return true;
    }

    private boolean isNumber(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }

    private String removeStr(String numStr) {
        return numStr != null ? numStr.replaceAll(" ", "") : "";
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Calc c = new Calc();
        long res = c.calculate(s);
        System.out.println(res);
    }


}
