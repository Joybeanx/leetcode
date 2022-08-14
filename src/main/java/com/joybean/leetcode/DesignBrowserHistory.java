package com.joybean.leetcode;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/design-browser-history/">Design Browser History</a>
 *
 * @author Joybean
 */
public class DesignBrowserHistory {
    private Stack<String> backwards = new Stack<>();
    private Stack<String> forwards = new Stack<>();

    private Node cur;

    public DesignBrowserHistory(String homepage) {
        backwards.push(homepage);

        cur = new Node(homepage);
    }

    /**
     * Two stacks
     *
     * @param url
     */
    public void visit1(String url) {
        backwards.push(url);
        forwards.clear();

    }

    public String back1(int steps) {
        while (backwards.size() != 1 && steps-- != 0) {
            forwards.push(backwards.pop());
        }
        return backwards.peek();
    }

    public String forward1(int steps) {
        while (!forwards.isEmpty() && steps-- != 0) {
            backwards.push(forwards.pop());
        }
        return backwards.peek();
    }

    /**
     * <a href="https://leetcode.com/problems/design-browser-history/discuss/674486/Two-Stacks-Pretty-code.">Using
     * array (by srijankrs)</a>
     * TODO
     *
     * @param url
     */
    public void visit2(String url) {

    }

    public String back2(int steps) {
        return null;
    }

    public String forward2(int steps) {
        return null;
    }

    /**
     * Doubly linked list
     *
     * @param url
     */
    public void visit3(String url) {
        Node node = new Node(url);
        cur.setNext(node);
        cur = node;
    }

    public String back3(int steps) {
        while (cur.prev != null && steps-- != 0) {
            cur = cur.prev;
        }
        return cur.value;
    }

    public String forward3(int steps) {
        while (cur.next != null && steps-- != 0) {
            cur = cur.next;
        }
        return cur.value;
    }

    private static class Node {
        private String value;
        private Node prev;
        private Node next;

        public Node(String value) {
            this.value = value;
        }

        public void setNext(Node next) {
            this.next = next;
            if (next != null) {
                next.prev = this;
            }
        }
    }
}
