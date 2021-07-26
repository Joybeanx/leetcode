package com.joybean.leetcode;

import java.util.Iterator;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/flatten-nested-list-iterator/">Flatten Nested List Iterator</a>
 *
 * @author Joybean
 */
public class FlattenNestedListIterator2 implements Iterator<Integer> {
    /**
     * Lazy iterator
     * TODO
     *
     * @param nestedList
     */
    public FlattenNestedListIterator2(List<NestedInteger> nestedList) {

    }

    @Override
    public Integer next() {
        return 0;
    }

    @Override
    public boolean hasNext() {
        return false;
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
