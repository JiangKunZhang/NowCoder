package 合并两个排序的链表;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/10 21:43
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        //定义一个虚拟头节点，不动
        ListNode newHead = new ListNode(-1);
        //往后动，相当于尾巴
        ListNode temp = newHead;
        //都不为空就进入循环，插进去
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                temp = temp.next;
                list1 = list1.next;
            }else {
                temp.next = list2;
                temp = temp.next;
                list2 = list2.next;
            }
        }
        //如果list1空了，把list2剩下的插进来
        if (list1 == null) {
            temp.next = list2;
        }
        //如果list2空了，把list1剩下的插进来
        if (list2 == null) {
            temp.next = list1;
        }
        //返回虚拟节点的下一个节点
        return newHead.next;
    }
}