package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/split-array-largest-sum/">Split Array Largest Sum</a>
 *
 * @author Joybean
 */
public class SplitArrayLargestSum {

    /**
     * Binary search 1
     *
     * @param nums
     * @param m
     * @return
     */
    public static int splitArray1(int[] nums, int m) {
        int left = Integer.MIN_VALUE;
        int right = 0;
        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }
        //search range [left,right)
        while (left < right) {
            int mid = (left + right) >>> 1;
            int cnt = 1;
            int cur = 0;
            for (int num : nums) {
                cur += num;
                if (cur > mid) {
                    cur = num;
                    cnt++;
                }
            }
            if (cnt < m) {
                right = mid - 1;
            } else if (cnt > m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    /**
     * Binary search 2
     *
     * @param nums
     * @param m
     * @return
     */
    public static int splitArray2(int[] nums, int m) {
        int left = Integer.MIN_VALUE;
        int right = 0;
        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }
        //search range [left,right)
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (canSplit(nums, mid, m)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * <a href="https://leetcode.com/problems/split-array-largest-sum/discuss/89817/Clear-Explanation%3A-8ms-Binary
     * -Search-Java">Binary search 3</a>
     *
     * @param nums
     * @param m
     * @return
     */
    public static int splitArray3(int[] nums, int m) {
        int left = Integer.MIN_VALUE;
        int right = 0;
        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }
        //search range [left,right]
        while (left <= right) {
            int mid = (left + right) >>> 1;
            //Can array be split into m subarrays when max subarray sum is mid?
            if (canSplit(nums, mid, m)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean canSplit(int[] nums, int maxSubarraySum, int m) {
        int cnt = 1;
        int cur = 0;
        for (int num : nums) {
            cur += num;
            if (cur > maxSubarraySum) {
                cur = num;
                cnt++;
                if (cnt > m) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * DP
     * TODO
     *
     * @param nums
     * @param m
     * @return
     */
    public static int splitArray4(int[] nums, int m) {
        return 0;
    }
}
