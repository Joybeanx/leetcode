package com.joybean.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/find-median-from-data-stream/">Find Median from Data Stream</a>
 *
 * @author Joybean
 */
public class FindMedianFromDataStream {
    /**
     * larger half of the data stream
     */
    private PriorityQueue<Integer> minHeap;
    /**
     * smaller half of the data stream
     */
    private PriorityQueue<Integer> maxHeap;
    /**
     * Better than to declare odd
     */
    private boolean even = true;

    /**
     * <a href="https://leetcode.com/problems/find-median-from-data-stream/discuss/74047/JavaPython-two-heap-solution-O(log-n)
     * -add-O(1)-find">Two heaps solution</a>
     */
    public FindMedianFromDataStream() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void addNum1(int num) {
        if (even) {
            //minHeap always holds at most 1 number more than maxHeap
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        } else {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
        even = !even;
    }

    /**
     * <a href="https://www.programcreek.com/2015/01/leetcode-find-median-from-data-stream-java/">Another heap balancing
     * approach</a>
     *
     * @param num
     */
    public void addNum2(int num) {
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());
        //Balance minHeap and maxHeap.
        //This assures minHeap always holds at most 1 number more than maxHeap and all numbers in minHeap are
        //greater than maxHeap
        if (minHeap.size() < maxHeap.size()) {
            minHeap.offer(maxHeap.poll());
        }
    }

    /**
     * <a href="https://leetcode.com/problems/find-median-from-data-stream/discuss/275207/Solutions-to-follow-ups">Follow
     * up</a>
     * TODO
     * @param num
     */
    public void addNum3(int num) {

    }

    public double findMedian() {
        if (even) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
        return minHeap.peek();
    }
}
