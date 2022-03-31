package com.joybean.leetcode;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/lfu-cache/">LFU Cache</a>
 *
 * @author Joybean
 */
public class LFUCache {
    private Map<Integer, Integer> keyToValue = new HashMap<>();
    private Map<Integer, Integer> keyToFreq = new HashMap<>();
    private Map<Integer, LinkedHashSet<Integer>> freqToKeys = new HashMap<>();
    private int minFreq = 0;
    private int capacity;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    /**
     * <a href="https://github.com/model-nut/algo-leetcode-labuladong-2020/blob/master/labuladong-algo-202012/%E6%95%B0%E6%8D
     * %AE%E7%BB%93%E6%9E%84%E7%B3%BB%E5%88%97/LFU.md">from labuladong</a>
     *
     * @param key
     * @return
     */
    public int get1(int key) {
        if (!keyToValue.containsKey(key)) {
            return -1;
        }
        increaseFreq(key);
        return keyToValue.get(key);
    }

    public void put1(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (keyToValue.containsKey(key)) {
            increaseFreq(key);
        } else {
            if (keyToValue.size() == capacity) {
                removeLFUKey();
            }
            keyToFreq.put(key, 1);
            freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
            freqToKeys.get(1).add(key);
            minFreq = 1;
        }
        keyToValue.put(key, value);
    }

    private void removeLFUKey() {
        LinkedHashSet<Integer> minFreqKeys = freqToKeys.get(minFreq);
        int lfuKey = minFreqKeys.iterator().next();
        minFreqKeys.remove(lfuKey);
        if (minFreqKeys.isEmpty()) {
            freqToKeys.remove(minFreq);
        }
        keyToValue.remove(lfuKey);
    }

    private void increaseFreq(int key) {
        int freq = keyToFreq.get(key);
        LinkedHashSet<Integer> keys = freqToKeys.get(freq);
        keys.remove(key);
        if (keys.isEmpty()) {
            freqToKeys.remove(freq);
            if (freq == minFreq) {
                minFreq++;
            }
        }
        int newFreq = freq + 1;
        keyToFreq.put(key, newFreq);
        freqToKeys.putIfAbsent(newFreq, new LinkedHashSet<>());
        freqToKeys.get(newFreq).add(key);
    }

    /**
     * < a href="https://leetcode.com/problems/lfu-cache/discuss/207673/Python-concise-solution-**detailed
     * **-explanation%3A-Two-dict-%2B-Doubly-linked-list">Doubly-linked list</a>
     * TODO
     *
     * @param key
     * @return
     */
    public int get2(int key) {
        return 0;
    }

    public void put2(int key, int value) {

    }
}
