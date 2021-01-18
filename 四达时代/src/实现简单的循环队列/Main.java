package 实现简单的循环队列;

import java.util.Scanner;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/9/19 19:35
 */
public class Main {
    public String[] elem;
    public int front;
    public int rear;

    public Main(int k) {
        this.elem = new String[k];
        this.front = 0;
        this.rear = 0;

    }

    public boolean enQueue(String value) {
        if (isFull()) {
            return false;
        }
        this.elem[rear] = value;
        this.rear = (this.rear + 1) % this.elem.length;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        this.front = (this.front + 1) % this.elem.length;
        return true;
    }

    public String Front() {
        if (isEmpty()) {
            return null;
        }
        return this.elem[front];
    }

    public String Rear() {
        if (isEmpty()) {
            return null;
        }
        int rear = this.rear == 0 ? this.elem.length - 1 : this.rear - 1;
        return this.elem[rear];
    }

    public boolean isEmpty() {
        if (this.front == this.rear) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if ((this.rear + 1) % this.elem.length == this.front) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int inErr = 0;
        int outErr = 0;
        Main queue = new Main(n);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String[] strings = s.split(" ");
            if (strings[0].equals("P")) {
                if (!queue.enQueue(strings[1])) {
                    inErr++;
                }
            } else if (strings[0].equals("D")) {
                if (!queue.deQueue()) {
                    outErr++;
                }
            } else if (strings[0].equals("END")) {
                break;
            }
        }
        System.out.println(inErr);
        System.out.println(outErr);
        if (queue.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            while (!queue.isEmpty()) {
                System.out.print(queue.Front());
                queue.deQueue();
            }
            System.out.println();
        }
        sc.close();
    }
}
