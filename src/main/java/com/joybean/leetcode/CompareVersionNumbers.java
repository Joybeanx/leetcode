package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/compare-version-numbers/">Compare Version Numbers</a>
 *
 * @author Joybean
 */
public class CompareVersionNumbers {
    /**
     * Straight forward using Integer.parseInt()
     *
     * @param version1
     * @param version2
     * @return
     */
    public static int compareVersion1(String version1, String version2) {
        int i = 0;
        int j = 0;
        while (i < version1.length() && j < version2.length()) {
            String rv1 = "";
            String rv2 = "";
            while (i < version1.length() && version1.charAt(i) != '.') {
                rv1 += version1.charAt(i++);
            }
            while (j < version2.length() && version2.charAt(j) != '.') {
                rv2 += version2.charAt(j++);
            }
            Integer parsedRv1 = Integer.parseInt(rv1);
            Integer parsedRv2 = Integer.parseInt(rv2);
            if (parsedRv1 == parsedRv2) {
                if (i == version1.length() && j == version2.length()) {
                    return 0;
                }
                i++;
                j++;
                continue;
            }
            return parsedRv1.compareTo(parsedRv2);
        }
        if (i >= version1.length()) {
            return containsTailingZero(version2, j) ? 0 : -1;
        }
        return containsTailingZero(version1, i) ? 0 : 1;
    }

    public static boolean containsTailingZero(String version, int start) {
        for (int i = start; i < version.length(); i++) {
            if (version.charAt(i) != '.' && version.charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }

    /**
     * <a href="https://leetcode.com/problems/compare-version-numbers/solutions/50788/my-java-solution-without-split/">char to int</a>
     *
     * @param version1
     * @param version2
     * @return
     */
    public static int compareVersion2(String version1, String version2) {
        int i = 0;
        int j = 0;
        while (i < version1.length() || j < version2.length()) {
            int rversion1 = 0;
            int rversion2 = 0;
            while (i < version1.length() && version1.charAt(i) != '.') {
                rversion1 = rversion1 * 10 + version1.charAt(i++) - '0';
            }
            while (j < version2.length() && version2.charAt(j) != '.') {
                rversion2 = rversion2 * 10 + version2.charAt(j++) - '0';
            }
            if (rversion1 < rversion2) {
                return -1;
            } else if (rversion1 > rversion2) {
                return 1;
            } else {
                i++;
                j++;
            }
        }
        return 0;
    }
}
