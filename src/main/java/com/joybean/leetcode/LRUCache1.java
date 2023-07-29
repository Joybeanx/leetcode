package com.joybean.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/lru-cache/description/">LRU Cache</a>
 *
 * @author Joybean
 */
public class LRUCache1 {
    private int capacity;
    private Map<Integer, Node> map = new HashMap<>();
    private Node head = new Node();
    private Node tail = new Node();
    private int size = 0;

    /**
     * HashMap and Doubly LinkedList solution
     *
     * @param capacity
     */
    public LRUCache1(int capacity) {
        this.capacity = capacity;
        head.setNext(tail);
    }


    public int get(int key) {
        Node target = findByKey(key);
        if (target == null) {
            return -1;
        }
        moveToFirst(target);
        return target.value;
    }

    public void put(int key, int value) {
        Node node = findByKey(key);
        if (node == null) {
            if (size == capacity) {
                removeLast();
            }
            insertFirst(key, value);
        } else {
            node.value = value;
            moveToFirst(node);
        }
    }


    private Node findByKey(int key) {
        return map.get(key);
    }

    private void moveToFirst(Node node) {
        node.next.setPre(node.pre);
        insertFirst0(node);
    }

    private void insertFirst(int key, int value) {
        insertFirst(new Node(key, value));
    }

    private void insertFirst(Node node) {
        insertFirst0(node);
        map.put(node.key, node);
        size++;
    }

    private void insertFirst0(Node node) {
        node.setNext(head.next);
        head.setNext(node);
    }

    private void removeLast() {
        Node last = tail.pre;
        tail.setPre(last.pre);
        map.remove(last.key);
        size--;
    }


    static class Node {
        private int key;
        private int value;
        private Node pre;
        private Node next;

        public Node() {

        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public void setPre(Node pre) {
            this.pre = pre;
            pre.next = this;
        }

        public void setNext(Node next) {
            this.next = next;
            next.pre = this;
        }
    }
}
