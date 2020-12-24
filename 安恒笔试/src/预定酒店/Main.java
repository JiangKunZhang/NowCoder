package 预定酒店;

import java.util.*;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/9/13 10:22
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            List<Integer> input = new ArrayList<>();
//        input.add(300);
//        input.add(700);
//        input.add(1000);
            String s = sc.nextLine();
            String[] strings = s.split(" ");
            for (String string : strings) {
                input.add(Integer.parseInt(string));
            }
//        while (sc.hasNext()) {
//            input.add(sc.nextInt());
//        }
            int money = input.get(input.size() - 1);
            input.remove(input.size() - 1);
            Collections.sort(input, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            int days = 0;
            int index = 0;
            while (money != 0 && index < input.size()) {
                if (money >= input.get(index)) {
                    days += money / input.get(index);
                    money = money - days * input.get(index);
                }
                index++;
            }
            if (days == 0) {
                System.out.println(-1);
            } else {
                System.out.println(days);
            }
        }
    }
}
