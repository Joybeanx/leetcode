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
    public static int maxArea1(int[] height) {
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                ans = Math.max(Math.min(height[i], height[j]) * (j - i), ans);
            }
        }
        return ans;
    }

    /**
     * Two pointers: more code, less calculation.
     * <ul>
     *     <li>
     *         Moving pointer means we need recalculate the area and compare to current max area
     *     </li>
     *     <li>
     *          Moving the shorter line's pointer to the index of a longer line could turn out to be beneficial
     *     </li>
     * </ul>
     *
     * @param height
     * @return
     */
    public static int maxArea2(int[] height) {
        int ans = 0;
        int left = 0;
        int right = height.length - 1;
        do {
            int length = right - left;
            int minHeight;
            if (height[left] <= height[right]) {
                minHeight = height[left];
                //Find next index which value greater than current minHeight
                left = advance(height, left, true);
            } else {
                minHeight = height[right];
                // Find next index which value greater than current minHeight
                right = advance(height, right, false);
            }
            ans = Math.max(ans, minHeight * length);

        } while (left < right);
        return ans;
    }

    private static int advance(int[] height, int start, boolean left) {
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

    /**
     * Optimized two pointers
     *
     * @param height
     * @return
     */
    public static int maxArea3(int[] height) {
        int ans = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            ans = Math.max(ans, (right - left) * h);
            if (height[left] < height[right]) {
                for (left = left + 1; left < right && height[left] <= h; left++) {
                }
            } else {
                for (right = right - 1; left < right && height[right] <= h; right--) {
                }
            }
        }
        return ans;
    }

    /**
     * Two pointers: more calculation, less code
     *
     * @param height
     * @return
     */
    public static int maxArea4(int[] height) {
        int ans = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            ans = Math.max(ans, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/container-with-most-water/">Concise two pointers</a>
     *
     * @param height
     * @return
     */
    public static int maxArea5(int[] height) {
        int ans = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            ans = Math.max(ans, (right - left) * h);
            while (height[left] <= h && left < right) {
                left++;
            }
            while (height[right] <= h && left < right) {
                right--;
            }
        }
        return ans;
    }

}
