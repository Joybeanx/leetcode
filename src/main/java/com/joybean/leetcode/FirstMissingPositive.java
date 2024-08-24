package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/first-missing-positive/">First Missing Positive</a>
 *
 * @author Joybean
 */
public class FirstMissingPositive {
    /**
     * use seen array
     * TODO
     *
     * @param nums
     * @return
     */
    public static int firstMissingPositive1(int[] nums) {
        return 0;
    }

    /**
     * <a href="https://leetcode.com/problems/first-missing-positive/editorial/">Cycle Sort</a>
     * The first missing positive number must be within [1, n+1].
     * The basic idea is to traversal and try to move the current value v to position whose index is v-1.
     * Then traversal again to find the first unusual value, which can not be corresponding to its index.
     *
     * @param nums
     * @return
     */
    public static int firstMissingPositive2(int[] nums) {

        int i = 0;
        while (i < nums.length) {
            // If the current value is in the range of [1,length] and it's not at its correct position,
            // swap it to its correct position.
            if (nums[i] >= 1 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }
        int k = 0;
        while (k < nums.length && nums[k] == k + 1) {
            k++;
        }
        return k + 1;
    }

    /**
     * <a href="https://leetcode.com/problems/first-missing-positive/solutions/17071/my-short-c-solution-o-1-space-and-o-n-time/">Cycle Sort</a>
     *
     * @param nums
     * @return
     */
    public static int firstMissingPositive3(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            //unnecessary because we don't swap when nums[i] != nums[nums[i] - 1]
            //if (nums[i] == i + 1) {
            //    continue;
            //}

            //use nums[i] != nums[nums[i] - 1] to avoid dead loop, case: [1,1]
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                swap(nums, nums[i] - 1, i);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }


    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
