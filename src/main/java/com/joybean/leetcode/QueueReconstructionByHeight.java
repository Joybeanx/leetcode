package com.joybean.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/queue-reconstruction-by-height/">Queue Reconstruction by Height</a>
 *
 * @author Joybean
 */
public class QueueReconstructionByHeight {
    public static int[][] reconstructQueue1(int[][] people) {
        //order by height desc, position asc
        Arrays.sort(people, (p1, p2) -> p1[0] != p2[0] ? p2[0] - p1[0] : p1[1] - p2[1]);
        List<int[]> ans = new ArrayList<>();
        for (int[] person : people) {
            ans.add(person[1], person);
        }
        return ans.toArray(new int[ans.size()][]);
    }
}