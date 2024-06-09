package com.joybean.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/boats-to-save-people/">Boats to Save People</a>
 *
 * @author Joybean
 */
public class BoatsToSavePeople {
    /**
     * Two pointers
     *
     * @param people
     * @param limit
     * @return
     */
    public static int numRescueBoats1(int[] people, int limit) {
        int ans = 0;
        Arrays.sort(people);
        int i = 0;
        int j = people.length - 1;
        while (i < j) {
            if (people[i] + people[j] <= limit) {
                i++;
                j--;
            } else {
                j--;
            }
            ans++;
        }
        if (i == j) {
            ans++;
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/boats-to-save-people/solutions/1877945/java-c-a-very-easy-explanation
     * -trust-me/">Optimized two pointers</a>
     *
     * @param people
     * @param limit
     * @return
     */
    public static int numRescueBoats2(int[] people, int limit) {
        int ans = 0;
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        while (left <= right) {
            int sum = people[left] + people[right];
            if (sum <= limit) {
                ans++;
                left++;
                right--;
            } else {
                ans++;
                right--;
            }
        }
        return ans;
    }
}
