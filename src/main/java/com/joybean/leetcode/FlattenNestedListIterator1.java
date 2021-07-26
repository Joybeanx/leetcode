package com.joybean.leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/flatten-nested-list-iterator/">Flatten Nested List Iterator</a>
 *
 * @author Joybean
 */
public class FlattenNestedListIterator1 implements Iterator<Integer> {
    private Queue<Integer> queue = new LinkedList<>();

    /**
     * Not a real iterator, because it copy the entire data to a queue at initialization
     *
     * @param nestedList
     */
    public FlattenNestedListIterator1(List<NestedInteger> nestedList) {
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

    @Override
    public Integer next() {
        return queue.poll();
    }

    @Override
    public boolean hasNext() {
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
