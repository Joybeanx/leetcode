package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/group-anagrams/">Group Anagrams</a>
 *
 * @author Joybean
 */
public class GroupAnagrams {

    /**
     * Sort str in alphabetical order
     *
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams1(String[] strs) {
        if (strs.length == 0) {return new ArrayList();}
        Map<String, List<String>> map = new HashMap();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            //Anagrams should have same identity
            String id = String.valueOf(arr);
            List<String> group;
            if ((group = map.get(id)) == null) {
                group = new ArrayList<>();
                map.put(id, group);
            }
            group.add(str);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * Counting sort
     *
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();
        for (String str : strs) {
            //use char[] instead of int[] to count frequency
            char[] counter = new char[26];
            for (char c : str.toCharArray()) {
                counter[c - 'a']++;
            }
            //convert counter to key, empty slot will be discarded
            String key = buildKey(counter);
            anagrams.putIfAbsent(key, new ArrayList<>());
            anagrams.get(key).add(str);
        }
        return new ArrayList<>(anagrams.values());
    }

    private static String buildKey(char[] counter) {
        String key = "";
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] != '\u0000') {
                key += String.valueOf((char)('a' + i)) + (int)counter[i];
            }
        }
        return key;
    }

    /**
     * Counting sort: use counter as key directly
     *
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams3(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();
        for (String str : strs) {
            //use char[] instead of int[] to count frequency
            char[] counter = new char[26];
            for (char c : str.toCharArray()) {
                counter[c - 'a']++;
            }
            //use counter as key directly
            String key = new String(counter);
            anagrams.putIfAbsent(key, new ArrayList<>());
            anagrams.get(key).add(str);
        }
        return new ArrayList<>(anagrams.values());
    }


}
