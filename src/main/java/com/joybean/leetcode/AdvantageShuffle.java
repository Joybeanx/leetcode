package com.joybean.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/advantage-shuffle/">Advantage Shuffle</a>
 *
 * @author Joybean
 */
public class AdvantageShuffle {
    /**
     * <a href="https://leetcode.com/problems/advantage-shuffle/discuss/149822/JAVA-Greedy-6-lines-with-Explanation">
     * Greedy solution using priority queue</a>
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] advantageCount1(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] ans = new int[n];
        Arrays.sort(nums1);
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < n; i++) {
            queue.add(new int[] {nums2[i], i});
        }
        int left = 0;
        int right = n - 1;
        while (!queue.isEmpty()) {
            if (queue.peek()[0] < nums1[right]) {
                ans[queue.poll()[1]] = nums1[right--];
            } else {
                ans[queue.poll()[1]] = nums1[left++];
            }
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/advantage-shuffle/discuss/149840/C%2B%2BJava-Greedy-Solution-Using-Map">Greedy
     * solution using TreeMap</a>
     * TODO
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] advantageCount2(int[] nums1, int[] nums2) {
        return null;
    }
}
