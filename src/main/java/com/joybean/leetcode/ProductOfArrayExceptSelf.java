package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/product-of-array-except-self/">Product of Array Except Self</a>
 *
 * @author Joybean
 */
public class ProductOfArrayExceptSelf {
    /**
     * Prefix & Suffix product
     *
     * @param nums
     * @return
     */
    public static int[] productExceptSelf1(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            //ans[i] represents the product of nums[0...i-1]
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] *= right;
            right *= nums[i];
        }
        return ans;
    }
}
