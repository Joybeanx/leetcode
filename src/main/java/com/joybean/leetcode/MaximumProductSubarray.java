package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/maximum-product-subarray/description/">Maximum Product Subarray</a>
 *
 * @author Joybean
 */
public class MaximumProductSubarray {
    /**
     * Terrible solution:partition and compact original array,and then compute maximum product
     *
     * @param nums
     * @return
     */
    public static int maxProduct1(int[] nums) {
        int max = Arrays.binarySearch(nums, 0) < 0 ? nums[0] : 0;
        String concated = Arrays.toString(nums);
        //Partition by 0 on concatenated string
        for (String partition : concated.substring(1, concated.length() - 1).split("(?<!\\d)0(?!\\d)")) {
            //Store negative numbers and product split by negative
            List<Integer> compact = new ArrayList<Integer>();
            int firstNgtIdx = -1;
            int lastNgtIdx = -1;
            int countOfNgtNum = 0;
            int product = 1;
            int i = 0;
            boolean f = false;
            //convert partition to array
            for (String ns : partition.split(",")) {
                if (ns.trim().length() > 0) {
                    int num = Integer.parseInt(ns.trim());
                    if (num < 0) {
                        if (f) {
                            compact.add(product);
                        }
                        compact.add(num);
                        if (firstNgtIdx == -1) {
                            firstNgtIdx = compact.size() - 1;
                        }
                        lastNgtIdx = compact.size() - 1;
                        product = 1;
                        countOfNgtNum++;
                        f = false;
                    } else {
                        product *= num;
                        f = true;
                    }
                    i++;
                }
            }
            if (f) {
                compact.add(product);
            }
            //Compute maximum product among partition,and compare with current maximum product
            max = Math.max(max, getMax(compact, countOfNgtNum, firstNgtIdx, lastNgtIdx));
        }
        return max;
    }

    private static int getMax(List<Integer> compact, int countOfNgtNum, int firstNgtIdx, int lastNgtIdx) {
        switch (compact.size()) {
            case 0:
                return 0;
            case 1:
                return compact.get(0);
        }
        //If count of negative numbers is even,multiply all of numbers
        if ((countOfNgtNum & 1) == 0) {
            int _max = 1;
            for (int c : compact) {
                _max *= c;
            }
            return _max;
        }
        //If count of negative numbers is odd, possible maximum product in this partition is either multiply from start index to the last index of negative number(exclusive)
        //or from end index to the first index of negative number(exclusive)
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int n = 0; n < lastNgtIdx; n++) {
            max1 = max1 == Integer.MIN_VALUE ? compact.get(n) : max1 * compact.get(n);
        }
        for (int n = compact.size() - 1; n > firstNgtIdx; n--) {
            max2 = max2 == Integer.MIN_VALUE ? compact.get(n) : max2 * compact.get(n);
        }
        return Math.max(max1, max2);
    }

    /**
     * DP solution
     *
     * @param nums
     * @return
     */
    public static int maxProduct2(int nums[]) {
        // store the result that is the max we have found so far
        int r = nums[0];

        // imax/imin stores the max/min product of
        // subarray that ends with the current number A[i]
        for (int i = 1, imax = r, imin = r; i < nums.length; i++) {
            // multiplied by a negative makes big number smaller, small number bigger
            // so we redefine the extremums by swapping them
            if (nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }

            // max/min product for the current number is either the current number itself
            // or the max/min by the previous number times the current one
            imax = Math.max(nums[i], imax * nums[i]);
            imin = Math.min(nums[i], imin * nums[i]);

            // the newly computed max value is a candidate for our global result
            r = Math.max(r, imax);
        }
        return r;
    }

    public static int maxProduct3(int nums[]) {
        {
            int maxEnd = nums[0];
            int minEnd = nums[0];
            int maxResult = nums[0];
            for (int i = 1; i < nums.length; ++i) {
                int end1 = maxEnd * nums[i], end2 = minEnd * nums[i];
                maxEnd = Math.max(Math.max(end1, end2), nums[i]);
                minEnd = Math.min(Math.min(end1, end2), nums[i]);
                maxResult = Math.max(maxResult, maxEnd);
            }
            return maxResult;
        }
    }

    /**
     * Kadane's algorithm
     * TODO
     *
     * @param nums
     * @return
     */
    public static int maxProduct4(int nums[]) {
        return 0;
    }
}
