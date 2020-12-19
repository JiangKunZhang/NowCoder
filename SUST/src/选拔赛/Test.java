package 选拔赛;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/9/21 16:59
 */

class Animal {
    String type;
    String color;
}

class Person extends Animal {
    int age;
    String sex;
}

class Student extends Person {
    int grade;
    int id;
}

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int width = n * 2 - 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < width - i; j++) {
                if (j < n - 1) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < width - 1; j++) {
                if (j > n - 1 || j < n - i -1) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}
