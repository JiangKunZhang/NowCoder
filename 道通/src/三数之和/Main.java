package 三数之和;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/10/13 22:12
 */
import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> res = new LinkedList<>();
        while (sc.hasNextInt()) {
            res.add(sc.nextInt());
        }

        Integer[] array = new Integer[res.size()];
        res.toArray(array);
        List<List<Integer>> s = func(array);

        for (int i = 0; i < s.size(); i++) {
            for (int j = 0; j < s.get(i).size(); j++) {
                if (j != 0) {
                    System.out.print(" ");
                }
                System.out.print(s.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> func(Integer[] array) {
        if (array == null) return null;
        if (array.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(array);
        HashSet<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            int j = i + 1;
            int k = array.length - 1;
            while (j < k) {
                if (array[i] + array[j] + array[k] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(array[i]);
                    list.add(array[j]);
                    list.add(array[k]);
                    set.add(list);
                    while (j < k && array[j] == array[j + 1]) {
                        j++;
                    }
                    while (j < k && array[k] == array[k - 1]) {
                        k--;
                    }
                    j++;
                    k--;
                } else if (array[i] + array[j] + array[k] < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return  new ArrayList<>(set);
    }
}