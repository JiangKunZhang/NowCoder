package BFSn叉树的遍历;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/10 12:56
 */

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            //获取当前层元素个数，即整个队列元素
            int size = queue.size();
            //临时存放每一层的元素
            List<Integer> temp = new ArrayList<>();
            while (size-- != 0) {
                Node node = queue.poll();
                temp.add(node.val);
                //孩子入队
                for (Node nextNode : node.children) {
                    if (nextNode != null) {
                        queue.offer(nextNode);
                    }
                }
            }
            //新层有元素,则放入res
            if (temp.size() > 0) {
                res.add(temp);
            }
        }
        return res;
    }
}
