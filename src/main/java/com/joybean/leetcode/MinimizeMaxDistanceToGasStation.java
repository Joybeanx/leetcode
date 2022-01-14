package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/minimize-max-distance-to-gas-station/">Minimize Max Distance to Gas
 * Station</a>
 *
 * @author Joybean
 */
public class MinimizeMaxDistanceToGasStation {

    /**
     * <a href="https://www.programmerall.com/article/5617775644/">Binary search</a>
     *
     * @param stations
     * @param k
     * @return
     */
    public static double minmaxGasDist1(int[] stations, int k) {
        double left = 0;
        double right = 0;
        int[] distances = new int[stations.length - 1];
        for (int i = 1; i < stations.length; i++) {
            distances[i - 1] = stations[i] - stations[i - 1];
        }
        right = stations[stations.length - 1] - stations[0];
        //left + 1e-6 <= right
        while (left + 1e-6 < right) {
            double mid = left + (right - left) / 2;
            if (helper(distances, mid, k)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private static boolean helper(int[] distances, double mid, int k) {
        int cnt = 0;
        for (int distance : distances) {
            if (distance > mid) {
                cnt += Math.ceil(distance / mid) - 1;
                if (cnt > k) {
                    return true;
                }
            }
        }
        return false;
    }
}
