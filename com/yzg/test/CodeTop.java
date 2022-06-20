package com.yzg.test;


import com.yzg.test.exp.ListNode;

import java.util.HashSet;
import java.util.Set;

public class CodeTop {

    /**
     * 206. 反转链表
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     *
     *
     * 示例 1：
     * 输入：head = [1,2,3,4,5]
     * 输出：[5,4,3,2,1]
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        //当前节点的上一个节点
        ListNode pre = null;

        while (head != null) {
            //下一个节点
            ListNode next = head.next;
            //断开当前节点，连接到上一个节点
            head.next = pre;
            //当前节点成为新的上一个节点
            pre = head;
            //下一个节点成为当前节点
            head = next;
        }

        return pre;
    }

    /**
     * 3. 无重复字符的最长子串
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     *
     *
     * 示例 1:
     *
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     *
     *
     * 提示：
     *
     * 0 <= s.length <= 5 * 104
     * s 由英文字母、数字、符号和空格组成
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        Set<Character> set = new HashSet<>();
        int l = 0, r = 0;
        int res = 1;
        while (r < s.length()) {
            char c = s.charAt(r);
            if (set.contains(c)) {
                //出现重复字符，记录最大字符串长度
                res = Math.max(res , r - l);
                //移动l 到重复字符的下一个字符
                while (s.charAt(l) != c) {
                    //从set中移除路过的字符
                    set.remove(s.charAt(l));
                    l++;
                }
                l++;
            }else {
                set.add(c);
            }

            r++;
        }
        //
        res = Math.max(res , r - l);

        return res;
    }


}
