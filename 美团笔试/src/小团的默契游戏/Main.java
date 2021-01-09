package 小团的默契游戏;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/29 17:15
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                List<Integer> res = new ArrayList<>();
                int l = list.get(i);
                int r = list.get(j);
                if ((1 <= l && l <= m) && (1 <= r && r <=m)) {
                    if (l <= r) {
                        for (int k = 0; k < n; k++) {
                            int num = list.get(k);
                            if ((0 < num && num < l) || (r < num && num < m + 1)) {
                                res.add(num);
                            }
                        }
                        boolean flag = false;
                        for (int k = 0; k < res.size() - 1; k++) {
                            if (res.get(k) > res.get(k + 1)) {
                                flag = true;
                                break;
                            }
                        }
                        if (flag == false && res.size() > 0) {
                            result++;
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }
}
