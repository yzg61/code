package com.yzg.leetcode;

public class L83 {


    /**
     * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
     * <p>
     * 返回同样按升序排列的结果链表。
     */

    public ListNode deleteDuplicates(ListNode head) {
        if (head != null && head.next != null) {
            int current = head.val;
            ListNode node = head;
            while (node.next != null) {
                if (node.next.val == current) {
                    node.next = node.next.next;
                } else {
                    node = node.next;
                    current = node.val;
                }
            }
        }

        return head;
    }

}
