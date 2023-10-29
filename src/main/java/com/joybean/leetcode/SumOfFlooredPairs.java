package com.joybean.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/sum-of-floored-pairs/">Sum of Floored Pairs</a>
 *
 * @author Joybean
 */
public class SumOfFlooredPairs {
    /**
     * <a href="https://leetcode.com/problems/sum-of-floored-pairs/solutions/1210060/c-binary-search/?source=submission-noac">Binary search</a>
     *
     * @param nums
     * @return
     */
    public static int sumOfFlooredPairs1(int[] nums) {
        Arrays.sort(nums);
        int mod = (int) 1e9 + 7;
        long ans = 0L;
        long dup = 0;
        for (int i = 0; i < nums.length; i += dup) {
            int j = i + 1;
            while (j < nums.length && nums[j] == nums[j - 1]) {
                j++;
            }
            dup = j - i;
            ans = (ans + dup * dup) % mod;
            int prevj = j;
            while (j < nums.length) {
                int multiplier = nums[j] / nums[i];
                j = binarySearch(nums, (multiplier + 1) * nums[i], prevj);
                ans = (ans + (j - prevj) * multiplier * dup) % mod;
                prevj = j;
            }
        }
        return (int) ans;
    }

    /**
     * find lower bound
     *
     * @param nums
     * @param target
     * @param left
     * @return
     * @see BinarySearch#search4(int[], int)
     */
    private static int binarySearch(int[] nums, int target, int left) {
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    /**
     * Prefix sum
     * TODO
     *
     * @param nums
     * @return
     */
    public static int sumOfFlooredPairs2(int[] nums) {
        return 0;
    }
}
