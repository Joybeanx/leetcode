package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/minimum-number-of-food-buckets-to-feed-the-hamsters/description/">Minimum Number of Food Buckets to Feed the Hamsters</a>
 *
 * @author Joybean
 */
public class MinimumNumberOfFoodBucketsToFeedTheHamsters {
    /**
     * <a href="https://leetcode.com/problems/minimum-number-of-food-buckets-to-feed-the-hamsters/solutions/1599341/greedy/">Greedy algorithm</a>
     *
     * @param hamsters
     * @return
     */
    public static int minimumBuckets1(String hamsters) {
        int n = hamsters.length();
        char[] chars = hamsters.toCharArray();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] == 'H') {
                if (i > 0 && chars[i - 1] == 'B') {
                    continue;
                } else if (i + 1 < n && chars[i + 1] == '.') {
                    chars[i + 1] = 'B';
                    ans++;
                } else if (i > 0 && chars[i - 1] == '.') {
                    chars[i - 1] = 'B';
                    ans++;
                } else {
                    return -1;
                }
            }
        }
        return ans;
    }
}
