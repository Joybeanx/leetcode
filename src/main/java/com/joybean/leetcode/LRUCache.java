package com.joybean.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/lru-cache/description/">LRU Cache</a>
 *
 * @author Joybean
 */
public class LRUCache {
    private final LinkedHashMap<Integer, Integer> cacheHolder;

    static class LRULinkedHashMap extends LinkedHashMap<Integer, Integer> {
        private int capacity;

        public LRULinkedHashMap(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }
        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return this.size() > capacity;
        }
    }

    public LRUCache(int capacity) {
        cacheHolder = new LRULinkedHashMap(capacity);
    }

    public int get(int key) {
        //Use getOrDefault instead of if clause
        return cacheHolder.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cacheHolder.put(key, value);
    }
}
