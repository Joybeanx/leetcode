package com.joybean.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/">Minimum Cost Tree From Leaf Values</a>
 *
 * @author Joybean
 */
public class MinimumCostTreeFromLeafValues {

    /**
     * <a href="https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/discuss/476513/Java-Mono-Stack-98
     * -Example-to-explain">Monotonic stack</a>
     *
     * @param arr
     * @return
     */
    public static int mctFromLeafValues1(int[] arr) {
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int num : arr) {
            while (!stack.isEmpty() && stack.peek() < num) {
                int mid = stack.pop();
                if (stack.isEmpty()) {
                    ans += mid * num;
                } else {
                    //If element e is smaller than its two neighbors, result adds e * Math.min(two neighbors)
                    ans += mid * Math.min(stack.peek(), num);
                }
            }
            stack.push(num);
        }
        while (stack.size() > 1) {
            ans += stack.pop() * stack.peek();
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/discuss/339959/One-Pass-O(N)
     * -Time-and-Space">Optimized monotonic stack</a>
     *
     * @param arr
     * @return
     */
    public static int mctFromLeafValues2(int[] arr) {
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(Integer.MAX_VALUE);
        for (int num : arr) {
            while (stack.peek() < num) {
                ans += stack.pop() * Math.min(stack.peek(), num);
            }
            stack.push(num);
        }
        while (stack.size() > 2) {
            ans += stack.pop() * stack.peek();
        }
        return ans;
    }

    /**
     * DP solution
     * TODO
     *
     * @param arr
     * @return
     */
    public static int mctFromLeafValues3(int[] arr) {
        return 0;
    }
}
