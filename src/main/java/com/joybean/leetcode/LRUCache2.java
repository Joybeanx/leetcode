package com.joybean.leetcode;

import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * <a href="https://leetcode.com/problems/lru-cache/">LRU Cache</a>
 *
 * @author Joybean
 */
public class LRUCache2 {
    private final LinkedHashMap<Integer, Integer> cacheHolder;
    private int capacity;


    /**
     * LinkedHashMap solution
     *
     * @param capacity
     */
    public LRUCache2(int capacity) {
        this.cacheHolder = new LinkedHashMap(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (cacheHolder.containsKey(key)) {
            int val = cacheHolder.remove(key);
            cacheHolder.put(key, val);
            return val;
        }
        return -1;
    }

    public void put(int key, int value) {
        //remove item if it exists
        if (cacheHolder.containsKey(key)) {
            cacheHolder.remove(key);
        }
        if (cacheHolder.size() == capacity) {
            Iterator iterator = cacheHolder.entrySet().iterator();
            //move cursor to next before remove item
            iterator.next();
            iterator.remove();
        }
        cacheHolder.put(key, value);
    }

}
