package 分割链表;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/4/28 17:07
 *
 * 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
 *
 * 给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针。注意：分割以后保持原来的数据顺序不变。
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Partition {
    public ListNode partition(ListNode pHead, int x) {
        // write code here
        //定义两个线段
        ListNode bs = null;
        ListNode be = null;
        ListNode as = null;
        ListNode ae = null;
        ListNode cur = pHead;//cur遍历整个链表
        while (cur != null) {
            //小于的放在before
            if (cur.val < x) {
                //第一次插
                if (bs == null) {
                    bs = cur;
                    be = cur;
                }else {
                    be.next = cur;
                    be = be.next;
                }
            }else {//否则就在after
                //第一次插
                if (as == null) {
                    as = cur;
                    ae = cur;
                }else {
                    ae.next = cur;
                    ae = ae.next;
                }
            }
            cur = cur.next;
        }
        //before里面没有东西，全在after
        if (bs == null) {
            //也不用把ae.next置为null
            return as;
        }else {
            //否则进行拼接
            be.next = as;
            //如果after里面有东西，即as != null,把ae.next置为null
            if (as != null) {
                ae.next = null;
            }
            //返回拼接后的
            return bs;
        }
    }
}
