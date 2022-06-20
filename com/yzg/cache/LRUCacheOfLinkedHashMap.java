package com.yzg.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * lru 最近最少使用 缓存实现
 */
public class LRUCacheOfLinkedHashMap {

    private final Map<Integer, Integer> map;

    public LRUCacheOfLinkedHashMap(int capacity) {
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    public Integer get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }
}
