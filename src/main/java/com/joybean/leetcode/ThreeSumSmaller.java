package com.joybean.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/3sum-smaller/">3Sum Smaller</a>
 *
 * @author Joybean
 */
public class ThreeSumSmaller {
    /**
     * <a href="https://www.lintcode.com/problem/918/">Two pointers</a>
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int curSum = nums[i] + nums[left] + nums[right];
                if (curSum < target) {
                    //valid triplets: (nums[i],nums[left],nums[left+1...right])
                    ans += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }
        return ans;
    }
}
