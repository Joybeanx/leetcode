package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/container-with-most-water/">Container With Most Water</a>
 *
 * @author Joybean
 */
public class ContainerWithMostWater {

    /**
     * Brute Force
     *
     * @param height
     * @return
     */
    public int maxArea1(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                maxArea = Math.max(Math.min(height[i], height[j]) * (j - i), maxArea);
            }
        }
        return maxArea;
    }

    /**
     * Two pointers: more code, less calculation
     *
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        do {
            int length = right - left;
            int minHeight;
            if (height[left] <= height[right]) {
                minHeight = height[left];
                left = advance(height, left, true);
            } else {
                minHeight = height[right];
                right = advance(height, right, false);
            }
            maxArea = Math.max(maxArea, minHeight * length);

        } while (left < right);
        return maxArea;
    }

    /**
     * Two pointers: more calculation, less code
     *
     * @param height
     * @return
     */
    public int maxArea3(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxarea;
    }

    private int advance(int[] height, int start, boolean left) {
        int i = left ? start + 1 : start - 1;
        while (i < height.length && height[i] <= height[start]) {
            if (left) {
                i++;
            } else {
                i--;
            }
        }
        return i;
    }

}
