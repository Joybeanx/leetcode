package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/count-number-of-nice-subarrays/">Count Number of Nice Subarrays</a>
 *
 * @author Joybean
 */
public class CountNumberOfNiceSubarrays {
    /**
     * Sliding window
     *
     * @param nums
     * @param k
     * @return
     */
    public static int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private static int atMost(int[] nums, int k) {
        int ans = 0;
        int left = 0;
        int odds = 0;
        for (int right = 0; right < nums.length; right++) {
            if ((nums[right] & 1) == 1) {
                odds++;
            }
            while (odds > k) {
                if ((nums[left++] & 1) == 1) {
                    odds--;
                }
            }
            ans += right - left + 1;
        }
        return ans;
    }
}
