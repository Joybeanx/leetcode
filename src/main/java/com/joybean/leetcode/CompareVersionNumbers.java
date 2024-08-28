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
     * <a href="https://leetcode.com/problems/compare-version-numbers/solutions/50788/my-java-solution-without-split/">Convert revision to number</a>
     *
     * @param version1
     * @param version2
     * @return
     */
    public static int compareVersion2(String version1, String version2) {
        int m = version1.length();
        int n = version2.length();
        int i = 0;
        int j = 0;
        while (i < m || j < n) {
            Integer revision1 = 0;
            Integer revision2 = 0;
            while (i < m && version1.charAt(i) != '.') {
                revision1 = revision1 * 10 + (version1.charAt(i++) - '0');
            }
            while (j < n && version2.charAt(j) != '.') {
                revision2 = revision2 * 10 + (version2.charAt(j++) - '0');
            }
            if (revision1 != revision2) {
                return revision1.compareTo(revision2);
            }
            i++;
            j++;
        }
        return 0;
    }
}
