package com.joybean.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/all-oone-data-structure/">All O`one Data Structure</a>
 *
 * @author Joybean
 */
public class AllOoneDataStructure {
    private Map<String, Node> map;
    private Node head;
    private Node tail;

    public AllOoneDataStructure() {
        map = new HashMap<>();
        //use dummy nodes to simplify logic
        head = new Node("", 0);
        tail = new Node("", Integer.MAX_VALUE, head, null);
    }

    /**
     * Doubly linked list
     *
     * @param key
     */
    public void inc1(String key) {
        Node node;
        if (!map.containsKey(key)) {
            node = new Node(key, 1, head, head.next);
            map.put(key, node);
            return;
        }
        node = map.get(key);
        node.inc();
        Node cur = node;
        while (cur.next != null && node.compareTo(cur.next) > 0) {
            cur = cur.next;
        }
        if (cur != node) {
            node.prev.setNext(node.next);
            node.setNext(cur.next);
            cur.setNext(node);
        }
    }

    public void dec1(String key) {
        Node node = map.get(key);
        node.dec();
        if (node.count == 0) {
            node.prev.setNext(node.next);
            map.remove(key);
            return;
        }
        Node cur = node;
        while (cur.prev != null && node.compareTo(cur.prev) < 0) {
            cur = cur.prev;
        }
        if (cur != node) {
            node.prev.setNext(node.next);
            node.setNext(cur);
            cur.prev.setNext(node);
        }
    }

    public String getMaxKey1() {
        return tail.prev.key;
    }

    public String getMinKey1() {
        return head.next.key;
    }

    private class Node implements Comparable<Node> {
        private String key;
        private int count;
        private Node prev;
        private Node next;

        public Node(String key, int count) {
            this(key, count, null);
        }

        public Node(String key, int count, Node next) {
            this(key, count, null, next);
        }

        public Node(String key, int count, Node prev, Node next) {
            this.key = key;
            this.count = count;
            if (prev != null) {
                prev.setNext(this);
            }
            setNext(next);
        }

        public void inc() {
            count++;
        }

        public void dec() {
            count--;
        }

        public void setNext(Node next) {
            this.next = next;
            if (next != null) {
                next.prev = this;
            }
        }

        @Override
        public int compareTo(Node o) {
            if (o == null) {
                return 1;
            }
            return this.count - o.count;
        }
    }

    /**
     * <a href="https://leetcode.com/problems/all-oone-data-structure/discuss/91416/Java-AC-all-strict-O(1)
     * -not-average-O(1)-easy-to-read">Optimized doubly linked list</a>
     * TODO
     *
     * @param key
     */
    public void inc2(String key) {

    }
}
