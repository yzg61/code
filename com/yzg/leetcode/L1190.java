package com.yzg.leetcode;

import java.util.List;
import java.util.Stack;

public class L1190 {
    /**
     * 1190. 反转每对括号间的子串
     * 给出一个字符串 s（仅含有小写英文字母和括号）。
     *
     * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
     *
     * 注意，您的结果中 不应 包含任何括号。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "(abcd)"
     * 输出："dcba"
     * 示例 2：
     *
     * 输入：s = "(u(love)i)"
     * 输出："iloveu"
     * 示例 3：
     *
     * 输入：s = "(abc(cd(ef)g)hi)k"
     * '' ih g fe dc cba k
     * '' ih cd ef g cba k
     * '' ih cd fe g cba k
     *
     *
     * "" ab cd
     * ef g hi ""
     * "" ih cd fe g ba
     * s = "(ed(et(oc))el)"
     * “” <-   ed et
     * oc a el      ->""
     * le a et co de
     * 输出："leetacode"
     * 示例 4：
     *
     * 输入：s = "a(bcdefghijkl(mno)p)q"
     * a <- bcdefghijkl
     * mno p -> q
     * 输出："a p mno lkjihgfedcb q"
     */

    public String reverseParentheses(String s) {

        return null;
    }
}
