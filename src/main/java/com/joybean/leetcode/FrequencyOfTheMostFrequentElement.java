package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/frequency-of-the-most-frequent-element/">Frequency of the Most Frequent
 * Element</a>
 *
 * @author Joybean
 */
public class FrequencyOfTheMostFrequentElement {
    /**
     * <a href="https://michael.blog.csdn.net/article/details/116130754">Binary search 1</a>
     * TODO
     *
     * @param nums
     * @param k
     * @return
     */
    public static int maxFrequency1(int[] nums, int k) {
        return 0;
    }
//    Wrong binary search
//    public static int maxFrequency(int[] nums, int k) {
//        Arrays.sort(nums);
//        int left = 0;
//        int right = nums.length - 1;
//        //search range [left,right)
//        while (left < right) {
//            int mid = (left + right + 1) >>> 1;
//            if (exceedNumOfOperations(nums, mid, k)) {
//                right = mid - 1;
//            } else {
//                left = mid;
//            }
//        }
//        return left + 1;
//    }
//
//    private static boolean exceedNumOfOperations(int[] nums, int targetIdx, int k) {
//        int cnt = 0;
//        for (int i = targetIdx - 1; i >= 0; i--) {
//            cnt += nums[targetIdx] - nums[i];
//            if (cnt > k) {
//                return true;
//            }
//        }
//        return false;
//    }

}
