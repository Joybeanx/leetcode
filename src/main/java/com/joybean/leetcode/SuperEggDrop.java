package com.joybean.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/super-egg-drop/>Super Egg Drop</a>
 *
 * @author Joybean
 */
public class SuperEggDrop {
    /**
     * Recursive(top-down) DP with memo
     * @param k
     * @param n
     * @return
     */
    public static int superEggDrop(int k, int n) {
        return superEggDropInternal(k, n, new HashMap<>());
    }

    public static int superEggDropInternal(int k, int n, Map<List<Integer>, Integer> memo) {
        if (n == 0) {
            return 0;
        }
        if (k == 1) {
            return n;
        }
        if (memo.containsKey(Arrays.asList(k, n))) {
            return memo.get(Arrays.asList(k, n));
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            res = Math.min(Math.max(superEggDropInternal(k - 1, i - 1, memo), superEggDropInternal(k, n - i, memo)) + 1,
                res);
        }
        memo.put(Arrays.asList(k, n), res);
        return res;
    }
}
