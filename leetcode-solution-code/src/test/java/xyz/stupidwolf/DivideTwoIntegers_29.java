package xyz.stupidwolf;

import org.junit.Test;

/**
 * <p>create at <code>2019-06-17</code></p>
 *
 * @author chenmingli
 */
public class DivideTwoIntegers_29 {

    @Test
    public void test() {
//        System.out.println(divide(10, 3));
//        System.out.println(divide(7, -3));
//        System.out.println(divide(0, 2));
//        System.out.println(divide(1, 2));
//        System.out.println(divide(1, 1));
//        System.out.println(2 << 1);
//        System.out.println(divide(-2147483648, -1));
//        System.out.println(divide(-2147483648, 1));
//        System.out.println(divide2(-2147483648, 1));
//        System.out.println(divide2(-2147483648, 2));
//        System.out.println(divide2(-2147483647, 2));
//        System.out.println(divide3(-2147483647, 2));
//        System.out.println(divide2(-2147483647, 1));
//        System.out.println(divide3(-2147483647, 1));
        System.out.println(divide2(-2147483648, 1));
        System.out.println(divide3(-2147483648, 1));
    }

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
            if (divisor == Integer.MIN_VALUE) {
                return 1;
            }
        }
        boolean flag = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int diff = dividend - divisor;
        dividend -= divisor;
        int count = 0;
        while (diff >= 0) {
            diff = dividend - divisor;
            dividend -= divisor;
            count ++;
        }
        return flag ? count : - count;
    }


    public int divide2(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        boolean isPositive = (dividend < 0 && divisor < 0) ||
                (dividend > 0 && divisor > 0);
        if (isPositive)
            return (int)_divide(Math.abs((long)dividend), Math.abs((long)divisor));
        else
            return (int)(0L - _divide(Math.abs((long)dividend), Math.abs((long)divisor)));
    }

    private long _divide(long dividend, long divisor) {
        if (dividend < divisor)
            return 0;
        long offset = 1;
        long newDivisor = divisor;
        while (dividend - newDivisor >= newDivisor) {
            newDivisor = newDivisor << 1;
            offset = offset << 1;
        }
//        System.out.println(dividend + " : " + offset);
        return offset + _divide(dividend - newDivisor, divisor);
    }



    public int divide3(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean sign = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
        return (int)(sign ? fastDivide(Math.abs((long) dividend), Math.abs((long) divisor)) :
                - fastDivide(Math.abs((long)dividend), Math.abs((long)divisor)));
    }

    private long fastDivide(long dividend, long divisor) {
        if (dividend < divisor) {
            return 0;
        }
        long newDivisor = divisor;
        long offset = 1;
        while (dividend - newDivisor > newDivisor) {
            newDivisor = newDivisor << 1;
            offset = offset << 1;
        }
        return offset + fastDivide(dividend - newDivisor, divisor);
    }
}
