package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/top-k-frequent-elements/">Top K Frequent Elements</a>
 *
 * @author Joybean
 */
public class TopKFrequentElements {
    /**
     * Max Heap
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.merge(num, 1, Integer::sum);
        }
        int[] uniqueNums = counter.keySet().stream().mapToInt(Integer::intValue).toArray();
        for (int i = 1; i < uniqueNums.length; i++) {
            shiftUp1(i, uniqueNums, counter);
        }
        int[] ans = new int[k];
        for (int i = 1; i <= k; i++) {
            ans[i - 1] = uniqueNums[0];
            uniqueNums[0] = uniqueNums[uniqueNums.length - i];
            shiftDown1(uniqueNums.length - i, uniqueNums, counter);

        }
        return ans;
    }

    private static void shiftDown1(int i, int[] nums, Map<Integer, Integer> counter) {
        int p = 0;
        int c;
        while ((c = 2 * p + 1) < i) {
            //Swap with the bigger child
            if (c + 1 < i && counter.get(nums[c]) < counter.get(nums[c + 1])) {
                c++;
            }
            if (counter.get(nums[c]) > counter.get(nums[p])) {
                swap(c, p, nums);
                p = c;
                continue;
            }
            break;
        }
    }

    private static void shiftUp1(int i, int[] nums, Map<Integer, Integer> counter) {
        int p = i;
        while (p != 0) {
            p = (i - 1) / 2;
            if (counter.get(nums[p]) < counter.get(nums[i])) {
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

    /**
     * <a href="https://leetcode.com/problems/top-k-frequent-elements/solutions/81602/java-o-n-solution-bucket-sort
     * /">Bucket Sort</a>
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequent2(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        counter.forEach((key, value) -> {
            if (buckets[value] == null) {
                buckets[value] = new ArrayList<>();
            }
            buckets[value].add(key);
        });
        for (int i = buckets.length - 1, j = 0; i >= 1; i--) {
            List<Integer> bucket = buckets[i];
            if (bucket != null) {
                for (Integer num : bucket) {
                    if (j < k) {
                        ans[j++] = num;
                    } else {
                        return ans;
                    }
                }
            }
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/top-k-frequent-elements/solutions/81635/3-java-solution-using-array
     * -maxheap-treemap/">Min Heap using PriorityQueue (by fluency03)</a>
     * TODO
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequent3(int[] nums, int k) {
        return null;
    }
}
