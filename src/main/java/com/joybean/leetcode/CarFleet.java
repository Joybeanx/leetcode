package com.joybean.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.com/problems/car-fleet/">Car Fleet</a>
 *
 * @author Joybean
 */
public class CarFleet {
    /**
     * <a href="https://leetcode.com/problems/car-fleet/discuss/139850/C%2B%2BJavaPython-Straight-Forward">Straight
     * forward</a>
     *
     * @param target
     * @param position
     * @param speed
     * @return
     */
    public static int carFleet1(int target, int[] position, int[] speed) {
        double[][] arr = new double[position.length][2];
        for (int i = 0; i < position.length; i++) {
            arr[i] = new double[] {position[i], (target - position[i]) / (double)speed[i]};
        }
        Arrays.sort(arr, Comparator.comparing(a -> a[0]));
        int ans = 0;
        //arrival time of each fleet
        double arrivalTime = 0;
        //Calculate from end to start
        for (int i = arr.length - 1; i >= 0; i--) {
            //Current car is unable to catch up with previous fleet,so it should be in a new fleet
            if (arr[i][1] > arrivalTime) {
                arrivalTime = arr[i][1];
                ans++;
            }
        }
        return ans;
    }


   /* public static int carFleet2(int target, int[] position, int[] speed) {
        double[][] arr = new double[position.length][2];
        for (int i = 0; i < position.length; i++) {
            arr[i] = new double[] {position[i], (target - position[i]) / (double)speed[i]};
        }
        Arrays.sort(arr, Comparator.comparing(a -> a[0]));
        int ans = 0;
        double arrivalTime = Integer.MAX_VALUE;
        //Calculate from start to end
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][1] < arrivalTime) {
                ans++;
            }
            arrivalTime = arr[i][1];
        }
        return ans;
    }*/

    /**
     * TreeMap
     * TODO
     *
     * @param target
     * @param position
     * @param speed
     * @return
     */
    public static int carFleet3(int target, int[] position, int[] speed) {
        return 0;
    }
}