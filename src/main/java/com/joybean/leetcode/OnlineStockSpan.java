package com.joybean.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/online-stock-span/">Online Stock Span</a>
 *
 * @author Joybean
 */
public class OnlineStockSpan {
    Deque<Integer> stack1;
    List<int[]> list;

    Deque<int[]> stack2;

    public OnlineStockSpan() {
        stack1 = new ArrayDeque<>();
        list = new ArrayList<>();

        stack2 = new ArrayDeque<>();
    }

    /**
     * Stack solution
     *
     * @param price
     * @return
     */
    public int next1(int price) {
        int span = 1;
        while (!stack1.isEmpty() && list.get(stack1.peek())[0] <= price) {
            span += list.get(stack1.pop())[1];
        }
        list.add(new int[] {price, span});
        stack1.push(list.size() - 1);
        return span;
    }

    /**
     * <a href="https://leetcode.com/problems/online-stock-span/discuss/640358/JAVA-Solution-With-visualization-and-easy
     * -explained!">Better stack solution</a>
     *
     * @param price
     * @return
     */
    public int next2(int price) {
        int span = 1;
        while (!stack2.isEmpty() && stack2.peek()[0] <= price) {
            span += stack2.pop()[1];
        }
        stack2.push(new int[] {price, span});
        return span;
    }
}
