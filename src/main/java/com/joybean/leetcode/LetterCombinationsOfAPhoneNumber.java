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
    /**
     * backtracking 1
     *
     * @param digits
     * @return
     */
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

    /**
     * backtracking 2
     *
     * @param digits
     * @return
     */
    public static List<String> letterCombinations2(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.isEmpty()) {
            return ans;
        }
        Map<Character, List<String>> map = new HashMap<>();
        map.put('2', Arrays.asList("a", "b", "c"));
        map.put('3', Arrays.asList("d", "e", "f"));
        map.put('4', Arrays.asList("g", "h", "i"));
        map.put('5', Arrays.asList("j", "k", "l"));
        map.put('6', Arrays.asList("m", "n", "o"));
        map.put('7', Arrays.asList("p", "q", "r", "s"));
        map.put('8', Arrays.asList("t", "u", "v"));
        map.put('9', Arrays.asList("w", "x", "y", "z"));
        backtrack("", 0, digits, map, ans);
        return ans;
    }

    private static void backtrack(String curPath, int offset, String digits,  Map<Character, List<String>> map,
        List<String> ans) {
        if (curPath.length() == digits.length()) {
            ans.add(curPath);
            return;
        }
        Character digit = digits.charAt(offset);
        for (String letter : map.get(digit)) {
            backtrack(curPath + letter, offset + 1, digits,  map, ans);
        }
    }

    private static final String[] LETTERS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    /**
     * backtracking 3: optimized version of letterCombinations2
     *
     * @param digits
     * @return
     */
    public static List<String> letterCombinations3(String digits) {
        //use LinkedList rather than ArrayList
        List<String> ans = new LinkedList<>();
        if (digits.isEmpty()) {
            return ans;
        }
        backtrack("", 0, digits,  ans);
        return ans;
    }

    private static void backtrack(String curPath, int offset, String digits, List<String> ans) {
        if (offset == digits.length()) {
            ans.add(curPath);
            return;
        }
        String letters = LETTERS[(digits.charAt(offset) - '0')];
        for (int i = 0; i < letters.length(); i++) {
            backtrack(curPath + letters.charAt(i), offset + 1, digits, ans);
        }
    }

    /**
     * FIFO queue
     *
     * @param digits
     * @return
     */
    public static List<String> letterCombinations4(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if (digits.isEmpty()) {
            return ans;
        }
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        while (ans.peek().length() != digits.length()) {
            String remove = ans.remove();
            String map = mapping[digits.charAt(remove.length()) - '0'];
            for (char c : map.toCharArray()) {
                ans.addLast(remove + c);
            }
        }
        return ans;
    }


















































    public List<String> letterCombinations(String digits) {

        List<String> ans = new ArrayList<>();
        if(digits.isEmpty()){
            return ans;
        }
        Map<Character, List<String>> map = new HashMap<>();
        map.put('2', Arrays.asList("a", "b", "c"));
        map.put('3', Arrays.asList("d", "e", "f"));
        map.put('4', Arrays.asList("g", "h", "i"));
        map.put('5', Arrays.asList("j", "k", "l"));
        map.put('6', Arrays.asList("m", "n", "o"));
        map.put('7', Arrays.asList("p", "q", "r", "s"));
        map.put('8', Arrays.asList("t", "u", "v"));
        map.put('9', Arrays.asList("w", "x", "y", "z"));
        letterCombinations("",0, map,digits, ans);
        return ans;
    }

    private void letterCombinations(String curPath, int startIdx, Map<Character, List<String>> map, String digits,
        List<String> ans) {
        if(curPath.length()==digits.length()){
            ans.add(curPath);
            return;
        }
        for (int i = startIdx; i < digits.length(); i++) {
            for(String s:map.get(digits.charAt(i))){
                letterCombinations(curPath+s,i+1,map,digits,ans);
            }
        }
    }

}
