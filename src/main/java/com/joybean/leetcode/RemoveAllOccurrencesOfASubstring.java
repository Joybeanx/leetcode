package com.joybean.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/remove-all-occurrences-of-a-substring/">Remove All Occurrences of a Substring</a>
 *
 * @author Joybean
 */
public class RemoveAllOccurrencesOfASubstring {
    /**
     * linked list solution
     *
     * @param s
     * @param part
     * @return
     */
    public static String removeOccurrences1(String s, String part) {
        LinkedList<Character> linkedList = new LinkedList<>();
        for (char c : s.toCharArray()) {
            linkedList.push(c);
            if (linkedList.size() >= part.length()) {
                List<Character> top = linkedList.subList(0, part.length());
                if (isMatch(top, part)) {
                    int i = 0;
                    while (i < part.length()) {
                        linkedList.pop();
                        i++;
                    }
                }
            }
        }
        String ans = "";
        for (Character character : linkedList) {
            ans = character + ans;
        }
        return ans;
    }

    private static boolean isMatch(List<Character> top, String part) {
        for (int i = 0; i < part.toCharArray().length; i++) {
            if (top.get(i) != part.charAt(part.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Stack solution
     *
     * @param s
     * @param part
     * @return
     */
    public static String removeOccurrences2(String s, String part) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            stack.push(c);
            if (stack.size() >= part.length()) {
                String popped = "";
                int i = 0;
                while (i < part.length() && stack.peek() == part.charAt(part.length() - 1 - i)) {
                    popped = stack.pop() + popped;
                    i++;
                }
                if (i != part.length()) {
                    for (Character p : popped.toCharArray()) {
                        stack.push(p);
                    }
                }
            }
        }
        String ans = "";
        for (Character character : stack) {
            ans += character;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(removeOccurrences2("daabcbaabcbc", "abc"));
    }

    /**
     * <a href="https://leetcode.com/problems/remove-all-occurrences-of-a-substring/solutions/1299275/true-o-n-m-kmp/">KMP</a>
     * TODO
     *
     * @param s
     * @param part
     * @return
     */
    public static String removeOccurrences3(String s, String part) {
        return null;
    }


//    https://leetcode.com/problems/remove-all-occurrences-of-a-substring/submissions/1106514890/
//    public static String removeOccurrences(String s, String part) {
//        if (s.length() < part.length()) {
//            return s;
//        }
//        Stack<String> stack = new Stack<>();
//        String prefix = "";
//        int i = 0;
//        for (Character c : s.toCharArray()) {
//            if (prefix.isEmpty() && !stack.isEmpty() && part.startsWith(stack.peek()) && part.charAt(stack.peek()
//                                                                                                          .length()) == c) {
//                String prevPrefix = stack.pop();
//                if (prevPrefix.length() + 1 != part.length()) {
//                    stack.push(prevPrefix + c);
//                }
//            } else if (i < part.length() && c == part.charAt(i)) {
//                prefix += c.toString();
//                i++;
//                if (prefix.length() == part.length()) {
//                    i = 0;
//                    prefix = "";
//                }
//            } else if (c == part.charAt(0)) {
//                if (!prefix.isEmpty()) {
//                    stack.push(prefix);
//                }
//                i = 1;
//                prefix = String.valueOf(part.charAt(0));
//            } else {
//                if (!prefix.isEmpty()) {
//                    stack.push(prefix);
//                    i = 0;
//                    prefix = "";
//                }
//                stack.push(c.toString());
//            }
//        }
//        String ans = prefix;
//        while (!stack.isEmpty()) {
//            ans = stack.pop() + ans;
//        }
//        return ans;
//    }

}
