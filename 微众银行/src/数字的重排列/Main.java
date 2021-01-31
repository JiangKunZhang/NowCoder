package 数字的重排列;

import java.util.*;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/10/15 20:58
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        //int n = sc.nextInt();
        int m = sc.nextInt();
        if (n < m) {
            System.out.println(0);
        } else {
            int count = 0;
            String s = String.valueOf(n);
            int[] arr = new int[s.length()];
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                arr[i] = ch - '0';
            }
            List<String> res = new ArrayList<>();
            Set<String> set = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            boolean[] book = new boolean[arr.length];
            dfs(res, sb, 0, arr, book, set);
            for (int i = 0; i < res.size(); i++) {
                if (res.get(i).charAt(0) == '0') {
                    continue;
                }
                //int temp = Integer.parseInt(res.get(i));
                long temp = Long.parseLong(res.get(i));
                if (temp % m == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    public static void dfs(List<String> res, StringBuilder cur, int index, int[] arr, boolean[] book, Set<String> set ) {
        if (index == arr.length) {
            if (!set.contains(cur.toString())) {
                set.add(cur.toString());
                res.add(cur.toString());
            }
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (book[i] == false) {
                book[i] = true;
                cur.append(arr[i]);
                dfs(res, cur, index + 1, arr, book, set);
                book[i] = false;
                cur.deleteCharAt(cur.length() - 1);
            }
        }
    }

    public static String cutZero(String s) {
        int i;
        for (i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 0) {
                continue;
            } else {
                break;
            }
        }
        return s.substring(i + 1);
    }
}
