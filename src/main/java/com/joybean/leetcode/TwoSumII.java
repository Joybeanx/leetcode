package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/">Two Sum II - Input Array Is Sorted</a>
 *
 * @author Joybean
 */
public class TwoSumII {
    /**
     * Binary search:Time Limit Exceeded
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (complement < numbers[i]) {
                continue;
            }
            int left = i;
            int right = numbers.length;
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (numbers[mid] == complement) {
                    return new int[] {i + 1, mid + 1};
                }
                if (numbers[mid] > complement) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
        }
        return null;
    }

    /**
     * Two pointers
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[] {left + 1, right + 1};
            }
            if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return null;
    }
}
