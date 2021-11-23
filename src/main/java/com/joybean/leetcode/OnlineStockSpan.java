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
    Deque<Integer> stack;
    List<int[]> list;

    public OnlineStockSpan() {
        stack = new ArrayDeque<>();
        list = new ArrayList<>();
    }

    public int next(int price) {
        int span = 1;
        while (!stack.isEmpty() && list.get(stack.peek())[0] <= price) {
            span += list.get(stack.pop())[1];
        }
        list.add(new int[] {price, span});
        stack.push(list.size() - 1);
        return span;
    }
}
