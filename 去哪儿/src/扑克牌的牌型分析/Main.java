package 扑克牌的牌型分析;

import java.util.Scanner;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/9/23 19:44
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = sc.next();
        }
        boolean[] S = new boolean[15];
        boolean[] H = new boolean[15];
        boolean[] C = new boolean[15];
        boolean[] D = new boolean[15];
        boolean[][] Arr = new boolean[4][15];
        boolean[] hArr = new boolean[15];
        boolean[] cArr = new boolean[15];
        boolean[] dArr = new boolean[15];
        int[] book = new int[15];
        boolean[] res = new boolean[11];

        for (int i = 0; i < n; i++) {
            String cur = strings[i];
            int num = 0;
            if (cur.charAt(1) == 'A') {
                num = 14;
            } else if (cur.charAt(1) == 'J') {
                num = 11;
            } else if (cur.charAt(1) == 'Q') {
                num = 12;
            } else if (cur.charAt(1) == 'K') {
                num = 13;
            } else {
                String temp = cur.substring(1);
                num = Integer.parseInt(temp);
            }
            book[num] = book[num] + 1;
            if (cur.charAt(0) == 'S') {
                Arr[0][num] = true;
            } else if (cur.charAt(0) == 'H') {
                Arr[1][num] = true;
            } else if (cur.charAt(0) == 'C') {
                Arr[2][num] = true;
            } else if (cur.charAt(0) == 'D') {
                Arr[3][num] = true;
            }
        }
        //看看是不是皇家同花顺
        for (int i = 0; i < 4; i++) {
            //A存在
            if (Arr[i][14] == true) {
                for (int j = 14; j >= 2; j--) {
                    //看是不是顺子
                    if (Arr[i][j] == true) {
                        continue;
                    } else {//连不上了
                        if (j <= 9) {//如果超过5个了，就是皇家同花顺
                            res[1] = true;
                        }
                    }
                }
            }
        }
        //看看是不是同花顺
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 11; j++) {
                int count = 0;
                for (int k = j; k < j + 5; k++) {
                    if (book[k] > 0) {
                        count++;
                    } else {
                        break;
                    }
                }
                if (count == 5) {
                    res[2] = true;
                }
            }
        }
        //看是不是顺子
        if (n == 5) {
            for (int i = 0; i < 11; i++) {
                int count = 0;
                for (int k = i; k < i + 5; k++) {
                    if (book[k] > 0) {
                        count++;
                    } else {
                        break;
                    }
                }
                if (count == 5) {
                    res[6] = true;
                }
            }
        }
        //看是不是四条
        for (int i = 0; i < 15; i++) {
            if (book[i] == 4) {
                res[3] = true;
            }
        }
        //看是不是葫芦
        if (n == 5) {
            boolean temp1 = false;
            boolean temp2 = false;
            for (int i = 0; i < 15; i++) {
                if (book[i] == 3) {
                    temp1 = true;
                }
                if (book[i] == 2) {
                    temp2 = true;
                }
            }
            if (temp1 && temp2) {
                res[4] = true;
            }
        }
        //看是不是同花
        if (n == 5) {
            for (int i = 0; i < 4; i++) {
                int count = 0;
                for (int j = 0; j < 15; j++) {
                    if (Arr[i][j] == true) {
                        count++;
                    }
                }
                if (count == 5) {
                    res[5] = true;
                }
            }
        }
        //看看是不是三条
        if (n == 5) {
            boolean temp1 = false;
            boolean temp2 = false;
            for (int i = 0; i < 15; i++) {
                if (book[i] == 3) {
                    temp1 = true;
                }
                if (book[i] == 1) {
                    temp2 = true;
                }
            }
            if (temp1 && temp2) {
                res[7] = true;
            }
        }
        //看看是不是两对
        int count = 0;
        for (int i = 0; i < 15; i++) {
            if (book[i] == 2) {
                count++;
            }
        }
        if (count == 2) {
            res[8] = true;
        }
        //看看是不是一对
        if (count == 1) {
            res[9] = true;
        }
        //高牌
        res[10] = true;
        int i = 0;
        for (i = 1; i <= 10; i++) {
            if (res[i] == true) {
                break;
            }
        }
        String[] dict = {"","HuangJiaTongHuaShun","TongHuaShun","SiTiao","HuLu","TongHua","ShunZi","SanTiao","LiangDui","YiDui","GaoPai"};
        System.out.println(dict[i]);
    }
}
