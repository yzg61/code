package com.yzg.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * lru 最近最少使用 缓存实现
 */
public class LRUCache {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,2);
        cache.put(2,3);
        System.out.println(cache.get(1));
        cache.put(3,4);
        System.out.println(cache.get(2));

    }
    private final Map<Integer, Node<Integer, Integer>> map;
    int capacity;
    private Node<Integer, Integer> head;
    private Node<Integer, Integer> tail;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
    }

    public Integer get(int key) {

        Node<Integer, Integer> node = map.get(key);
        if (node == null) {
            return -1;
        } else {
            unlink(node);
            linkNodeTail(node);

            return node.value;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node<Integer, Integer> node = map.get(key);
            unlink(node);
        } else if (map.size() == capacity) {
            //容量上限
            Node<Integer, Integer> h = head;
            Integer removeKey = h.key;
            unlink(h);
            map.remove(removeKey);
        }
        Node<Integer, Integer> node = new Node<>(key, value);
        linkNodeTail(node);

        map.put(key, node);

    }

    private void linkNodeTail(Node<Integer, Integer> node) {
        if (tail == null) {
            tail = node;
            head = node;
        } else {
            Node<Integer, Integer> last = tail;
            node.pre = last;
            last.next = node;
        }
        tail = node;
    }

    /**
     * 把节点从链表中断开
     *
     * @param node
     */
    private void unlink(Node<Integer, Integer> node) {
        Node<Integer, Integer> pre = node.pre;
        Node<Integer, Integer> next = node.next;
        node.pre = null;
        node.next = null;
        if (pre == null) {
            //头节点
            head = next;
        } else {
            pre.next = next;
        }
        if (next == null) {
            //尾节点
            tail = pre;
        } else {
            next.pre = pre;
        }
    }

    class Node<K, V> {

        private K key;
        private V value;
        private Node<K, V> next;
        private Node<K, V> pre;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
