package com.spongzi;

/**
 * 整数除法
 * 要求: 输入两个整数,他们进行除法计算并返回商.
 * 要求不得使用称号"*",除号"%"
 * 当发生溢出时,返回最大的整数值
 * 假设除数不为0
 * 例如: 输入 15 和 2, 输出15 / 2的结果,即 7
 *
 * @author spong
 * @date 2023/02/01
 */
public class IntegerDivision {
    public static int divide(int dividend, int divisor) {
        if (dividend == 0x8000000 && divisor == - 1) {
            return Integer.MAX_VALUE;
        }
        int negative = 2;
        if (dividend > 0) {
            negative--;
            dividend = - dividend;
        }
        if (divisor > 0) {
            negative--;
            divisor = - divisor;
        }
        int result = divideCore(dividend, divisor);
        return negative == 1 ? -result : result;
    }

    private static int divideCore(int dividend, int divisor) {
        int result = 0;
        while (dividend <= divisor) {
            int value = divisor;
            int quotient = 1;
            while (value >= 0xc0000000 && dividend <= value + value) {
                quotient += quotient;
                value += value;
            }
            result += quotient;
            dividend -= value;
        }
        return result;
    }


}
