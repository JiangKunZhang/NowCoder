package 整数分解;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/10/10 19:16
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int res = 0;
        List<List<Integer>> resSet = new LinkedList<>();
        List<Integer> cur = new LinkedList<>();
        boolean[] book = new boolean[n + 1];
        dfs(resSet, cur, n, k, 1, book);
        System.out.println(resSet.size());
        System.out.println(resSet.toArray().toString());
    }

    public static void dfs(List<List<Integer>> res, List<Integer> cur, int n, int k, int index, boolean[] book) {
        if (cur.size() == k) {
            int temp = 0;
            for (int a : cur) {
                temp += a;
            }
            if (temp == n) {
                res.add(new LinkedList<>(cur));
            }
            return;
        }
        book[index] = true;
        cur.add(index);
        for (int i = 1; i <= n; i++) {
            if (book[i] == false) {
                dfs(res, cur, n, k, index + 1, book);
            }
        }
        book[index] = false;
        cur.remove(cur.size() - 1);
    }
}
