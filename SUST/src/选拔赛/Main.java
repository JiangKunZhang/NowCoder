package 选拔赛;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/9/19 23:18
 */
public class Main {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"Monday");
        map.put(2,"Tuesday");
        map.put(3,"Wednesday");
        map.put(4,"Thursday");
        map.put(5,"Friday");
        map.put(6,"Saturday");
        map.put(7,"Sunday");
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            System.out.println(map.get(n));
        }
    }
}
