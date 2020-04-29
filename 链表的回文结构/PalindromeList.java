package 链表的回文结构;
import java.util.*;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/4/27 17:01
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class PalindromeList {
    public boolean chkPalindrome(ListNode A) {
        // write code here
        //如果链表为空那么不是回文
        if (A == null) {
            return false;
        }
        //如果只有一个节点那么就是回文
        if (A.next == null) {
            return true;
        }

        //找到中间节点slow
        ListNode fast = A;
        ListNode slow = A;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //从slow开始进行反转链表
        ListNode cur = slow.next;
        while (cur != null) {
            ListNode curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }

        //从前往后，从后往前走，中间没return就说明都相等
        while (slow != A) {
            //不相等return false
            if (slow.val != A.val) {
                return false;
            }
            //判断偶数情况
            if (A.next == slow) {
                return true;
            }
            //slow往前走，A往后走
            slow =slow.next;
            A = A.next;
        }
        return true;
    }
}
