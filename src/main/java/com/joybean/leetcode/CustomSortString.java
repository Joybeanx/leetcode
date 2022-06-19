package com.joybean.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.com/problems/custom-sort-string/">Custom Sort String</a>
 *
 * @author Joybean
 */
public class CustomSortString {
    /**
     * Custom comparator
     *
     * @param order
     * @param s
     * @return
     */
    public static String customSortString1(String order, String s) {
        int[] position = new int[26];
        for (int i = 0; i < order.length(); i++) {
            position[order.charAt(i) - 'a'] = i;
        }
        Character[] characters =
            s.chars().mapToObj(c -> (char)c).toArray(Character[]::new);
        Arrays.sort(characters, Comparator.comparingInt(a -> position[a - 'a']));
        return Arrays.stream(characters).map(String::valueOf).collect(Collectors.joining());
    }

    /**
     * <a href="https://leetcode.com/problems/custom-sort-string/discuss/116615/JavaPython-3-one-Java-10-liner-Python
     * -6-liner-and-2-liner-solutions-w-comment">Bucket sort</a>
     *
     * @param order
     * @param s
     * @return
     */
    public static String customSortString2(String order, String s) {
        int[] buckets = new int[26];
        for (char ch : s.toCharArray()) {
            buckets[ch - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : order.toCharArray()) {
            while (buckets[ch - 'a']-- > 0) {
                sb.append(ch);
            }
        }
        for (char ch = 'a'; ch <= 'z'; ch++) {
            while (buckets[ch - 'a']-- > 0) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
