package com.joybean.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/candy/">Candy</a>
 *
 * @author Joybean
 */
public class Candy {
    /**
     * Greedy algorithm with PriorityQueue
     *
     * @param ratings
     * @return
     */
    public static int candy1(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> ratings[a]));
        for (int i = 0; i < n; i++) {
            pq.add(i);
        }
        while (!pq.isEmpty()) {
            int idx = pq.poll();
            int left = (idx == 0 || ratings[idx] == ratings[idx - 1]) ? 0 : candies[idx - 1];
            int right = (idx == n - 1 || ratings[idx] == ratings[idx + 1]) ? 0 : candies[idx + 1];
            candies[idx] = Math.max(left, right) + 1;
        }
        int ans = 0;
        for (int candy : candies) {
            ans += candy;
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/candy/solutions/42769/a-simple-solution/">O(n) Time(by SPRING_SNOW)</a>
     * TODO
     *
     * @param ratings
     * @return
     */
    public static int candy2(int[] ratings) {
        return 0;
    }

    /**
     * <a href="https://leetcode.com/problems/candy/solutions/2234434/c-o-n-time-o-1-space-full-explanation/">O(n) Time, O(1) Space</a>
     * TODO
     *
     * @param ratings
     * @return
     */
    public static int candy3(int[] ratings) {
        return 0;
    }
}
