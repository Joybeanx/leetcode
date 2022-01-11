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
            int cnt = 0;
            for (int distance : distances) {
                if (distance > mid) {
                    cnt += Math.ceil(distance / mid) - 1;
                }
            }
            if (cnt > k) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] stations1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] stations2 = {1, 5, 6, 9, 10, 15, 20, 21, 22, 30};
        int[] stations3 = {1, 2, 5, 9, 13, 18, 22, 30, 50, 52};
        System.out.println(minmaxGasDist1(stations1, 9));
        System.out.println(minmaxGasDist1(stations2, 3));
        System.out.println(minmaxGasDist1(stations3, 3));
    }
}
