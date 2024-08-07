package com.joybean.leetcode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/lfu-cache/">LFU Cache</a>
 *
 * @author Joybean
 */
public class LFUCache {
    private int capacity;
    Map<Integer, Integer> values = new HashMap<>();
    Map<Integer, Integer> keyFrequencies = new HashMap<>();
    Map<Integer, List<Integer>> frequencyKeys = new HashMap<>();
    PriorityQueue<Integer> minFreqHeap = new PriorityQueue<>();


    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Two HashMaps: use PriorityQueue keeps track of min frequency
     *
     * @param key
     * @return
     */
    public int get1(int key) {
        if (values.containsKey(key)) {
            increaseFreq1(key);
            return values.get(key);
        }
        return -1;
    }

    public void put1(int key, int value) {
        if (values.containsKey(key)) {
            increaseFreq1(key);
            values.put(key, value);
        } else {
            if (values.size() == capacity) {
                Integer minFreq = minFreqHeap.peek();
                List<Integer> minFreqKeys = frequencyKeys.get(minFreq);
                Integer minFreqKey = minFreqKeys.remove(0);
                if (minFreqKeys.isEmpty()) {
                    frequencyKeys.remove(minFreq);
                }
                keyFrequencies.remove(minFreqKey);
                values.remove(minFreqKey);
                if (minFreqKeys.isEmpty()) {
                    minFreqHeap.poll();
                }
            }
            values.put(key, value);
            increaseFreq1(key);
        }
    }

    private void increaseFreq1(Integer key) {
        int frequency = keyFrequencies.getOrDefault(key, 0);
        int newFrequency = frequency + 1;
        keyFrequencies.put(key, newFrequency);
        if (frequencyKeys.containsKey(frequency)) {
            List<Integer> keys = frequencyKeys.get(frequency);
            keys.remove(key);
            if (keys.isEmpty()) {
                frequencyKeys.remove(frequency);
                minFreqHeap.remove(frequency);
            }
        }
        if (!frequencyKeys.containsKey(newFrequency)) {
            minFreqHeap.offer(newFrequency);
        }
        frequencyKeys.putIfAbsent(newFrequency, new ArrayList<>());
        frequencyKeys.get(newFrequency).add(key);
    }


    private Map<Integer, Integer> keyToValue = new HashMap<>();
    private Map<Integer, Integer> keyToFreq = new HashMap<>();
    private Map<Integer, LinkedHashSet<Integer>> freqToKeys = new HashMap<>();
    private int minFreq = 0;

    /**
     * <a href="https://github.com/model-nut/algo-leetcode-labuladong-2020/blob/master/labuladong-algo-202012/%E6%95%B0%E6%8D
     * %AE%E7%BB%93%E6%9E%84%E7%B3%BB%E5%88%97/LFU.md">Two HashMaps (by labuladong)</a>
     *
     * @param key
     * @return
     */
    public int get2(int key) {
        if (!keyToValue.containsKey(key)) {
            return -1;
        }
        increaseFreq2(key);
        return keyToValue.get(key);
    }

    public void put2(int key, int value) {
        if (keyToValue.containsKey(key)) {
            increaseFreq2(key);
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

    private void increaseFreq2(int key) {
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
     * <a href="https://leetcode.com/problems/lfu-cache/solutions/207673/python-concise-solution-detailed-explanation-two-dict-doubly-linked-list/">Custom doubly linked list (by mullen00)</a>
     * TODO
     *
     * @param key
     * @return
     */
    public int get3(int key) {
        return 0;
    }

    public void put3(int key, int value) {
    }

}
