package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number/">Letter Combinations of a Phone
 * Number</a>
 *
 * @author Joybean
 */
public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations1(String digits) {
        if (digits == null) {
            return Collections.emptyList();
        }
        Map<Integer, List<String>> digitMap = new HashMap<>();
        digitMap.put(2, Arrays.asList("a", "b", "c"));
        digitMap.put(3, Arrays.asList("d", "e", "f"));
        digitMap.put(4, Arrays.asList("g", "h", "i"));
        digitMap.put(5, Arrays.asList("j", "k", "l"));
        digitMap.put(6, Arrays.asList("m", "n", "o"));
        digitMap.put(7, Arrays.asList("p", "q", "r", "s"));
        digitMap.put(8, Arrays.asList("t", "u", "v"));
        digitMap.put(9, Arrays.asList("w", "x", "y", "z"));
        return doCombine(digits, digitMap);
    }

    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations2(String digits) {
        List<String> ret = new LinkedList<>();
        combination("", digits, 0, ret);
        return ret;
    }

    private void combination(String prefix, String digits, int offset, List<String> ret) {
        if (offset >= digits.length()) {
            ret.add(prefix);
            return;
        }
        String letters = KEYS[(digits.charAt(offset) - '0')];
        for (int i = 0; i < letters.length(); i++) {
            combination(prefix + letters.charAt(i), digits, offset + 1, ret);
        }
    }

    public List<String> doCombine(String digits, Map<Integer, List<String>> digitMap) {
        if (digits == null || digits.isEmpty()) {
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<>();
        Integer first = Integer.parseInt(Character.toString(digits.charAt(0)));
        String rest = digits.length() > 1 ? digits.substring(1) : null;
        List<String> combinations = doCombine(rest, digitMap);
        for (String letter : digitMap.get(first)) {
            result.addAll(merge(letter, combinations));
        }
        return result;
    }

    private List<String> merge(String letter, List<String> combinations) {
        List<String> list = new ArrayList<>();
        if (combinations.isEmpty()) {
            list.add(letter);
        } else {
            for (String combination : combinations) {
                list.add(letter + combination);
            }
        }
        return list;
    }
}
