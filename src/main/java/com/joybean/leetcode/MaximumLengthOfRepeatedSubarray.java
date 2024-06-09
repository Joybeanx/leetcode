package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/maximum-length-of-repeated-subarray/">Maximum Length of Repeated Subarray</a>
 *
 * @author Joybean
 */
public class MaximumLengthOfRepeatedSubarray {
    /**
     * Iterative(bottom-up) DP
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int findLength1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int ans = 0;
        //dp[i][j] represents the length of the longest common subarray ending with nums[i-1] and nums[j-1]
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(dp[i][j], ans);
                }
            }
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/maximum-length-of-repeated-subarray/solutions/109039/concise-java-dp-same-idea-of-longest-common-substring/">Iterative(bottom-up) DP: space optimized (by shenhaizhilong)</a>
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int findLength2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int ans = 0;
        int dp[] = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            //must be reverse order
            for (int j = n; j >= 1; j--) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[j] = dp[j - 1] + 1;
                    ans = Math.max(dp[j], ans);
                } else {
                    //reset dp[j] calculated in (i-1)th loop
                    dp[j] = 0;
                }
            }
        }
        return ans;
    }
}
