package com.joybean.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/next-greater-element-ii/">Next Greater Element II</a>
 *
 * @author Joybean
 */
public class NextGreaterElement2 {
    /**
     * Brute Force
     *
     * @param nums
     * @return
     */
    public static int[] nextGreaterElements1(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = -1;
            for (int j = 1; j < nums.length; j++) {
                if (nums[(i + j) % nums.length] > nums[i]) {
                    res[i] = nums[(i + j) % nums.length];
                    break;
                }
            }
        }
        return res;
    }

    /**
     * Monotonically increasing stack(from top to bottom),extra stack element model
     *
     * @param nums
     * @return
     */
    public static int[] nextGreaterElements2(int[] nums) {
        Stack<Element> stack = new Stack<>();
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        int loopCnt = 2 * nums.length;
        for (int i = 0; i < loopCnt; i++) {
            int index = i % nums.length;
            Integer current = nums[index];
            //Every time after pushing an element,the stack remain monotonically increasing,remaining elements are
            //those whose greater element are not found so far.
            while (!stack.isEmpty()) {
                Element top = stack.peek();
                if (current > top.value) {
                    stack.pop();
                    result[top.index] = current;
                } else {
                    break;
                }
            }
            stack.push(new Element(index, current));
        }
        return result;
    }

    static class Element {
        int index;
        int value;

        public Element(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    /**
     * Monotonically increasing stack,only store index in stack
     *
     * @param nums
     * @return
     */
    public static int[] nextGreaterElements3(int[] nums) {
        //index stack
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        int loopCnt = 2 * nums.length;
        for (int i = 0; i < loopCnt; i++) {
            int index = i % nums.length;
            Integer current = nums[index];
            while (!stack.isEmpty()) {
                int top = stack.peek();
                if (current > nums[top]) {
                    stack.pop();
                    result[top] = current;
                } else {
                    break;
                }
            }
            stack.push(index);
        }
        return result;
    }

    /**
     * Monotonically increasing stack,traverse from right to left
     *
     * @param nums
     * @return
     */
    public static int[] nextGreaterElements4(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * nums.length - 1; i >= 0; --i) {
            while (!stack.empty() && nums[stack.peek()] <= nums[i % nums.length]) {
                stack.pop();
            }
            //now stack[top] can act next greater element for current num
            res[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
            stack.push(i % nums.length);
        }
        return res;
    }
}
