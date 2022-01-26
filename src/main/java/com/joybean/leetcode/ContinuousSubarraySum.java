package com.joybean.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/continuous-subarray-sum/">Continuous Subarray Sum</a>
 *
 * @author Joybean
 */
public class ContinuousSubarraySum {
    /**
     * Congruence modulo using array<br/>
     * Memory Limit Exceeded,case:[1000000000],1000000000
     *
     * @param nums
     * @param k
     * @return
     */
    public static boolean checkSubarraySum1(int[] nums, int k) {
        //remainders[i] stores the number of elements we processed when we find sum % k = i for the first time
        int[] remainders = new int[k];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            sum += num;
            int remainder = sum % k;
            if (remainder == 0 && i >= 1) {
                return true;
            }
            if (remainders[remainder] > 0) {
                if (i - remainders[remainder] >= 1) {
                    return true;
                }
            } else {
                remainders[remainder] = i + 1;
            }
        }
        return false;
    }

    /**
     * <a href="https://leetcode.com/problems/continuous-subarray-sum/discuss/99499/Java-O(n)-time-O(k)-space">Congruence
     * modulo using map</a>
     *
     * @param nums
     * @param k
     * @return
     */
    public static boolean checkSubarraySum2(int[] nums, int k) {
        //key:remainder,value:index
        Map<Integer, Integer> map = new HashMap<>();
        //base case,we should make sure the condition "i - prev > 1" is satisfied when remainder is 0
        map.put(0, -1);
        int runningSum = 0;
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            runningSum %= k;
            Integer prev = map.get(runningSum);
            if (prev != null) {
                if (i - prev > 1) {
                    return true;
                }
            } else {
                map.put(runningSum, i);
            }
        }
        return false;
    }
}
