package com.joybean.leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/flatten-nested-list-iterator/">Flatten Nested List Iterator</a>
 *
 * @author Joybean
 */
public class FlattenNestedListIterator implements Iterator<Integer> {
    private Stack<NestedInteger> stack;

    private Queue<Integer> queue = new LinkedList<>();

    /**
     * <a href="https://leetcode.com/problems/flatten-nested-list-iterator/discuss/142999/Load-data-on-next()
     * -instead-of-hasNext()-JAVA-AC-Solution">Lazy iterator</a>
     *
     * @param nestedList
     */
    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        enstack(nestedList);

        //Not a real iterator, because it copy the entire data to a queue at initialization
        buildQueue(nestedList);
    }

    private void buildQueue(List<NestedInteger> nestedList) {
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                queue.add(ni.getInteger());
            } else {
                buildQueue(ni.getList());
            }
        }
    }

    private void enstack(List<NestedInteger> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            stack.push(list.get(i));
        }
        if (!stack.isEmpty() && !stack.peek().isInteger()) {
            enstack(stack.pop().getList());
        }
    }

    @Override
    public Integer next() {
        Integer res = stack.pop().getInteger();
        if (!stack.isEmpty() && !stack.peek().isInteger()) {
            enstack(stack.pop().getList());
        }
        return res;
    }

    public Integer next2() {
        return queue.poll();
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public boolean hasNext2() {
        return !queue.isEmpty();
    }

    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.

        boolean isInteger();
        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list

        Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer

        List<NestedInteger> getList();

    }
}
