package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/sort-colors/">Sort Colors</a>
 *
 * @author Joybean
 */
public class SortColors {
    /**
     * Counting sort
     *
     * @param nums
     */
    public static void sortColors1(int[] nums) {
        int[] counter = new int[3];
        for (int num : nums) {
            counter[num]++;
        }
        int i = 0;
        for (int j = 0; j < 3; j++) {
            int n = counter[j];
            while (n > 0) {
                nums[i++] = j;
                n--;
            }
        }
    }

    /**
     * <a href="https://leetcode.com/problems/sort-colors/solutions/26481/python-o-n-1-pass-in-place-solution-with-explanation/?orderBy=most_votes">Dutch national flag problem</a>
     *
     * @param nums
     */
    public static void sortColors2(int[] nums) {
        //[0,i),[i,cur),[cur,j],(j,nums.length-1]
        //red,white,unclassified,blue
        int i = 0;
        int j = nums.length - 1;
        int cur = 0;
        while (cur <= j) {
            if (nums[cur] == 0) {
                swap(i++, cur++, nums);
            } else if (nums[cur] == 2) {
                swap(j--, cur, nums);
            } else {
                cur++;
            }
        }
    }

    private static void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
