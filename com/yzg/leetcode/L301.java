package com.yzg.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class L301 {
    /**
     * 301. 删除无效的括号
     * 删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。
     * <p>
     * 说明: 输入可能包含了除 ( 和 ) 以外的字符。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "()())()"
     * 输出: ["()()()", "(())()"]
     * 示例 2:
     * <p>
     * 输入: "(a)())()"
     * 输出: ["(a)()()", "(a())()"]
     * 示例 3:
     * <p>
     * 输入: ")("
     * 输出: [""]
     */
    private int leastCount = 0;
    private Set<String> res = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {

        StringBuilder sb = new StringBuilder(s);
        leastCount = sb.length();
        int i = 0;
        find(sb, 0,0,0,0);
        return new ArrayList<>(res);
    }

    public void find(StringBuilder s, int index, int leftCount,
                     int rightCount, int removeCount) {
        if (removeCount > leastCount) {
            return;
        }
        if (rightCount > leftCount) {
            return;
        }
        if (index < s.length() && index >= 0) {
            if (s.charAt(index) != '(' && s.charAt(index) != ')') {
                //跳过
                find(s, ++index, leftCount, rightCount, removeCount);
            } else if (s.charAt(index) == '(' || s.charAt(index) == ')') {
                StringBuilder s2 = new StringBuilder(s.toString());
                //删除
                find(s.deleteCharAt(index), index, leftCount, rightCount, removeCount+1);
                //保留
                if (s2.charAt(index) == '(') {
                    leftCount++;
                }
                if (s2.charAt(index) == ')') {
                    rightCount++;
                }
                find(s2, index + 1, leftCount, rightCount, removeCount);
            }
        } else {
            //判断字符串是否符合
            if (check(s, leftCount, rightCount)) {
                if (removeCount < leastCount) {
                    leastCount = removeCount;
                    //出现新的最小删除数，替换并清空原有结果集
                    res.clear();
                }
                res.add(String.valueOf(s));
            }
        }
    }

    private boolean check(StringBuilder s, int leftCount, int rightCount) {
        return leftCount == rightCount;
    }

    public static StringBuilder removeIndex(StringBuilder s, int index) {
        if (index < 0 || index > s.length() - 1) {
            return s;
        } else {
            return s.delete(index, index + 1);
        }
    }


    public static void main(String[] args) {
        L301 main = new L301();
        List<String> strings = main.removeInvalidParentheses(")(");
        System.out.println(strings);
    }
}
