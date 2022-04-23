package com.joybean.leetcode;

import java.util.HashMap;
import java.util.Map;

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
}
