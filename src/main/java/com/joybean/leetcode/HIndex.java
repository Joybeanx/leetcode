package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/h-index/">H-Index</a>
 *
 * @author Joybean
 */
public class HIndex {
    /**
     * <a href="https://leetcode.com/problems/h-index/discuss/70768/Java-bucket-sort-O(n)
     * -solution-with-detail-explanation">Counting sort</a>
     *
     * @param citations
     * @return
     */
    public static int hIndex1(int[] citations) {
        int n = citations.length;
        int[] counter = new int[n + 1];
        for (int citation : citations) {
            if (citation >= n) {
                counter[n]++;
            } else {
                counter[citation]++;
            }
        }
        int total = 0;
        for (int i = n; i >= 0; i--) {
            total += counter[i];
            if (total >= i) {
                return i;
            }
        }
        return 0;
    }

    /**
     * <a href="https://leetcode.com/problems/h-index/discuss/70808/Simple-Java-solution-with-sort">Straight-forward
     * solution(by han35)</a>
     * TODO
     *
     * @param citations
     * @return
     */
    public static int hIndex2(int[] citations) {
        return 0;
    }
}
