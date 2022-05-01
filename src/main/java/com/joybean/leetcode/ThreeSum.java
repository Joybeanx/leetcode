package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/3sum/">3Sum</a>
 *
 * @author Joybean
 */
public class ThreeSum {

    /**
     * Time exceed limit
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {
                List<Integer> list;
                if ((list = map.remove(nums[j])) != null) {
                    list.add(nums[j]);
                    list.sort(Comparator.naturalOrder());
                    if (!result.contains(list)) {
                        result.add(list);
                    }
                }
                List<Integer> elements = new ArrayList<>();
                elements.add(nums[i]);
                elements.add(nums[j]);
                map.put(-(nums[i] + nums[j]), elements);
            }
        }
        return result;
    }

    /**
     * Two pointers using set to avoid duplicates:concise but very slow
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        if (nums.length < 3) {
            return new ArrayList<>(ans);
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
                } else if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                }
            }
        }
        return new ArrayList<>(ans);
    }

    /**
     * Two pointers
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip equal elements to avoid duplicates
            if (i - 1 >= 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            // Two Pointers
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // Skip equal elements to avoid duplicates
                    while (left + 1 < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // Skip equal elements to avoid duplicates
                    while (right - 1 > left && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }

    /**
     * Two pointers
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum4(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];
            while (left < right) {
                int twoSum = nums[left] + nums[right];
                if (twoSum == target) {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (twoSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return ans;
    }

    /**
     * Use KSum template
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum5(int[] nums) {
        return KSum.kSum(nums, 3, 0);
    }
}