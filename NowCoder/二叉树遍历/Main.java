package 二叉树遍历;

import java.util.Scanner;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/19 17:42
 */
class Node {
    public char val;
    public Node left;
    public Node right;
    public Node(char val) {
        this.val = val;
    }
}
public class Main {

    public static int i;
    public static Node buildTree(String str) {
        Node root = null;
        if (str.charAt(i) != '#') {
            root = new Node(str.charAt(i));
            i++;
            root.left = buildTree(str);
            root.right = buildTree(str);
        }else {
            i++;
        }
        return root;
    }

    public static void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.val + " ");
        inOrderTraversal(root.right);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        Node root = buildTree(string);
        inOrderTraversal(root);
    }
}
