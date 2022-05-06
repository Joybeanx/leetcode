package com.joybean.leetcode;

import java.util.Arrays;

/**
 * <a href="https://wentao-shao.gitbook.io/leetcode/two-pointers/1099.two-sum-less-than-k/">Two Sum Less Than K</a>
 *
 * @author Joybean
 */
public class TwoSumLessThanK {
    /**
     * <a href="https://lixinchengdu.github.io/algorithmbook/leetcode/two-sum-less-than-k.html">Two pointers</a>
     *
     * @param nums
     * @param k
     * @return
     */
    public static int twoSumLessThanK1(int[] nums, int k) {
        int ans = -1;
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum >= k) {
                right--;
            } else {
                ans = Math.max(sum, ans);
                left++;
            }

        }
        return ans;
    }
}
