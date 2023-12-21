package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/height-checker/">Height Checker</a>
 *
 * @author Joybean
 */
public class HeightChecker {
    /**
     * Bucket sort
     *
     * @param heights
     * @return
     */
    public static int heightChecker1(int[] heights) {
        int[] heightCounter = new int[101];
        for (int height : heights) {
            heightCounter[height] += 1;
        }
        int ans = 0;
        int i = 0;
        for (int curHeight = 0; curHeight < heightCounter.length; curHeight++) {
            int count = heightCounter[curHeight];
            if (count == 0) {
                continue;
            }
            int k = i + count;
            for (; i < k; i++) {
                if (heights[i] != curHeight) {
                    ans++;
                }
            }
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/height-checker/solutions/300472/java-0ms-o-n-solution-no-need-to-sort/">Bucket sort</a>
     *
     * @param heights
     * @return
     */
    public static int heightChecker2(int[] heights) {
        int[] heightCounter = new int[101];
        for (int height : heights) {
            heightCounter[height] += 1;
        }
        int ans = 0;
        int curHeight = 0;
        for (int i = 0; i < heights.length; i++) {
            while (heightCounter[curHeight] == 0) {
                curHeight++;
            }
            if (curHeight != heights[i]) {
                ans++;
            }
            heightCounter[curHeight]--;
        }
        return ans;
    }
}
