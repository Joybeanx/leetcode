package com.joybean.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/lru-cache/">LRU Cache</a>
 *
 * @author Joybean
 */
public class LRUCache3 {
    private final LinkedHashMap<Integer, Integer> cacheHolder;


    /**
     * LinkedHashMap solution
     *
     * @param capacity
     */
    public LRUCache3(int capacity) {
        cacheHolder = new LRULinkedHashMap(capacity);
    }

    public int get(int key) {
        return cacheHolder.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cacheHolder.put(key, value);
    }


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

}
