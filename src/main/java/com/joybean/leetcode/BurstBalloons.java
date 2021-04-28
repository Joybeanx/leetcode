package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.com/problems/burst-balloons/">Burst Balloons</a>
 *
 * @author Joybean
 */
public class BurstBalloons {
    /**
     * Time Limit Exceeded
     *
     * @param nums
     * @return
     */
    public static int maxCoins1(int[] nums) {
        return maxCoinsInternal(Arrays.stream(nums).mapToObj(Integer::new).collect(Collectors.toList()),
            new HashMap<>());
    }

    private static int maxCoinsInternal(List<Integer> nums, Map<List<Integer>, Integer> memo) {
        if (nums.size() == 0) {
            return 0;
        }
        if (memo.containsKey(nums)) {
            return memo.get(nums);
        }
        int res = 0;
        for (int i = 0; i < nums.size(); i++) {
            int coins = nums.get(i) * ((i + 1) > nums.size() - 1 ? 1 : nums.get(i + 1)) * ((i - 1) < 0 ? 1
                : nums.get(i - 1));
            List<Integer> rest = new ArrayList<>(nums);
            rest.remove(i);
            res = Math.max(res, coins + maxCoinsInternal(rest, memo));
        }
        memo.put(nums, res);
        return res;
    }

    /**
     *
     * TODO
     *
     * @param nums
     * @return
     */
    public static int maxCoins2(int[] nums) {
        return 0;
    }
}