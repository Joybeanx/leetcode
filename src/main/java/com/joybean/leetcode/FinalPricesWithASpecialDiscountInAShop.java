package com.joybean.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/">Final Prices With a Special
 * Discount in a Shop</a>
 *
 * @author Joybean
 */
public class FinalPricesWithASpecialDiscountInAShop {
    /**
     * Monotonic stack
     *
     * @param prices
     * @return
     */
    public static int[] finalPrices1(int[] prices) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            ans[i] = prices[i];
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int top = stack.pop();
                ans[top] = prices[top] - prices[i];
            }
            stack.push(i);
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/discuss/685390/JavaC%2B
     * %2BPython-Stack-One-Pass">Monotonic stack</a>
     *
     * @param prices
     * @return
     */
    public static int[] finalPrices2(int[] prices) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                prices[stack.pop()] -= prices[i];
            }
            stack.push(i);
        }
        return prices;
    }
}
