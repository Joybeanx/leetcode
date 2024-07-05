package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/">Find All Numbers Disappeared in an
 * Array</a>
 *
 * @author Joybean
 */
public class FindAllNumbersDisappearedInAnArray {
    /**
     * Straight forward
     *
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers1(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        int j = 0;
        for (int i = 1; i <= n; i++) {
            if (j < n && nums[j] == i) {
                do {
                    j++;
                } while (j < n && nums[j] == i);
            } else {
                ans.add(i);
            }
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/target-sum/solutions/97334/java-15-ms-c-3-ms-o-ns-iterative-dp-solution
     * -using-subset-sum-with-explanation/">Mark as seen by Negation</a>
     *
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers2(int[] nums) {
        for (int num : nums) {
            if (nums[Math.abs(num) - 1] > 0) {
                nums[Math.abs(num) - 1] = -nums[Math.abs(num) - 1];
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ans.add(i + 1);
            }

        }
        return ans;
    }
}
