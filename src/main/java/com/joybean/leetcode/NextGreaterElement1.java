package com.joybean.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/next-greater-element-i/">Next Greater Element I</a>
 *
 * @author Joybean
 */
public class NextGreaterElement1 {
    /**
     * Monotonic stack
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[nums1.length];
        Arrays.fill(ans, -1);
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                Integer idx;
                if ((idx = map.remove(stack.pop())) != null) {
                    ans[idx] = num;
                }
                if (map.isEmpty()) {
                    return ans;
                }
            }
            stack.push(num);
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/next-greater-element-i/discuss/97595/Java-10-lines-linear-time
     * -complexity-O(n)-with-explanation">Monotonic stack 2</a>
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        // Map from x to next greater element of x
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }
}
