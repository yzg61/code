package com.yzg.leetcode;

import java.util.List;

public class L148_SortList {
    /**
     * <a>https://leetcode-cn.com/problems/sort-list/<a/>
     * 148. Sort List
     * Given the head of a linked list, return the list after sorting it in ascending order.
     * <p>
     * Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * <p>
     * Input: head = [4,2,1,3]
     * Output: [1,2,3,4]
     * Example 2:
     * <p>
     * <p>
     * Input: head = [-1,5,3,4,0]
     * Output: [-1,0,3,4,5]
     * Example 3:
     * <p>
     * Input: head = []
     * Output: []
     * <p>
     * <p>
     * Constraints:
     * <p>
     * The number of nodes in the list is in the range [0, 5 * 104].
     * -105 <= Node.val <= 105
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode sortList(ListNode head) {
        int len = 0;
        ListNode h = head;
        while (h != null) {
            h = h.next;
            len++;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;
        for (int intv = 1; intv < len; intv = intv * 2) {
            ListNode tail = dummy;
            ListNode cur = dummy.next;
            while (cur != null) {
                ListNode h1 = cur;
                ListNode h2 = cut(h1, intv);
                cur = cut(h2, intv);
                tail.next = merge(h1, h2);
                while (tail.next != null) {
                    tail = tail.next;
                }
            }

        }
        ListNode m = dummy.next;
        dummy = null;
        return m;
    }

    /**
     * 切断链表的前n个节点，返回新的头节点
     * @param head 原头节点
     * @param n 切断节点数量
     * @return
     */
    public static ListNode cut(ListNode head, int n) {
        while (n-- > 1 && head != null) {
            head = head.next;
        }
        if (head == null) {
            return null;
        }
        ListNode node = head.next;
        head.next = null;
        return node;
    }

    /**
     * 有序合并2个链表
     * @param n1
     * @param n2
     * @return
     */
    public static ListNode merge(ListNode n1, ListNode n2) {
        //虚拟头节点
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        while (n1 != null && n2 != null) {
            //遍历2个链表，把小的值接在虚拟头节的后面
            if (n1.val < n2.val) {
                head.next = n1;
                n1 = n1.next;
            } else {
                head.next = n2;
                n2 = n2.next;
            }
            head = head.next;
        }
        //把剩下的链表接上
        head.next = (n1 != null) ? n1 : n2;
        //返回虚拟头节点的下一个节点作为合并后的链表头
        ListNode m = dummy.next;
        dummy = null;
        return m;
    }


    public static void main(String[] args) {
        ListNode node = new ListNode(3, new ListNode(2,new ListNode(4,new ListNode(1))));
        L148_SortList main = new L148_SortList();
        ListNode head = main.sortList(node);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
