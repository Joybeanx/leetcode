package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/reverse-integer/">Reverse Integer</a>
 *
 * @author Joybean
 */
public class ReverseInteger {
    /**
     * String concatenation，use exception to handle overflow
     *
     * @param x
     * @return
     */
    public static int reverse1(int x) {
        String str = String.valueOf(Math.abs(x));
        StringBuilder sb = new StringBuilder();
        if (x < 0) {
            sb.append("-");
        }
        boolean f = true;
        int idx = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            if (f && c == 0) {
                idx++;
                continue;
            }
            break;
        }
        for (int i = str.length() - 1 - idx; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        try {
            return Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }


    public static int reverse2(int x) {
        int result = 0;
        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            //the restored value of result doesn't equal that before calculation if there is an overflow while calculating newResult
            if (newResult / 10 != result) {
                return 0;
            }
            result = newResult;
            x = x / 10;
        }
        return result;
    }

    public static int reverse3(int x) {
        //use long type in order to compare with integer max value and min value
        long result=0;
        while(x!=0)
        {
            int mod = x%10;
            result = result * 10 + mod;
            if(result > 0x7fffffff || result < -0x7fffffff)
            {
                result = 0 ;
                break;
            }
            x= x/10;
        }
        return (int)result;
    }

    public static int reverse4(int x) {
        long result = 0;
        while (x != 0){
            result *= 10;
            result += x % 10;
            x /= 10;
        }
        int test = (int) result;
        if (test == result) return test;
        return 0;
    }
}
