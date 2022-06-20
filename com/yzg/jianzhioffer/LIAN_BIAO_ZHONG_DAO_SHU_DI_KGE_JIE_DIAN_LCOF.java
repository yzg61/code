package com.yzg.jianzhioffer;

import com.yzg.leetcode.ListNode;

public class LIAN_BIAO_ZHONG_DAO_SHU_DI_KGE_JIE_DIAN_LCOF {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode first = head;
        while (first.next != null && k > 1) {
            first = first.next;
            k--;
        }
        while (first.next != null) {
            first = first.next;
            head = head.next;
        }

        return head;
    }

}
