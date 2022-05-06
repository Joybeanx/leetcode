package com.joybean.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/3sum-with-multiplicity/">3Sum With Multiplicity</a>
 *
 * @author Joybean
 */
public class ThreeSumWithMultiplicity {
    /**
     * Two pointers：Time Limit Exceeded
     *
     * @param arr
     * @param target
     * @return
     */
    public static int threeSumMulti1(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;
        long ans = 0;
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int curSum = arr[i] + arr[left] + arr[right];
                if (curSum == target) {
                    int duplicates = 1;
                    for (int j = right - 1; j > left; j--) {
                        if (arr[right] == arr[j]) {
                            duplicates++;
                        } else {
                            break;
                        }
                    }
                    ans += duplicates;
                    left++;
                } else if (curSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return (int)(ans % (1e9 + 7));
    }

    /**
     * Optimized two pointers:use first occurrence index array
     *
     * @param arr
     * @param target
     * @return
     */
    public static int threeSumMulti2(int[] arr, int target) {
        Arrays.sort(arr);
        int[] firstOccurIdx = new int[101];
        for (int i = 1; i < arr.length; i++) {
            if (firstOccurIdx[arr[i]] == 0) {
                firstOccurIdx[arr[i]] = i;
            }
        }
        firstOccurIdx[arr[0]] = 0;
        int n = arr.length;
        long ans = 0;
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int curSum = arr[i] + arr[left] + arr[right];
                if (curSum == target) {
                    int duplicates;
                    if (firstOccurIdx[arr[right]] > left) {
                        duplicates = right - firstOccurIdx[arr[right]] + 1;
                    } else {
                        duplicates = right - left;
                    }
                    ans += duplicates;
                    left++;
                } else if (curSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return (int)(ans % (1e9 + 7));
    }

    /**
     * <a href="https://leetcode.com/problems/3sum-with-multiplicity/solution/">Optimized two pointers:skip
     * duplicates</a>
     *
     * @param arr
     * @param target
     * @return
     */
    public static int threeSumMulti3(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;
        long ans = 0;
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int curSum = arr[i] + arr[left] + arr[right];
                if (curSum < target) {
                    left++;
                } else if (curSum > target) {
                    right--;
                } else if (arr[left] != arr[right]) {
                    int leftDuplicates = 1;
                    //calculate left duplicates
                    while (left + 1 < right && arr[left] == arr[left + 1]) {
                        left++;
                        leftDuplicates++;
                    }
                    int rightDuplicates = 1;
                    //calculate right duplicates
                    while (right - 1 > left && arr[right] == arr[right - 1]) {
                        right--;
                        rightDuplicates++;
                    }
                    ans += leftDuplicates * rightDuplicates;
                    left++;
                    right--;
                } else {
                    // M = k - j + 1
                    // We contributed M * (M-1) / 2 pairs.
                    ans += (right - left + 1) * (right - left) / 2;
                    break;
                }
            }
        }
        return (int)(ans % (1e9 + 7));
    }

    /**
     * <a href="https://leetcode.com/problems/3sum-with-multiplicity/discuss/181131/C%2B%2BJavaPython-O(N-%2B-101-*-101)">Optimized
     * two pointers:handle different duplicate cases</a>
     * TODO
     *
     * @param arr
     * @param target
     * @return
     */
    public static int threeSumMulti4(int[] arr, int target) {
        return 0;
    }
}
