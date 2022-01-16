package com.joybean.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * <a href="https://leetcode.com/problems/fair-candy-swap/">Fair Candy Swap</a>
 *
 * @author Joybean
 */
public class FairCandySwap {
    /**
     * @param aliceSizes
     * @param bobSizes
     * @return
     */
    public static int[] fairCandySwap1(int[] aliceSizes, int[] bobSizes) {
        Set<Integer> aliceSizeSet = new HashSet<>();
        int aliceSum = 0;
        for (int aliceSize : aliceSizes) {
            aliceSizeSet.add(aliceSize);
            aliceSum += aliceSize;
        }

        Set<Integer> bobSizeSet = new HashSet<>();
        int bobSum = 0;
        for (int bobSize : bobSizes) {
            bobSizeSet.add(bobSize);
            bobSum += bobSize;
        }
        int average = (aliceSum + bobSum) >>> 1;
        for (int aliceSize : aliceSizeSet) {
            if (aliceSum - aliceSize > average) {
                continue;
            }
            int requiredBobSize = average - aliceSum + aliceSize;
            if (bobSizeSet.contains(requiredBobSize)) {
                return new int[] {aliceSize, requiredBobSize};
            }
        }
        return null;
    }

    /**
     * <a href="https://leetcode.com/problems/fair-candy-swap/solution/">Solve the Equation</a>
     *
     * @param aliceSizes
     * @param bobSizes
     * @return
     */
    public static int[] fairCandySwap2(int[] aliceSizes, int[] bobSizes) {
        int dif = (IntStream.of(bobSizes).sum() - IntStream.of(aliceSizes).sum()) / 2;
        HashSet<Integer> set = new HashSet<>();
        for (int b : bobSizes) {
            set.add(b);
        }
        for (int a : aliceSizes) {
            if (set.contains(a + dif)) {
                return new int[] {a + dif, a};
            }
        }
        return null;
    }
}
