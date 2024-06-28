package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/product-of-array-except-self/">Product of Array Except Self</a>
 *
 * @author Joybean
 */
public class ProductOfArrayExceptSelf {

    /**
     * Prefix & Suffix product: O(n) space
     *
     * @param nums
     * @return
     */
    public static int[] productExceptSelf1(int[] nums) {
        int n = nums.length;
        int[] prefixProduct = new int[n];
        prefixProduct[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixProduct[i] = prefixProduct[i - 1] * nums[i];
        }

        int[] suffixProduct = new int[n];
        suffixProduct[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixProduct[i] = suffixProduct[i + 1] * nums[i];
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = (i == 0 ? 1 : prefixProduct[i - 1]) * (i == n - 1 ? 1 : suffixProduct[i + 1]);
        }
        return ans;
    }

    /**
     * Prefix & Suffix product: O(n) space
     *
     * @param nums
     * @return
     */
    public static int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        int suffixProduct = 1;
        for (int i = n - 2; i >= 0; i--) {
            suffixProduct *= nums[i + 1];
            ans[i] *= suffixProduct;

        }
        return ans;
    }

    /**
     * Prefix & Suffix product: O(1) space
     *
     * @param nums
     * @return
     */
    public static int[] productExceptSelf3(int[] nums) {
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
