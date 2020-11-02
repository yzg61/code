package com.yzg.leetcode;

import java.util.ArrayList;
import java.util.List;

public class L830 {
    /**
     * 在一个由小写字母构成的字符串 S 中，包含由一些连续的相同字符所构成的分组。
     *
     * 例如，在字符串 S = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
     *
     * 我们称所有包含大于或等于三个连续字符的分组为较大分组。找到每一个较大分组的起始和终止位置。
     *
     * 最终结果按照字典顺序输出。
     *
     * 示例 1:
     *
     * 输入: "abbxxxxzzy"
     * 输出: [[3,6]]
     * 解释: "xxxx" 是一个起始于 3 且终止于 6 的较大分组。
     * 示例 2:
     *
     * 输入: "abc"
     * 输出: []
     * 解释: "a","b" 和 "c" 均不是符合要求的较大分组。
     * 示例 3:
     *
     * 输入: "abcdddeeeeaabbbcd"
     * 输出: [[3,5],[6,9],[12,14]]
     * 说明:  1 <= S.length <= 1000
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/positions-of-large-groups
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> list = new ArrayList<>();
        if (s.length() > 2) {
            char[] chars = s.toCharArray();
            char t = chars[0];
            int l = 0;
            for (int i = 1; i < chars.length; i++) {
                if (chars[i] == t) {
                    //相同的字符
                    l++;
                } else {
                    //不相同的字符，长度大于等于3位
                    if (l > 1) {
                        List<Integer> ints = new ArrayList<>();
                        ints.add(i - 1 - l);
                        ints.add(i - 1);
                        list.add(ints);
                    }
                    l = 0;
                }
                t = chars[i];
            }
            if (l > 1) {
                List<Integer> ints = new ArrayList<>();
                ints.add(chars.length - 1 - l);
                ints.add(chars.length - 1);
                list.add(ints);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String s = "aaaaasdassssdddddeesssfffwww";
        L830 main = new L830();
        List<List<Integer>> lists = main.largeGroupPositions(s);
        System.out.println(lists);
    }
}
