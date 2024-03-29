package com.joybean.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/fruit-into-baskets/">Fruit Into Baskets</a>
 *
 * @author Joybean
 */
public class FruitIntoBaskets {
    /**
     * Sliding window 1
     *
     * @param fruits
     * @return
     */
    public static int totalFruit1(int[] fruits) {
        int ans = 0;
        int left = 0;
        Map<Integer, Integer> windowCounts = new HashMap<>();
        for (int right = 0; right < fruits.length; right++) {
            windowCounts.merge(fruits[right], 1, Integer::sum);
            if (windowCounts.size() > 2) {
                ans = Math.max(right - left, ans);
            } else if (right == fruits.length - 1) {
                ans = Math.max(right - left + 1, ans);
            }
            while (windowCounts.size() > 2) {
                int count = windowCounts.get(fruits[left]);
                if (count > 1) {
                    windowCounts.put(fruits[left], --count);
                } else if (count == 1) {
                    windowCounts.remove(fruits[left]);
                }
                left++;
            }
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/fruit-into-baskets/discuss/170740/JavaC%2B%2BPython-Sliding-Window-for
     * -K-Elements">Concise sliding window</a>
     *
     * @param fruits
     * @return
     */
    public static int totalFruit2(int[] fruits) {
        int ans = 0;
        int left = 0;
        Map<Integer, Integer> windowCounts = new HashMap<>();
        for (int right = 0; right < fruits.length; right++) {
            windowCounts.merge(fruits[right], 1, Integer::sum);
            while (windowCounts.size() > 2) {
                windowCounts.merge(fruits[left], -1, Integer::sum);
                windowCounts.remove(fruits[left++], 0);
            }
            ans = Math.max(right - left + 1, ans);
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/fruit-into-baskets/discuss/170740/JavaC%2B%2BPython-Sliding-Window-for
     * -K-Elements">Optimized sliding window</a>
     *
     * @param fruits
     * @return
     */
    public static int totalFruit3(int[] fruits) {
        int left = 0;
        int right = 0;
        Map<Integer, Integer> windowCounts = new HashMap<>();
        for (right = 0; right < fruits.length; right++) {
            windowCounts.merge(fruits[right], 1, Integer::sum);
            if (windowCounts.size() > 2) {
                windowCounts.merge(fruits[left], -1, Integer::sum);
                windowCounts.remove(fruits[left++], 0);
            }
            // Possible result (the length of [left,right]) is always increasing, we don't need to do calculation
            // everytime. see xingHong's explanation.
        }
        // right = fruits.length
        return right - left;
    }

    /**
     * <a href="https://leetcode.com/problems/fruit-into-baskets/discuss/170745/Problem%3A-Longest-Subarray-With-2
     * -Elements">Longest Subarray With 2 Elements</a>
     * TODO
     *
     * @param fruits
     * @return
     */
    public static int totalFruit4(int[] fruits) {
        return 0;
    }
}
