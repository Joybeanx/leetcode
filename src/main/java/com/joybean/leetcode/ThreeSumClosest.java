package com.joybean.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/3sum-closest/">3Sum Closest</a>
 *
 * @author Joybean
 */
public class ThreeSumClosest {
    /**
     * Two pointers
     *
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest1(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 10000000;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int sum = findClosestSum(nums, i, target);
            if (sum == target) {
                return sum;
            }
            if (Math.abs(ans - target) > Math.abs(sum - target)) {
                ans = sum;
            }

        }
        return ans;
    }

    private static int findClosestSum(int[] nums, int start, int target) {
        int left = start + 1;
        int right = nums.length - 1;
        int minDiff = Integer.MAX_VALUE;
        int ans = 0;
        while (left < right) {
            int curSum = nums[start] + nums[left] + nums[right];
            if (curSum == target) {
                return curSum;
            } else if (curSum < target) {
                left++;
            } else {
                right--;
            }
            int curDiff = Math.abs(curSum - target);
            if (curDiff < minDiff) {
                ans = curSum;
                minDiff = curDiff;
            }
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/3sum-closest/discuss/7872/Java-solution-with-O(n2)-for-reference">Concise
     * two pointers</a>
     *
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = nums[0] + nums[1] + nums[n - 1];
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int curSum = nums[i] + nums[left] + nums[right];
                if (curSum == target) {
                    return curSum;
                }
                if (curSum < target) {
                    left++;
                } else {
                    right--;
                }
                if (Math.abs(ans - target) > Math.abs(curSum - target)) {
                    ans = curSum;
                }
            }
        }
        return ans;
    }
}
