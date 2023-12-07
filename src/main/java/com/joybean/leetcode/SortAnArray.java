package com.joybean.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/sort-an-array/">Sort an Array</a>
 *
 * @author Joybean
 */
public class SortAnArray {
    /**
     * Quick sort:Hoare partition schema variant using more swaps
     *
     * @param nums
     * @return
     */
    public static int[] sortArray1(int[] nums) {
        quickSort1(nums, 0, nums.length - 1);
        return nums;
    }

    private static void quickSort1(int[] nums, int from, int to) {
        if (from >= to) {
            return;
        }
        int pi = partition1(nums, from, to);
        quickSort1(nums, from, pi - 1);
        quickSort1(nums, pi + 1, to);
    }

    private static int partition1(int[] nums, int from, int to) {
        int pivot = nums[from];
        int left = from;
        int right = to;
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            swap(nums, left, right);
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            swap(nums, left, right);
        }
        return left;
    }

    /**
     * <a href="https://leetcode.com/problems/sort-an-array/discuss/492042/7-Sorting-Algorithms-">Quick sort:Hoare
     * partition schema variant</a>
     *
     * @param nums
     * @return
     */
    public static int[] sortArray2(int[] nums) {
        quickSort2(nums, 0, nums.length - 1);
        return nums;
    }

    private static void quickSort2(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pi = partition2(nums, left, right);
        quickSort2(nums, left, pi);
        quickSort2(nums, pi + 1, right);
    }

    private static int partition2(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            //note the order of two iterations with different directions
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }

    /**
     * <a href="https://en.wikipedia.org/wiki/Quicksort">Quick sort:Standard hoare partition schema</a>
     *
     * @param nums
     * @return
     */
    public static int[] sortArray3(int[] nums) {
        quickSort3(nums, 0, nums.length - 1);
        return nums;
    }

    private static void quickSort3(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pi = partition3(nums, left, right);
        // Note: the pivot is now included
        quickSort3(nums, left, pi);
        quickSort3(nums, pi + 1, right);
    }

    private static int partition3(int[] nums, int left, int right) {
        int mid = (left + right) >>> 1;
        int pivot = nums[mid];
        int i = left - 1;
        int j = right + 1;
        while (true) {
            do {
                i++;
            } while (nums[i] < pivot);
            do {
                j--;
            } while (nums[j] > pivot);
            if (i >= j) {
                return j;
            }
            swap(nums, i, j);
        }
    }

    /**
     * Quick sort:Lomuto partition schema,Time Limit Exceeded
     *
     * @param nums
     * @return
     */
    public static int[] sortArray4(int[] nums) {
        quickSort4(nums, 0, nums.length - 1);
        return nums;
    }

    private static void quickSort4(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pi = partition4(nums, left, right);
        quickSort4(nums, left, pi - 1);
        quickSort4(nums, pi + 1, right);
    }

    private static int partition4(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;
        for (int j = left; j < right; j++) {
            // or <=
            if (nums[j] < pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, right);
        return i;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     * Merge sort:allocate new array in every merge
     *
     * @param nums
     * @return
     */
    public static int[] sortArray5(int[] nums) {
        return mergeSort1(nums, 0, nums.length - 1);
    }

    private static int[] mergeSort1(int[] nums, int left, int right) {
        if (left > right) {
            return new int[0];
        }
        if (left == right) {
            return new int[] {nums[left]};
        }
        int mid = (left + right) >> 1;
        int[] leftPart = mergeSort1(nums, left, mid);
        int[] rightPart = mergeSort1(nums, mid + 1, right);
        return merge1(leftPart, rightPart);
    }

    private static int[] merge1(int[] leftPart, int[] rightPart) {
        int[] merged = new int[leftPart.length + rightPart.length];
        int l = 0;
        int r = 0;
        int i = 0;
        while (l < leftPart.length && r < rightPart.length) {
            if (leftPart[l] <= rightPart[r]) {
                merged[i++] = leftPart[l++];
            } else {
                merged[i++] = rightPart[r++];
            }
        }
        while (l < leftPart.length) {
            merged[i++] = leftPart[l++];
        }
        while (r < rightPart.length) {
            merged[i++] = rightPart[r++];
        }
        return merged;
    }

    /**
     * Merge sort:only allocate one array
     *
     * @param nums
     * @return
     */
    public static int[] sortArray6(int[] nums) {
        int[] tmp = new int[nums.length];
        mergeSort2(nums, 0, nums.length - 1, tmp);
        return nums;
    }

    private static void mergeSort2(int[] nums, int start, int end, int[] tmp) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) >> 1;
        mergeSort2(nums, start, mid, tmp);
        mergeSort2(nums, mid + 1, end, tmp);
        merge2(nums, start, mid, end, tmp);
    }

    private static void merge2(int[] nums, int start, int mid, int end, int[] tmp) {
        int l = start;
        int r = mid + 1;
        int k = start;
        while (l <= mid && r <= end) {
            if (nums[l] <= nums[r]) {
                tmp[k++] = nums[l++];
            } else {
                tmp[k++] = nums[r++];
            }
        }
        while (l <= mid) {
            tmp[k++] = nums[l++];
        }
        while (r <= end) {
            tmp[k++] = nums[r++];
        }
        for (k = start; k <= end; k++) {
            nums[k] = tmp[k];
        }

    }

    /**
     * In-place merge sort
     * TODO
     *
     * @param nums
     * @return
     */
    public static int[] sortArray7(int[] nums) {
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArray6(new int[] {3, 2, 7, 6, 4})));
    }
}
