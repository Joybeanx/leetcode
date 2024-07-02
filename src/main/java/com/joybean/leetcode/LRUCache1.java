package com.joybean.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/lru-cache/">LRU Cache</a>
 *
 * @author joybean
 * @date 2024/7/2
 */
public class LRUCache1 {
    private Map<Integer, Node> nodes;
    /**
     * head.next is the newest node
     */
    private Node head;
    /**
     * tail.prev is the oldest node
     */
    private Node tail;
    private int capacity;

    public LRUCache1(int capacity) {
        nodes = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.setNext(tail);
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = getNode(key);
        if (node == null) {
            return -1;
        }
        return node.val;
    }

    public void put(int key, int value) {
        Node node = getNode(key);
        if (node != null) {
            node.val = value;
        } else {
            if (nodes.size() == capacity) {
                nodes.remove(tail.prev.key);
                tail.prev.prev.setNext(tail);
            }
            node = new Node(key, value);
            moveToHead(node);
            nodes.put(key, node);
        }
    }

    private Node getNode(int key) {
        if (nodes.containsKey(key)) {
            Node node = nodes.get(key);
            node.prev.setNext(node.next);
            moveToHead(node);
            return node;
        }
        return null;
    }

    private void moveToHead(Node node) {
        node.setNext(head.next);
        head.setNext(node);
    }

    private static class Node {
        private int key;
        private int val;
        private Node next;
        private Node prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public void setNext(Node next) {
            this.next = next;
            if (next != null) {
                next.prev = this;
            }
        }
    }

}
