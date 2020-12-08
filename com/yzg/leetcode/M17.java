package com.yzg.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class M17 {
    /**
     * 面试题 17.17. 多次搜索
     * 给定一个较长字符串big和一个包含较短字符串的数组smalls，设计一个方法，根据smalls中的每一个较短字符串，对big进行搜索。输出smalls中的字符串在big里出现的所有位置positions，其中positions[i]为smalls[i]出现的所有位置。
     *
     * 示例：
     *
     * 输入：
     * big = "mississippi"
     * smalls = ["is","ppi","hi","sis","i","ssippi"]
     * 输出： [[1,4],[8],[],[3],[1,4,7,10],[5]]
     * 提示：
     *
     * 0 <= len(big) <= 1000
     * 0 <= len(smalls[i]) <= 1000
     * smalls的总字符数不会超过 100000。
     * 你可以认为smalls中没有重复字符串。
     * 所有出现的字符均为英文小写字母。
     */
    public int[][] multiSearch(String big, String[] smalls) {
        Node root = new Node();
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        //smalls中的所有单词构成前缀树
        for (int i = 0; i < smalls.length; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            lists.add(list);
            int j = 0;
            Node node = root;
            for (;j < smalls[i].length(); j++) {
                char c = smalls[i].charAt(j);
                if (node.child.get(c) == null) {
                    Node cur = new Node();
                    node.child.put(c, cur);
                    node = cur;
                } else {
                    node = node.child.get(c);
                }
            }
            node.val = i;
            node.end = true;
        }
        //遍历big字符串中的字符，从前缀树中找到满足条件的节点
        for (int i = 0; i < big.length(); i++) {
            Node node = root;
            int j = i;
            char c;
            while (j < big.length() && node.child.get(c = big.charAt(j)) != null) {
                node = node.child.get(c);
                if (node.end) {
                    ArrayList<Integer> list = lists.get(node.val);
                    list.add(i);
                }
                j++;
            }
        }
        int[][] arrs = new int[lists.size()][];
        for (int i = 0; i < lists.size(); i++) {
            int[] arr = new int[lists.get(i).size()];
            for (int j = 0; j < lists.get(i).size(); j++) {
                arr[j] = lists.get(i).get(j);
            }
            arrs[i] = arr;
        }

        return arrs;
    }

    class Node {
        //end表示是否是smalls中某个字符串的最后一个字符
        boolean end = false;
        //当end = true，val表示当前节点是smalls[val]这个字符串的最后一个字符
        int val = -1;
        //child表示下一个字符
        HashMap<Character, Node> child = new HashMap<>(26);

    }

    public static void main(String[] args) {
        M17 main = new M17();
        int[][] mississippis = main.multiSearch("mississippi", new String[]{"is", "ppi", "hi", "sis", "i", "ssippi"});
        System.out.println(Arrays.deepToString(mississippis));
    }
}
