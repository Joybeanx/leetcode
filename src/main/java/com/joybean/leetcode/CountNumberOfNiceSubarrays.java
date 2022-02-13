package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/count-number-of-nice-subarrays/">Count Number of Nice Subarrays</a>
 *
 * @author Joybean
 */
public class CountNumberOfNiceSubarrays {

    /**
     * <a href="https://leetcode.com/problems/count-number-of-nice-subarrays/discuss/419483/Subarray-Sum-Equals-K">Prefix sum</a>
     * TODO
     *
     * @param nums
     * @param k
     * @return
     */
    public static int numberOfSubarrays1(int[] nums, int k) {
        return 0;
    }

    /**
     * Two-pass sliding window
     *
     * @param nums
     * @param k
     * @return
     */
    public static int numberOfSubarrays2(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private static int atMost(int[] nums, int k) {
        int ans = 0;
        int left = 0;
        int odds = 0;
        for (int right = 0; right < nums.length; right++) {
            odds += nums[right] & 1;
            while (odds > k) {
                odds -= nums[left++] & 1;
            }
            ans += right - left + 1;
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/count-number-of-nice-subarrays/discuss/508217/C%2B%2B%3A-Visual-explanation.-O(1)-space.-Two-pointers">One-pass sliding window 1</a>
     * TODO
     *
     * @param nums
     * @param k
     * @return
     */
    public static int numberOfSubarrays3(int[] nums, int k) {
        return 0;
    }

    /**
     * <a href="https://leetcode.com/problems/count-number-of-nice-subarrays/discuss/419378/JavaC%2B%2BPython-Sliding-Window-O(1)-Space">One-pass sliding window 2</a>
     *
     * @param nums
     * @param k
     * @return
     */
    public static int numberOfSubarrays4(int[] nums, int k) {
        int ans = 0;
        int left = 0;
        int odds = 0;
        int count = 0;
        for (int right = 0; right < nums.length; right++) {
            if ((nums[right] & 1) == 1) {
                odds++;
                count = 0;
            }
            while (odds == k) {
                odds -= nums[left++] & 1;
                count++;
            }
            ans += count;
        }
        return ans;
    }
}
