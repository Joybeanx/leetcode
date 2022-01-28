package com.joybean.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/grid-game/">Grid Game</a>
 *
 * @author Joybean
 */
public class GridGame {
    /**
     * <a href="https://leetcode.com/problems/grid-game/discuss/1486340/C%2B%2BJavaPython-Robot1-Minimize-TopSum-and
     * -BottomSum-of-Robot-2-Picture-Explained">Prefix sum</a>
     *
     * @param grid
     * @return
     */
    public static long gridGame1(int[][] grid) {
        long topSum = Arrays.stream(grid[0]).asLongStream().sum();
        long bottomSum = 0;
        long ans = Long.MAX_VALUE;

        for (int i = 0; i < grid[0].length; i++) {
            topSum -= grid[0][i];
            //bottomSum += (i == 0 ? 0 : grid[1][i - 1]);
            //ans = Math.min(ans, Math.max(topSum, bottomSum));
            //Much better than above code
            ans = Math.min(ans, Math.max(topSum, bottomSum));
            bottomSum += grid[1][i];
        }
        return ans;
    }

}
