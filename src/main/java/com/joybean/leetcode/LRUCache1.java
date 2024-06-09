package com.joybean.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/lru-cache/">LRU Cache</a>
 *
 * @author Joybean
 */
public class LRUCache1 {
    private final Map<Integer, Node> map;
    /**
     * head.next is the newest node
     */
    private Node head;
    /**
     * tail.prev is the oldest node
     */
    private Node tail;
    private final int capacity;

    /**
     * HashMap and Doubly LinkedList solution
     * @param capacity
     */
    public LRUCache1(int capacity) {
        this.map = new HashMap<>(capacity);
        this.capacity = capacity;
        this.head = new Node();
        this.tail = new Node();
        head.setNext(tail);
    }

    public int get(int key) {
        Node node = getNode(key);
        if (node == null) {
            return -1;
        }
        return node.val;
    }

    private Node getNode(int key) {
        Node node = map.get(key);
        if (node == null) {
            return null;
        }
        node.prev.setNext(node.next);
        node.setNext(head.next);
        head.setNext(node);
        return node;
    }

    public void put(int key, int value) {
        Node node = getNode(key);
        if (node != null) {
            node.val = value;
            return;
        }
        node = new Node(key, value);
        if (map.size() == capacity) {
            Node last = tail.prev;
            tail.setPrev(last.prev);
            map.remove(last.key);
        }
        node.setNext(head.next);
        head.setNext(node);
        map.put(key, node);
    }


    private static class Node {
        private int key;
        private int val;
        private Node prev;
        private Node next;

        public Node() {

        }

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
            this.prev.next = this;
        }

        public void setNext(Node next) {
            this.next = next;
            this.next.prev = this;
        }
    }

}
