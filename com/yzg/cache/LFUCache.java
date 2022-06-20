package com.yzg.cache;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;

import static com.yzg.javabasc.thread.CurrentThreadDemo.a;

public class LFUCache {

    //key = 键， value = 值
    private final HashMap<Integer, Integer> keyToValueMap;
    //key = 键， value = 使用次数
    private final HashMap<Integer, Integer> keyToFreqMap;
    //key = 使用次数， value = 键的列表
    private final HashMap<Integer, LinkedHashSet<Integer>> freqToKeysMap;

    private final int capacity;
    //当前最小使用次数
    private int min = 1;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        keyToValueMap = new HashMap<>(capacity);
        keyToFreqMap = new HashMap<>(capacity);
        freqToKeysMap = new HashMap<>(capacity);
    }

    public int get(int key) {
        Integer value = keyToValueMap.get(key);
        if (value == null) {
            return -1;
        }
        incrementKey(key);

        return value;
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        //key 已经存在
        if (keyToValueMap.containsKey(key)) {
            //更新key的value
            keyToValueMap.put(key, value);
            //更新key的使用次数
            incrementKey(key);
        } else {
            if (keyToValueMap.size() >= capacity) {
                //容量达到上限,删除使用次数最少的key
                LinkedHashSet<Integer> keys = freqToKeysMap.get(min);
                //删除第一个最久未使用的key
                Integer removeKey = keys.iterator().next();
                keys.remove(removeKey);
                keyToValueMap.remove(removeKey);
                keyToFreqMap.remove(removeKey);
                if (keys.isEmpty()) {
                    freqToKeysMap.remove(min);
                }
            }
            //添加新的key
            keyToValueMap.put(key, value);
            //新的key使用次数为 1
            keyToFreqMap.put(key, 1);
            freqToKeysMap.computeIfAbsent(1, k -> new LinkedHashSet<>())
                    .add(key);

            min = 1;
        }

    }

    /**
     * key 的使用次数 + 1
     * @param key
     */
    private void incrementKey(int key) {
        //key 使用次数 + 1
        Integer freq = keyToFreqMap.get(key);
        keyToFreqMap.put(key, freq + 1);
        //从当前使用次数中移除key
        LinkedHashSet<Integer> keys = freqToKeysMap.get(freq);
        keys.remove(key);
        if (keys.isEmpty()) {
            freqToKeysMap.remove(freq);
            //最小使用次数+1
            if (min == freq) {
                min++;
            }
        }
        //key 添加到 +1 后的使用次数中
        freqToKeysMap.computeIfAbsent(freq + 1, k -> new LinkedHashSet<>())
                .add(key);

    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        int i1 = cache.get(1);
        cache.put(3,3);
        cache.get(2);

        cache.get(3);
        cache.put(4, 4);
        cache.get(1);
        cache.get(3);
        cache.get(4);

    }
}
