package com.yzg.leetcode;

public class RemoveDuplicatesFromSortedListIi {

    /**
     * 82. 删除排序链表中的重复元素 II
     * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
     * <p>
     * 返回同样按升序排列的结果链表。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：head = [1,2,3,3,4,4,5]
     * 输出：[1,2,5]
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode first = new ListNode();
        first.next = head;
        ListNode per = first;
        ListNode cur = first.next;
        while (cur != null) {
            cur = cur.next;
            if (cur != null && per.next.val == cur.val) {
                while (cur != null && per.next.val == cur.val) {
                    cur = cur.next;
                }
                per.next = cur;
            } else {
                per = per.next;
            }

        }

        return first.next;
    }
}
