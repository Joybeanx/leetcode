package com.joybean.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/sum-of-subarray-minimums/">Sum of Subarray Minimums</a>
 *
 * @author joybean
 */
public class SumOfSubarrayMinimums {
    /**
     * Monotonic stack
     *
     * @param arr
     * @return
     */
    public static int sumSubarrayMins1(int[] arr) {
        int mod = (int)1e9 + 7;
        //nled[i] = distance from the ith element to next less element
        int[] nled = new int[arr.length];
        Deque<Integer> stack1 = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            nled[i] = arr.length - i;
            while (!stack1.isEmpty() && arr[stack1.peek()] > arr[i]) {
                nled[stack1.peek()] = i - stack1.pop();
            }
            stack1.push(i);
        }
        //pled[i] = distance from the ith element to next less element
        int[] pled = new int[arr.length];
        Deque<Integer> stack2 = new ArrayDeque<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            pled[i] = i + 1;
            //In order to handle duplicate elements, we must make sure either left or right side should use > and the
            // other one should use >=
            while (!stack2.isEmpty() && arr[stack2.peek()] >= arr[i]) {
                pled[stack2.peek()] = stack2.pop() - i;
            }
            stack2.push(i);
        }
        //Use long instead of int
        long ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans = (ans + (long)nled[i] * pled[i] * arr[i]) % mod;
        }
        return (int)ans;
    }

    /**
     * Monotonic stack:one pass with two stacks
     *
     * @param arr
     * @return
     */
    public static int sumSubarrayMins2(int[] arr) {
        int mod = (int)1e9 + 7;
        //nled[i] = distance from the ith element to next less element
        int[] nled = new int[arr.length];
        //pled[i] = distance from the ith element to previous less element
        int[] pled = new int[arr.length];
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            nled[i] = arr.length - i;
            while (!stack1.isEmpty() && arr[stack1.peek()] > arr[i]) {
                nled[stack1.peek()] = i - stack1.pop();
            }
            stack1.push(i);
            pled[i] = i + 1;
            while (!stack2.isEmpty() && arr[stack2.peek()] > arr[i]) {
                stack2.pop();
            }
            pled[i] = i - (stack2.isEmpty() ? -1 : stack2.peek());
            stack2.push(i);
        }
        long ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans = (ans + (long)nled[i] * pled[i] * arr[i]) % mod;
        }
        return (int)ans;
    }

    /**
     * <a href="https://leetcode.com/problems/sum-of-subarray-minimums/discuss/170750/JavaC%2B%2BPython-Stack-Solution">Monotonic
     * stack:One pass with one stack</a>
     * TODO
     *
     * @param arr
     * @return
     */
    public static int sumSubarrayMins3(int[] arr) {
        return 0;
    }
}
