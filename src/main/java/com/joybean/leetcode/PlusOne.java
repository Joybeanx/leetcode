package com.joybean.leetcode;

/**
 * <a href="https://leetcode.com/problems/plus-one/">Plus One</a>
 *
 * @author Joybean
 */
public class PlusOne {
    /**
     * Keep original parameter unchanged,but less efficient
     *
     * @param digits
     * @return
     */
    public static int[] plusOne1(int[] digits) {
        int i = digits.length - 1;
        boolean carry = true;
        int[] result;
        int[] arr = new int[digits.length];
        do {
            int current = digits[i];
            if (carry) {
                current += 1;
                if (carry = (current > 9)) {
                    arr[i] = 0;
                } else {
                    arr[i] = current;
                }
            } else {
                arr[i] = current;
            }
            i--;
        } while (i >= 0);
        if (carry) {
            result = new int[digits.length + 1];
            result[0] = 1;
            //It's unnecessary to copy array
            //System.arraycopy(arr, 0, result, 1, digits.length);
        } else {
            result = arr;
        }
        return result;
    }

    /**
     * Cool solution but it modifies original parameter
     *
     * @param digits
     * @return
     */
    public static int[] plusOne2(int[] digits) {

        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;
        return newNumber;
    }
}
