package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/design-linked-list/">Design Linked List</a>
 *
 * @author Joybean
 */
public class DesignLinkedList {
    private Node head;
    private Node tail;
    private int size;

    /**
     * Doubly linked list
     */
    public DesignLinkedList() {
        head = new Node(-1);
        tail = new Node(-1);
        head.setNext(tail);
    }

    public int get(int index) {
        Node target = getNode(index);
        return target.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        Node cur = new Node(val);
        Node next = getNode(index);
        Node prev = next.prev;
        prev.setNext(cur);
        cur.setNext(next);
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index >= size) {
            return;
        }
        Node target = getNode(index);
        Node prev = target.prev;
        Node next = target.next;
        prev.setNext(next);
        size--;
    }

    public Node getNode(int index) {
        if (index >= size) {
            //Ensure that addAtIndex works properly when index equals the length of the linked list
            return tail;
        }
        Node cur = head;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    private static class Node {
        private int val;
        private Node prev;
        private Node next;

        public Node(int val) {
            this.val = val;
        }

        private void setNext(Node next) {
            this.next = next;
            next.prev = this;
        }
    }
}
