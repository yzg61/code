package com.yzg.leetcode;

public class L1290 {
    /**
     * 1290. 二进制链表转整数
     * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
     * <p>
     * 请你返回该链表所表示数字的 十进制值 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：head = [1,0,1]
     * 输出：5
     * 解释：二进制数 (101) 转化为十进制数 (5)
     * 示例 2：
     * <p>
     * 输入：head = [0]
     * 输出：0
     */
    public int getDecimalValue(ListNode head) {

        int res = head.val;
        while (head.next != null) {
            head = head.next;
            res = (res << 1) + head.val;

        }

        return res;
    }

    public static void main(String[] args) {
        L1290 main = new L1290();
        ListNode node = new ListNode(1);
        node.next = new ListNode(0);
        node.next.next = new ListNode(1);
        System.out.println(main.getDecimalValue(node));
    }
}
