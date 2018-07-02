package com.joybean.leetcode;

import java.util.*;
import java.util.stream.Stream;

/**
 * <a href="https://leetcode.com/problems/group-anagrams/description/">Group Anagrams</a>
 *
 * @author Joybean
 */
public class GroupAnagrams {
    /**
     *
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            //Anagrams should have same identity
            String id = String.valueOf(arr);
            List<String> group;
            if ((group = map.get(id)) == null) {
                group = new ArrayList<String>();
                map.put(id, group);
                result.add(group);
            }
            group.add(str);
        }
        return result;
    }
}
