package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/top-k-frequent-words/">Top K Frequent Words</a>
 *
 * @author Joybean
 */
public class TopKFrequentWords {
    /**
     * Priority queue
     *
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> counterMap = new HashMap<>();
        for (String word : words) {
            counterMap.merge(word, 1, Integer::sum);
        }
        Queue<Entry<String, Integer>> queue = new PriorityQueue<>((a, b) -> {
            if (a.getValue().compareTo(b.getValue()) != 0) {
                return b.getValue() - a.getValue();
            }
            return a.getKey().compareTo(b.getKey());

        });
        for (Entry<String, Integer> entry : counterMap.entrySet()) {
            queue.offer(entry);
        }
        List<String> ans = new ArrayList<>();
        while (!queue.isEmpty() && k > 0) {
            ans.add(queue.poll().getKey());
            k--;
        }
        return ans;
    }
}
