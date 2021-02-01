package WalkingMachine;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/10/25 13:16
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        walkingMachine();
    }

    public static void walkingMachine() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        in.nextLine();
        char[][] chars = new char[n][m];
        int[][] flags = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            for (int j = 0; j < m; j++) {
                chars[i][j] = s.charAt(j);
            }
        }
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                walk(chars,flags,i,j);
            }
        }
        int sum=0;
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (flags[i][j]==2){
                    sum++;
                }
            }
        }
        System.out.println(sum);
    }

    public static boolean walk(char[][] chars, int[][] flags, int i, int j) {
        if (i < 0 || i >= chars.length || j < 0 || j >= chars[0].length || flags[i][j] == 2) {
            return false;
        }
        if (flags[i][j] == 1) {
            return true;
        }
        flags[i][j] = 1;
        boolean flag = false;
        if (chars[i][j] == 'W') {
            flag = walk(chars, flags, i - 1, j);
        } else if (chars[i][j] == 'A') {
            flag = walk(chars, flags, i, j - 1);
        } else if (chars[i][j] == 'S') {
            flag = walk(chars, flags, i + 1, j);
        } else if (chars[i][j] == 'D') {
            flag = walk(chars, flags, i, j + 1);
        }
        if (!flag) {
            flags[i][j] = 2;
            return false;
        }
        return true;
    }
}

