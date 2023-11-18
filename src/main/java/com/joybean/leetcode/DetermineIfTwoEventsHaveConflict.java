package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/determine-if-two-events-have-conflict/">Determine if Two Events Have Conflict</a>
 *
 * @author Joybean
 */
public class DetermineIfTwoEventsHaveConflict {
    /**
     * Convert string to minutes and then compare
     *
     * @param event1
     * @param event2
     * @return
     */
    public static boolean haveConflict1(String[] event1, String[] event2) {
        String[] startTimeArr1 = event1[0].split(":");
        String[] endTimeArr1 = event1[1].split(":");
        String[] startTimeArr2 = event2[0].split(":");
        String[] endTimeArr2 = event2[1].split(":");
        Integer startTime1 = Integer.valueOf(startTimeArr1[0]) * 60 + Integer.valueOf(startTimeArr1[1]);
        Integer endTime1 = Integer.valueOf(endTimeArr1[0]) * 60 + Integer.valueOf(endTimeArr1[1]);
        Integer startTime2 = Integer.valueOf(startTimeArr2[0]) * 60 + Integer.valueOf(startTimeArr2[1]);
        Integer endTime2 = Integer.valueOf(endTimeArr2[0]) * 60 + Integer.valueOf(endTimeArr2[1]);
        return startTime1 >= startTime2 && startTime1 <= endTime2 || startTime2 >= startTime1 && startTime2 <= endTime1;
    }

    /**
     * <a href="https://leetcode.com/problems/determine-if-two-events-have-conflict/solutions/2734120/java-c-python-easy-1-liner-solutions/">Compare strings directly</a>
     *
     * @param event1
     * @param event2
     * @return
     */
    public static boolean haveConflict2(String[] event1, String[] event2) {
        return event1[0].compareTo(event2[1]) <= 0 && event2[0].compareTo(event1[1]) <= 0;
    }

}
