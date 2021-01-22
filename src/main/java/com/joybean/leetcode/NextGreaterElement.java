package com.joybean.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/next-greater-element-ii/">Next Greater Element II</a>
 *
 * @author Joybean
 */
public class NextGreaterElement {

    public static int[] nextGreaterElement(int[] nums) {
        Stack<Element> stack = new Stack<>();
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        int loopCnt = 2 * nums.length;
        for (int i = 0; i < loopCnt; i++) {
            int index = i % nums.length;
            Integer current = nums[index];
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
}
