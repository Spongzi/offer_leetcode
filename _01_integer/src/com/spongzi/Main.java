package com.spongzi;

import com.spongzi.binary.Addition;

/**
 * 主要
 *
 * @author spong
 * @date 2023/02/01
 */
public class Main {
    public static void main(String[] args) {
        /*
         * 测试整数除法
         */
        System.out.println(IntegerDivision.divide(15, 2));

        /*
        测试二进制加法
         */
        System.out.println(Addition.addBinary("11", "10"));
    }
}
