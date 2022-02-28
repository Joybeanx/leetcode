package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/binary-subarrays-with-sum/">Binary Subarrays With Sum</a>
 *
 * @author Joybean
 * @see SubarraySumEqualsK
 */
public class BinarySubarraysWithSum {
    /**
     * Prefix sum
     *
     * @param nums
     * @param goal
     * @return
     */
    public static int numSubarraysWithSum1(int[] nums, int goal) {
        int ans = 0;
        int[] count = new int[nums.length + 1];
        //base case
        count[0] = 1;
        int prefixSum = 0;
        for (int num : nums) {
            prefixSum += num;
            if (prefixSum >= goal) {
                ans += count[prefixSum - goal];
            }
            count[prefixSum]++;
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/binary-subarrays-with-sum/discuss/186683/C%2B%2BJavaPython-Sliding-Window-O(1)-Space">Sliding window</a>
     *
     * @param nums
     * @param goal
     * @return
     */
    public static int numSubarraysWithSum2(int[] nums, int goal) {
        //Calculate all subarrays less and equal to sum goal minus all subarrays less and equal to sum goal - 1
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    private static int atMost(int[] nums, int goal) {
        if (goal < 0) {
            return 0;
        }
        int left = 0;
        int sum = 0;
        int ans = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum > goal) {
                sum -= nums[left++];
            }
            //Number of subarrays ends with nums[right] and sum <= goal
            ans += right - left + 1;
        }
        return ans;
    }
}
