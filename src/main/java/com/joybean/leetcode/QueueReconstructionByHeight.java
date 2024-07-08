package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/queue-reconstruction-by-height/">Queue Reconstruction by Height</a>
 *
 * @author Joybean
 */
public class QueueReconstructionByHeight {
    /**
     * Greedy algorithm using ArrayList
     * @param people
     * @return
     */
    public static int[][] reconstructQueue1(int[][] people) {
        //order by height desc, position asc
        Arrays.sort(people, (p1, p2) -> p1[0] != p2[0] ? p2[0] - p1[0] : p1[1] - p2[1]);
        List<int[]> ans = new ArrayList<>();
        for (int[] person : people) {
            ans.add(person[1], person);
        }
        return ans.toArray(new int[ans.size()][]);
    }

    /**
     * <a href="https://leetcode.com/problems/queue-reconstruction-by-height/solutions/2211641/visual-explanation
     * -java-greedy/">Greedy algorithm using LinkedList</a>
     *
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        List<int[]> list = new LinkedList<>();
        Arrays.sort(people, (a, b) -> {
            if (b[0] == a[0]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });
        for (int i = 0; i < n; i++) {
            list.add(people[i][1], people[i]);
        }
        return list.toArray(new int[n][2]);
    }
}