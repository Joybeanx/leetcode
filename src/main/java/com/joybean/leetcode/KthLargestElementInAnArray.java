package com.joybean.leetcode;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * <a href="https://leetcode.com/problems/kth-largest-element-in-an-array/">Kth Largest Element in an Array</a>
 *
 * @author Joybean
 */
public class KthLargestElementInAnArray {
    /**
     * Quick select
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest1(int[] nums, int k) {
        partition1(nums, k, 0, nums.length - 1);
        return nums[k - 1];
    }

    private static void partition1(int[] nums, int k, int from, int to) {
        if (k - 1 < from || k - 1 > to) {
            return;
        }
        if (from >= to) {
            return;
        }
        //random partition pivot for better performance
        swap(from, new Random().nextInt(to - from + 1) + from, nums);
        int i = from + 1;
        int j = to;
        int t = nums[from];
        while (true) {
            while (i <= to && nums[i] >= t) {
                i++;
            }
            //j >= start not necessary
            while (nums[j] < t) {
                j--;
            }
            if (i > j) {
                break;
            }
            swap(i, j, nums);
        }
        swap(from, j, nums);
        partition1(nums, k, j + 1, to);
        partition1(nums, k, from, j - 1);
    }

    /**
     * <a href="https://leetcode.com/problems/kth-largest-element-in-an-array/solutions/60294/solution-explained/">Quick
     * select using Lomuto partition: possible TLE for case 40</a>
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest2(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int pivot = lomutoPartition(left, right, nums);
            if (pivot < n - k) {
                left = pivot + 1;
            } else if (pivot > n - k) {
                right = pivot - 1;
            } else {
                return nums[pivot];
            }
        }
        return -1;
    }

    private static int lomutoPartition(int start, int end, int[] nums) {
        //must not declare pivot as nums[(left + right) >>> 1]
        int pivot = nums[end];
        int j = start;
        for (int i = start; i < end; i++) {
            if (nums[i] < pivot) {
                swap(i, j++, nums);
            }
        }
        swap(j, end, nums);
        return j;
    }

    /**
     * Quick select using Hoare partition
     *
     * @param nums
     * @param k
     * @return
     * @see SortAnArray#sortArray3(int[])
     */
    public static int findKthLargest3(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k - 1);
    }

    static int quickSelect(int[] nums, int startIdx, int endIdx, int k) {
        if (startIdx == endIdx) {
            return nums[startIdx];
        }
        int pi = hoarePartition(nums, startIdx, endIdx);
        //should not return target if pi == k, since pivot is probably not at pi after partition
        // if(pi == k){
        //   return nums[pi];
        // }
        //target is in the right partition, should exclude pi because pi mustn't be a possible target index
        if (pi < k) {
            return quickSelect(nums, pi+1,  endIdx, k);
        }
        //target is in the left partition, should include pi because pi is a possible target index
        return quickSelect(nums, startIdx, pi, k);
    }

    private static int hoarePartition(int[] nums, int startIdx, int endIdx) {
        int left = startIdx - 1;
        int right = endIdx + 1;
        //or pivot = nums[left]
        //must not be pivot = nums[right],because it would cause infinite loop in some case,such as:[7, 5, 3, 1]
        int pivot =  nums[startIdx];
        while (true) {
            do {
                left++;
            } while (nums[left] > pivot);
            do {
                right--;
            } while (nums[right] < pivot);
            if (left >= right) {
                return right;
            }
            swap(left, right, nums);
        }
    }

    private static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * <a href="https://leetcode.com/problems/kth-largest-element-in-an-array/solutions/60294/solution-explained/">Priority Queue</a>
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest4(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue();
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();
    }

    public static int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int pivot = partition(nums, left, right);
            if (pivot < k - 1) {
                left = pivot + 1;
            } else if (pivot > k - 1) {
                right = pivot - 1;
            } else {
                return nums[pivot];
            }
        }
        return -1;
    }

    private static int partition(int[] nums, int startIdx, int endIdx) {
        int i = startIdx;
        int j = startIdx;
        while (i < endIdx) {
            if (nums[i] > nums[endIdx]) {
                swap(i, j++, nums);
            }
            i++;
        }
        swap(j, endIdx, nums);
        return j;
    }

}