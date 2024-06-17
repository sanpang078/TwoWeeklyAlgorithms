package org.sanpang.leetcode.hot;

public class LC160 {
    /*https://leetcode.cn/problems/intersection-of-two-linked-lists/?envType=study-plan-v2&envId=top-100-liked
    给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
    进阶：你能否设计一个时间复杂度 O(m + n) 、仅用 O(1) 内存的解决方案？
    * */

    public static void main(String[] args) {
        System.out.println(null == null);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if ( headA == null || headB == null) return null;
        ListNode pA = headA;
        ListNode pB = headB;
        while ( pA != pB ) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

}
class ListNode {
     int val;
     ListNode next;

     ListNode(int x) {
         val = x;
         next = null;
     }
 }