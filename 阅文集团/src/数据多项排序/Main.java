package 数据多项排序;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/10/21 19:12
 */

class Line {
    long id;
    int category;
    int words;
    String updateTime;

    public Line(long id, int category, int words, String updateTime) {
        this.id = id;
        this.category = category;
        this.words = words;
        this.updateTime = updateTime;
    }
}

class LineCom implements Comparator<Line> {

    @Override
    public int compare(Line o1, Line o2) {
        if (o1.category != o2.category) {
            return o1.category - o2.category;
        } else if (!o1.updateTime.equals(o2.updateTime)) {
            return o1.updateTime.compareTo(o2.updateTime);
        } else if (o1.words != o2.words) {
            return o1.words - o2.words;
        } else {
            return (int)(o1.id - o2.id);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Line[] lines = new Line[n];
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] strings = s.split(",");
            long id = Long.parseLong(strings[0]);
            int category = Integer.parseInt(strings[1]);
            int words = Integer.parseInt(strings[2]);
            String updateTime = strings[3];
            Line l = new Line(id, category, words, updateTime);
            lines[i] = l;
        }
        Arrays.sort(lines, new LineCom());
        for (int i = 0; i < n; i++) {
            System.out.println(lines[i].id);
        }
    }
}
