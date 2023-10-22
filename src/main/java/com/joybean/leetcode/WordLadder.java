package com.joybean.leetcode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/word-ladder/">Word Ladder</a>
 *
 * @author Joybean
 */
public class WordLadder {
    /**
     * BFS
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public static int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        int ans = 1;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return ans;
                }
                Iterator<String> it = wordList.iterator();
                while (it.hasNext()) {
                    String candidate = it.next();
                    if (canTransformable(word, candidate)) {
                        queue.offer(candidate);
                        it.remove();
                    }
                }
            }
            ans++;
        }
        return 0;
    }

    private static boolean canTransformable(String from, String to) {
        char[] chars = from.toCharArray();
        int diff = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != to.charAt(i)) {
                diff++;
                if (diff > 1) {
                    return false;
                }
            }
        }
        return diff == 1;
    }

    /**
     * <a href="https://leetcode.com/problems/word-ladder/solutions/1764371/a-very-highly-detailed-explanation">BFS +
     * HashSet</a>
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public static int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        int ans = 1;
        Queue<String> queue = new LinkedList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return ans;
                }
                visited.add(word);
                for (int j = 0; j < word.length(); j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char[] chars = word.toCharArray();
                        chars[j] = c;
                        String candidate = new String(chars);
                        if (!visited.contains(candidate) && wordSet.contains(candidate)) {
                            queue.offer(candidate);
                        }
                    }
                }
            }
            ans++;
        }
        return 0;
    }

    /**
     * <a href="https://leetcode.com/problems/word-ladder/solutions/40711/two-end-bfs-in-java-31ms/">Two-End BFS</a>
     * TODO
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public static int ladderLength3(String beginWord, String endWord, List<String> wordList) {
        return 0;
    }
}
