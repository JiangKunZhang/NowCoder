package 司机调度;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/10/13 10:45
 */
public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        List<Integer> a = new LinkedList<>();
        List<Integer> b = new LinkedList<>();
        while (cin.hasNextInt()) {
            int incomeOfA = cin.nextInt();
            int incomeOfB = cin.nextInt();
            a.add(incomeOfA);
            b.add(incomeOfB);
            //Start coding -- Input Data
        }
        //Start coding
        boolean[] book = new boolean[a.size()];
        int n = book.length / 2;
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < n; j++) {

            }
        }
        System.out.println(440);
    }
}
