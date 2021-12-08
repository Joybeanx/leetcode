package com.joybean.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/max-chunks-to-make-sorted/">Max Chunks To Make Sorted</a>
 *
 * @author Joybean
 */
public class MaxChunksToMakeSorted {
    /**
     * <a href="https://leetcode.com/problems/max-chunks-to-make-sorted/discuss/113528/Simple-Java-O(n)
     * -Solution-with-detailed-explanation">Simple O(n) solution</a>
     *
     * @param arr
     * @return
     */
    public static int maxChunksToSorted1(int[] arr) {
        int max = 0;
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            //If the maximum num before the current index i is i, it means that a cut can be made;
            //otherwise, there are num larger than i in the first half, and num smaller than i in the
            //second half.
            if (max == i) {
                cnt++;
            }
        }
        return cnt;
    }

    /**
     * <a href="Monotonic stack solution with detailed explanation">Monotonic stack</a>
     *
     * @param arr
     * @return
     */
    public static int maxChunksToSorted2(int[] arr) {
        //Store the largest value in each chunk when the chunk cannot be partitioned to smaller ones
        Deque<Integer> stack = new ArrayDeque<>();
        for (int num : arr) {
            int largest = num;
            while (!stack.isEmpty() && stack.peek() > num) {
                largest = Math.max(largest, stack.pop());
            }
            stack.push(largest);
        }
        return stack.size();
    }
}
