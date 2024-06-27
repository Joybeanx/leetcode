package com.joybean.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/implement-trie-prefix-tree/">Implement Trie (Prefix Tree)</a>
 *
 * @author Joybean
 */
public class ImplementTrie {
    private Node root;

    public ImplementTrie() {
        this.root = new Node();
    }

    public void insert(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            if (cur.containsChild(c)) {
                cur = cur.getChild(c);
            } else {
                Node child = new Node();
                cur.addChild(c, child);
                cur = child;
            }
        }
        cur.setWord(true);
    }

    public boolean search(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.containsChild(c)) {
                return false;
            }
            cur = cur.getChild(c);
        }
        return cur.isWord();
    }

    public boolean startsWith(String prefix) {
        Node cur = root;
        for (char c : prefix.toCharArray()) {
            if (!cur.containsChild(c)) {
                return false;
            }
            cur = cur.getChild(c);
        }
        return true;
    }

    public static class Node {
        //key is not necessary
        //private Character key;
        private Map<Character, Node> children;

        private boolean isWord;

        public Node() {
            this.children = new HashMap<>();
        }

        public void addChild(Character key, Node child) {
            children.put(key, child);
        }

        public boolean containsChild(Character key) {
            return children.containsKey(key);
        }

        public Node getChild(Character key) {
            return children.get(key);
        }

        public void setWord(boolean isWord) {
            this.isWord = isWord;
        }

        public boolean isWord() {
            return isWord;
        }
    }
}
