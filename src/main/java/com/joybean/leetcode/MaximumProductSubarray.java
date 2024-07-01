package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/maximum-product-subarray/">Maximum Product Subarray</a>
 *
 * @author Joybean
 */
public class MaximumProductSubarray {
    /*
    //wrong solution, cannot handle the case when nums contains 0
    public static int maxProduct(int nums[]) {
        int n = nums.length;
        int[] prefixProduct = new int[n + 1];
        prefixProduct[0] = 1;
        for (int i = 1; i <= n; i++) {
            prefixProduct[i] = prefixProduct[i - 1] * nums[i - 1];
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                ans = Math.max(prefixProduct[i - 1] == 0 ? 0 : (prefixProduct[j] / prefixProduct[i - 1]), ans);
            }
        }
        return ans;
    }
    */

    /**
     * partition and compact original array,and then compute maximum product
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
        //If count of negative numbers is odd, possible maximum product in this partition is either multiply from
        // start index to the last index of negative number(exclusive)
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
     * <a
     * href="https://leetcode.com/problems/maximum-product-subarray/solutions/183483/java-c-python-it-can-be-more
     * -simple/">Calculate prefix product and suffix product</a>
     *
     * @param nums
     * @return
     */
    public static int maxProduct2(int nums[]) {
        int n = nums.length;
        //we should use double rather than long or int to avoid overflow: [0,10,10,10,10,10,10,10,10,10,-10,10,10,10,10,10,10,10,10,10,0]
        double lmax = 1;
        double rmax = 1;
        Double ans = -Double.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            lmax = (lmax == 0 ? 1 : lmax) * nums[i];
            rmax = (rmax == 0 ? 1 : rmax) * nums[n - i - 1];
            ans = Math.max(Math.max(lmax, rmax), ans);
        }
        return ans.intValue();
    }

    /**
     * <a href="https://leetcode.cn/problems/maximum-product-subarray/solutions/69381/dpfang-fa-xiang-jie-by-yang-cong-12/">DP solution</a>
     *
     * @param nums
     * @return
     */
    public static int maxProduct3(int nums[]) {
        int n = nums.length;
        //we should use double rather than long or int to avoid overflow: [0,10,10,10,10,10,10,10,10,10,-10,10,10,10,10,10,10,10,10,10,0]
        double min = nums[0];
        double max = nums[0];
        Double ans = Double.valueOf(nums[0]);
        for (int i = 1; i < n; i++) {
            double tmpMin = min;
            //next min may be any of these cases: num[i]， num[i] * preMin，num[i] * preMax
            min = Math.min(Math.min(nums[i] * min, nums[i]), nums[i] * max);
            //next max may be any of these cases: num[i]， num[i] * preMax，num[i] * preMin
            max = Math.max(Math.max(nums[i] * max, nums[i]), nums[i] * tmpMin);
            ans = Math.max(max, ans);
        }
        return ans.intValue();
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
