package com.joybean.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/top-k-frequent-elements/">Top K Frequent Elements</a>
 *
 * @author Joybean
 */
public class TopKFrequentElements {
    /**
     * MinHeap
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] distinctNums = map.keySet().stream().mapToInt(Integer::intValue).toArray();
        for (int i = 1; i < distinctNums.length; i++) {
            shiftUp1(i, distinctNums, map);
        }
        for (int i = distinctNums.length - 1; i > 0; i--) {
            swap(0, i, distinctNums);
            shiftDown1(i, distinctNums, map);
        }
        return Arrays.copyOfRange(distinctNums, 0, k);
    }

    private static void shiftDown1(int i, int[] nums, Map<Integer, Integer> map) {
        int p = 0;
        int c;
        while ((c = 2 * p + 1) < i) {
            //Swap with the less child
            if (c + 1 < i && map.get(nums[c]) > map.get(nums[c + 1])) {
                c++;
            }
            if (map.get(nums[c]) <= map.get(nums[p])) {
                swap(c, p, nums);
                p = c;
                continue;
            }
            break;
        }
    }

    private static void shiftUp1(int i, int[] nums, Map<Integer, Integer> map) {
        int p = i;
        while (p != 0) {
            p = (i - 1) / 2;
            if (map.get(nums[p]) > map.get(nums[i])) {
                swap(p, i, nums);
                i = p;
                continue;
            }
            break;
        }
    }

    private static void swap(int p, int i, int[] nums) {
        int temp = nums[p];
        nums[p] = nums[i];
        nums[i] = temp;
    }
}
