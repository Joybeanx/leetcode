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
     * Monotonic deque
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
            //pop nums that less than or equals to current num
            while (!deque.isEmpty() && nums[right] >= deque.peekLast()) {
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
     * Optimized monotonic deque
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        for (int left = 0, right = 0; right < n; right++) {
            //pop nums that less than current num
            //should not use ">=", case: nums=[-7,-8,7,5,7,1,6,0], k=4
            while (!deque.isEmpty() && nums[right] > deque.peek()) {
                deque.pop();
            }
            deque.push(nums[right]);
            if (right >= k - 1) {
                ans[left] = deque.peekLast();
                //when left is maximum and left start to move out of window
                if (nums[left] == deque.peekLast()) {
                    deque.pollLast();
                }
                left++;
            }

        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/sliding-window-maximum/solutions/65884/java-o-n-solution-using-deque-with-explanation/">Monotonic deque: store
     * index in deque</a>
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow3(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int j = 0;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            //pop smaller numbers as they are useless
            while (!deque.isEmpty() && nums[i] >= nums[deque.peek()]) {
                deque.pop();
            }
            deque.push(i);
            //always keep deque.top - deque.bottom == k
            if (i - deque.peekLast() + 1 > k) {
                deque.pollLast();
            }
            if (i - 1 >= k) {
                ans[j++] = nums[deque.peekLast()];
            }
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/sliding-window-maximum/solutions/65881/o-n-solution-in-java-with-two
     * -simple-pass-in-the-array/">Calculate max so far</a>
     * TODO
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow4(int[] nums, int k) {
        return null;
    }

}
