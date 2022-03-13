package com.joybean.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/lru-cache/description/">LRU Cache</a>
 *
 * @author Joybean
 */
public class LRUCache {
    private final LinkedHashMap<Integer, Integer> cacheHolder;

    private int capacity;
    private Map<Integer, Node> map = new HashMap<>();
    private Node head = new Node();
    private Node tail = new Node();
    private int size = 0;

    static class LRULinkedHashMap extends LinkedHashMap<Integer, Integer> {
        private int capacity;

        public LRULinkedHashMap(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return this.size() > capacity;
        }
    }

    public LRUCache(int capacity) {
        cacheHolder = new LRULinkedHashMap(capacity);

        this.capacity = capacity;
        head.setNext(tail);
    }

    public int get1(int key) {
        return cacheHolder.getOrDefault(key, -1);
    }

    public void put1(int key, int value) {
        cacheHolder.put(key, value);
    }


    public int get2(int key) {
        Node target = findByKey(key);
        if (target == null) {
            return -1;
        }
        moveToFirst(target);
        return target.value;
    }

    public void put2(int key, int value) {
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
