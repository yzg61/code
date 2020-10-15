package com.yzg.jianzhioffer;

import com.yzg.test.Main;

import java.util.*;

/**
 * 题目描述
 * 设计LRU缓存结构，该结构在构造时确定大小，假设大小为K，并有如下两个功能
 * set(key, value)：将记录(key, value)插入该结构
 * get(key)：返回key对应的value值
 * [要求]
 * set和get方法的时间复杂度为O(1)
 * 某个key的set或get操作一旦发生，认为这个key的记录成了最常使用的。
 * 当缓存的大小超过K时，移除最不经常使用的记录，即set或get最久远的。
 * 若opt=1，接下来两个整数x, y，表示set(x, y)
 * 若opt=2，接下来一个整数x，表示get(x)，若x未出现过或已被移除，则返回-1
 * 对于每个操作2，输出一个答案
 */
public class 设计LRU缓存结构 {

    /**
     * 缓存最大大小
     */
    public int K = 0;

    /**
     * 缓存
     */
    public LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();


    /**
     * lru design
     * @param operators int整型二维数组 the ops
     * @param k int整型 the k
     * @return int整型一维数组
     */
    public int[] LRU (int[][] operators, int k) {
        // write code here
        //输出结果集合
        List<Integer> res = new ArrayList<>();
        K = k;
        for (int[] operator : operators) {
            if (operator[0] == 1) {
                int key = operator[1];
                int value = operator[2];
                set(key, value);
            } else {
                int key = operator[1];
                res.add(get(key));
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public void set(int key, int value) {

        if (K != 0 &&  K == cache.size()) {
            //移除最不经常使用的key = LinkedHashMap链表头节点
            Set<Integer> integers = cache.keySet();
            Iterator<Integer> iterator = integers.iterator();
            cache.remove(iterator.next());
        }
        cache.put(key, value);
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        //先移除指定节点
        Integer value = cache.remove(key);
        //添加到末尾
        cache.put(key, value);

        return value;
    }

    public static void main(String[] args) {
        设计LRU缓存结构 main = new 设计LRU缓存结构();
        int[][] a = {{1,2,3},{2,2}};
        int[] lru = main.LRU(a, 0);
        for (int i : lru) {
            System.out.println(i);
        }
    }
}
