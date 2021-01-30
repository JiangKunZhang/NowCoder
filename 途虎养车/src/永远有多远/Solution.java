package 永远有多远;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/10/8 19:11
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param y1 int整型 当前日期的年
     * @param m1 int整型 当前日期的月
     * @param d1 int整型 当前日期的日
     * @param y2 int整型 项目截止日期的年
     * @param m2 int整型 项目截止日期的月
     * @param d2 int整型 项目截止日期的日
     * @return int整型
     */
    public static int workdays_between (int y1, int m1, int d1, int y2, int m2, int d2) {
        // write code here
        int[] month = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int sum = 0;
        int days = 0;
        int res = 0;
        if (y1 <= y2 && m1 <= m2 && d1 <= d2) {
            for (int i = 1; i <= y1; i++) {
                if (isLeapYear(i)) {
                    days += 366;
                } else {
                    days += 365;
                }
            }
            if (m1 +1 <= 12) {
                for (int i = m1 + 1; i <= 12; i++) {
                    if (isLeapYear(y1) && i == 2) {
                        days -= 29;
                    } else {
                        days -= month[i];
                    }
                }
            }
            for (int i = d1; i <= month[m1]; i++) {
                days--;
            }
            int count = days % 7;
            int x = count + 1;

            int front = 0;
            for (int i = 1; i <= m1 - 1; i++) {
                if (isLeapYear(y1) && i == 2) {
                    front += 29;
                } else {
                    front += month[i];
                }
            }
            front += d1;

            int rear = 0;
            for (int i = m2 + 1; i <= 12; i++) {
                if (isLeapYear(y2) && i == 2) {
                    rear += 29;
                } else {
                    rear += month[i];
                }
            }
            if (m2 == 2) {
                rear += 29 - d2;
            } else {
                rear += month[m2] - d2;
            }

            for (int i = y1; i <= y2; i++) {
                if (isLeapYear(i)) {
                    sum += 366;
                } else {
                    sum += 365;
                }
            }
            sum = sum - front;
            sum = sum - rear;
            int temp = sum % 7;
            res = 0;
            for (int i = x; i < x + sum; i++) {
                if (i % 7 <= 5 && i % 7 != 0) {
                    res++;
                }
            }
            System.out.println(res);
        } else {
            for (int i = 1; i <= y2; i++) {
                if (isLeapYear(i)) {
                    days += 366;
                } else {
                    days += 365;
                }
            }
            if (m2 +1 <= 12) {
                for (int i = m2 + 1; i <= 12; i++) {
                    if (isLeapYear(y2) && i == 2) {
                        days -= 29;
                    } else {
                        days -= month[i];
                    }
                }
            }
            for (int i = d2; i <= month[m2]; i++) {
                days--;
            }
        }
        int count = days % 7;
        int x = count + 1;


        int front = 0;
        for (int i = 1; i <= m2 - 1; i++) {
            if (isLeapYear(y2) && i == 2) {
                front += 29;
            } else {
                front += month[i];
            }
        }
        front += d2;

        int rear = 0;
        for (int i = m1 + 1; i <= 12; i++) {
            if (isLeapYear(y1) && i == 2) {
                rear += 29;
            } else {
                rear += month[i];
            }
        }
        if (m1 == 2) {
            rear += 29 - d1;
        } else {
            rear += month[m1] - d1;
        }

        for (int i = y2; i <= y1; i++) {
            if (isLeapYear(i)) {
                sum += 366;
            } else {
                sum += 365;
            }
        }
        sum = sum - front;
        sum = sum - rear;
        int temp = sum % 7;
        res = 0;
        for (int i = x; i < x + sum; i++) {
            if (i % 7 <= 5 && i % 7 != 0) {
                res++;
            }
        }
        System.out.println(res);


        return res;
    }

    public static boolean isLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        workdays_between(2020,9,25,2020,9,28);
    }
}
