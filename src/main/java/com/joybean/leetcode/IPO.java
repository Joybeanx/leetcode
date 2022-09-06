package com.joybean.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * <a href="https://leetcode.com/problems/ipo/">IPO</a>
 *
 * @author Joybean
 */
public class IPO {
    /**
     * Straight forward solution
     *
     * @param k
     * @param w
     * @param profits
     * @param capital
     * @return
     */
    public static int findMaximizedCapital1(int k, int w, int[] profits, int[] capital) {
        int ans = w;
        Integer[] profitIdx = IntStream.range(0, profits.length).boxed().toArray(Integer[]::new);
        Arrays.sort(profitIdx, (a, b) -> profits[b] - profits[a]);
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < profitIdx.length; i++) {
            queue.add(profitIdx[i]);
        }
        int picked = 0;
        LinkedList<Integer> skipped = new LinkedList<>();
        while (!queue.isEmpty()) {
            if (ans < capital[queue.peek()]) {
                skipped.add(queue.poll());
                continue;
            }
            ans += profits[queue.poll()];
            if (++picked == k) {
                return ans;
            }
            while (!skipped.isEmpty()) {
                queue.addFirst(skipped.removeLast());
            }
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.com/problems/ipo/discuss/98210/Very-Simple-(Greedy)
     * -Java-Solution-using-two-PriorityQueues">Greedy solution using two priority queues</a>
     *
     * @param k
     * @param w
     * @param profits
     * @param capital
     * @return
     */
    public static int findMaximizedCapital2(int k, int w, int[] profits, int[] capital) {
        int ans = w;
        Queue<int[]> pqCap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        Queue<int[]> pqPro = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < profits.length; i++) {
            pqCap.add(new int[] {capital[i], profits[i]});
        }
        for (int i = 0; i < k; i++) {
            while (!pqCap.isEmpty() && pqCap.peek()[0] <= ans) {
                pqPro.add(pqCap.poll());
            }
            if (pqPro.isEmpty()) {
                break;
            }
            ans += pqPro.poll()[1];
        }
        return ans;
    }
}
