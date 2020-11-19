package com.yzg.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapSum {
    /**
     * 677. 键值映射
     * 实现一个 MapSum 类，支持两个方法，insert 和 sum：
     *
     * MapSum() 初始化 MapSum 对象
     * void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 key 已经存在，那么原来的键值对将被替代成新的键值对。
     * int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。
     *
     *
     * 示例：
     *
     * 输入：
     * ["MapSum", "insert", "sum", "insert", "sum"]
     * [[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
     * 输出：
     * [null, null, 3, null, 5]
     *
     * 解释：
     * MapSum mapSum = new MapSum();
     * mapSum.insert("apple", 3);
     * mapSum.sum("ap");           // return 3 (apple = 3)
     * mapSum.insert("app", 2);
     * mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
     *
     *
     * 提示：
     *
     * 1 <= key.length, prefix.length <= 50
     * key 和 prefix 仅由小写英文字母组成
     * 1 <= val <= 1000
     * 最多调用 50 次 insert 和 sum
     */

    private final Node root;
    /** Initialize your data structure here. */
    public MapSum() {
        root = new Node();
    }

    public void insert(String key, int val) {
        Node head = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (head.getNodes().get(c) == null) {
                head.getNodes().put(c, new Node());
            }
            head = head.getNodes().get(c);
        }
        head.setNum(val);
    }

    public int sum(String prefix) {
        Node head = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            Node node = head.getNodes().get(c);
            if (node == null) {
                return 0;
            } else {
                head = node;
            }
        }

        return sumByNode(head, 0);
    }

    private int sumByNode(Node head, int sum) {
        if (head != null) {
            sum += head.getNum();
            HashMap<Character, Node> nodes = head.getNodes();
            Set<Map.Entry<Character, Node>> entries = nodes.entrySet();
            for (Map.Entry<Character, Node> entry : entries) {
               sum = sumByNode(entry.getValue(), sum);
            }
        }
        return sum;
    }

    /**
     * 前缀树节点
     */
    static class Node {
        private HashMap<Character, Node> nodes;

        private int num;

        public HashMap<Character, Node> getNodes() {
            return nodes;
        }

        public void setNodes(HashMap<Character, Node> nodes) {
            this.nodes = nodes;
        }

        public Integer getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public Node(int num) {
            this.nodes = new HashMap<>(32);
            this.num = num;
        }

        public Node() {
            this.nodes = new HashMap<>(32);
        }
    }

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("aa", 3);
        int ap1 = mapSum.sum("a");
        System.out.println(ap1);
        mapSum.insert("ab", 2);
        int ap = mapSum.sum("a");
        System.out.println(ap);
    }
}
