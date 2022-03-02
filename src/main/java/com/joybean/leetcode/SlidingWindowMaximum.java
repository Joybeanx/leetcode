package com.joybean.leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/sliding-window-maximum/">Sliding Window Maximum</a>
 *
 * @author joybean
 */
public class SlidingWindowMaximum {
    /**
     * Monotonic queue
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow1(int[] nums, int k) {
        int left = 0;
        int[] ans = new int[nums.length - k + 1];
        Map<Integer, Integer> windowCounts = new HashMap<>();
        Deque<Integer> deque = new LinkedList<>();
        int index = 0;
        for (int right = 0; right < nums.length; right++) {
            windowCounts.merge(nums[right], 1, Integer::sum);
            while (!deque.isEmpty() && deque.peekLast() <= nums[right]) {
                deque.pollLast();
            }
            deque.offerLast(nums[right]);
            if (right - left + 1 == k) {
                ans[index++] = deque.peek();
                windowCounts.merge(nums[left], -1, Integer::sum);
                if (windowCounts.remove(nums[left], 0) && nums[left] == deque.peek()) {
                    deque.poll();
                }
                left++;
            }
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/sliding-window-maximum/discuss/65884/Java-O(n)
     * -solution-using-deque-with-explanation">Optimized sliding window</a>
     * TODO
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        return null;
    }
}
