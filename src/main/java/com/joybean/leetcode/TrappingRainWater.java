package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/trapping-rain-water">Trapping Rain Water</a>
 *
 * @author Joybean
 */
public class TrappingRainWater {
    /**
     * Iterative(bottom-up) DP
     *
     * @param height
     * @return
     */
    public static int trap1(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int n = height.length;
        //leftMaxHeights[i] represents the max height before index i
        int[] leftMaxHeights = new int[n];
        leftMaxHeights[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMaxHeights[i] = Math.max(leftMaxHeights[i - 1], height[i]);
        }
        //rightMaxHeights[i] represents the max height after index i
        int[] rightMaxHeights = new int[n];
        rightMaxHeights[n - 1] = height[n - 1];
        for (int j = n - 2; j >= 0; j--) {
            rightMaxHeights[j] = Math.max(rightMaxHeights[j + 1], height[j]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(leftMaxHeights[i], rightMaxHeights[i]) - height[i];
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/trapping-rain-water/solution/">Using two pointers</a>
     *
     * @param height
     * @return
     */
    public static int trap2(int[] height) {
        int ans = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        while (left <= right) {
            if (leftMax < rightMax) {
                if (height[left] < leftMax) {
                    ans += leftMax - height[left];
                } else {
                    leftMax = height[left];
                }
                left++;
            } else {
                if (height[right] < rightMax) {
                    ans += rightMax - height[right];
                } else {
                    rightMax = height[right];
                }
                right--;
            }
        }
        return ans;
    }

    /**
     * Monotonic stack
     * TODO
     *
     * @param height
     * @return
     */
    public static int trap3(int[] height) {
        return 0;
    }
}
