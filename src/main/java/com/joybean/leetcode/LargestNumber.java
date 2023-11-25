package com.joybean.leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.com/problems/largest-number/">Largest Number</a>
 *
 * @author Joybean
 */
public class LargestNumber {
    public static String largestNumber1(int[] nums) {
        String[] strs = Arrays.stream(nums).boxed().map(String::valueOf).toArray(String[]::new);
        Arrays.sort(strs, (a, b) -> cmp(a, b));
        if (strs[0].equals("0")) {
            return "0";
        }
        return Arrays.stream(strs).collect(Collectors.joining());
    }

    private static int cmp(String a, String b) {
        if (a.length() == b.length()) {
            return b.compareTo(a);
        }
        int minLength = Math.min(a.length(), b.length());
        int cmpRes = b.substring(0, minLength).compareTo(a.substring(0, minLength));
        if (cmpRes != 0) {
            return cmpRes;
        }
        if (minLength == a.length()) {
            return cmp(a, b.substring(minLength, b.length()));
        }
        return cmp(a.substring(minLength, a.length()), b);
    }

    /**
     * <a href="https://leetcode.com/problems/largest-number/solutions/53158/my-java-solution-to-share/">Compare different concatenations</a>
     *
     * @param num
     * @return
     */
    public static String largestNumber2(int[] num) {
        String[] array = Arrays.stream(num).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(array, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        return Arrays.stream(array).reduce((x, y) -> x.equals("0") ? y : x + y).get();
    }
}
