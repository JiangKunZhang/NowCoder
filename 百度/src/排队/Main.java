package 排队;

import java.util.*;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/9/14 19:58
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Queue<Integer>[] init = new Queue[n + 1];
        //List<Queue<Integer>> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            Queue<Integer> temp = new LinkedList<>();
            temp.add(i);
            init[i] = temp;
        }
        for (int i = 0; i < m; i++) {
            String s = sc.next();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (s.equals("C")) {
                Queue<Integer> A = init[a];
                Queue<Integer> B = init[b];
                while (!A.isEmpty()) {
                    B.add(A.poll());
                }
            }
            if (s.equals("Q")) {
                Queue<Integer> tempA = new LinkedList<>();
                Queue<Integer> tempB = new LinkedList<>();
                for (int j = 1; j <= n; j++) {
                    Queue<Integer> temp = init[j];
                    if (temp.contains(a)) tempA = temp;
                    if (temp.contains(b)) tempB = temp;
                }
                if (!tempA.contains(b) && !tempB.contains(a)) {
                    System.out.println(-1);
                } else {
                    List<Integer> l = new LinkedList<>();
                    while (!tempA.isEmpty()) {
                        l.add(tempA.poll());
                    }
                    int aIndex = 0;
                    int bIndex = 0;
                    for (int j = 0; j < l.size(); j++) {
                        if (l.get(j) == a) {
                            aIndex = j;
                        }
                        if (l.get(j) == b) {
                            bIndex = j;
                        }
                    }
                    System.out.println(aIndex - bIndex - 1);
                }
            }
        }
    }
}
