package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/implement-rand10-using-rand7/">Implement Rand10() Using Rand7()</a>
 *
 * @author Joybean
 */
public class ImplementRand10UsingRand7 {
    /**
     * Rejection sampling: rand7 -> rand49 -> rand10
     *
     * @return
     */
    public static int rand10a() {
        int ans = 0;
        //Discard numbers in (10,49]
        //This rejection sampling approach can be less efficient because it needs reject
        //more numbers before obtaining a valid num
        while ((ans = (rand7() - 1) * 7 + rand7()) <= 10) {
            return ans;
        }
        return ans;
    }

    /**
     * <a href="https://leetcode.cn/problems/implement-rand10-using-rand7/solutions/167850/cong-zui-ji-chu-de-jiang-qi-ru-he-zuo-dao-jun-yun-/">Optimized rejection sampling: rand7 -> rand49 -> rand40 -> rand10</a>
     *
     * @return
     */
    public static int rand10b() {
        int rand40 = 0;
        //Discard numbers in (40,49]
        while ((rand40 = (rand7() - 1) * 7 + rand7()) > 40) {

        }
        return rand40 % 10 + 1;
    }

    /**
     * <a href="https://leetcode.cn/problems/implement-rand10-using-rand7/solutions/167850/cong-zui-ji-chu-de-jiang-qi-ru-he-zuo-dao-jun-yun-/">Optimized rejection sampling: rand7 -> rand49 -> rand40 -> rand10</a>
     *
     * @return
     * @see <a href="https://leetcode.com/problems/implement-rand10-using-rand7/solutions/150301/three-line-java-solution-the-idea-can-be-generalized-to-implement-randm-using-randn/">Rejection sampling correctness</a>
     */
    public static int rand10c() {
        int rand40 = 0;
        //Discard numbers in (10,49]
        do {
            int row = rand7();
            int col = rand7();
            rand40 = (row - 1) * 7 + col;
        } while (rand40 > 40);
        return rand40 % 10 + 1;
    }

    public static int rand7() {
        return 0;
    }
}
