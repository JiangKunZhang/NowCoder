package 删除链表中重复的结点;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/4/27 17:32
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public ListNode deleteDuplication(ListNode pHead)
    {
        ListNode newHead = new ListNode(-1);//定义虚拟节点
        ListNode temp = newHead;//保存尾部
        ListNode cur = pHead;
        //遍历完整个链表
        while (cur != null) {
            //如果重复
            if (cur.next != null &&(cur.val == cur.next.val)) {
                //如果连续重复
                while (cur.next != null &&(cur.val == cur.next.val)) {
                    cur = cur.next;
                }
                //把重复的节点也删掉，重复的节点不保留
                cur = cur.next;//多走一步
            }else {//否则不重复就往temp后面插
                temp.next = cur;
                temp = cur;
                cur = cur.next;
            }
        }
        //手动把最后的尾巴置为空
        temp.next = null;
        //返回头节点
        return newHead.next;
    }
}