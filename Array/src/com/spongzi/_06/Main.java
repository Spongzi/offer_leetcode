package com.spongzi._06;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 006. 排序数组中两个数字之和
 * <a href="https://leetcode.cn/problems/kLl5u1/?favorite=e8X3pBZi">...</a>
 *
 * @author spong
 * @date 2023/02/02
 */
public class Main {
    /**
     * 首先知道target目标值
     * 在数组中寻找目标值
     * 1. 暴力双重循环寻找
     *
     * @param numbers 数组
     * @param target  目标值
     * @return 返回结果
     */
    public int[] twoSum1(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 首先知道target目标值
     * 在数组中寻找目标值
     * 2. 使用数组实现
     *
     * @param numbers 数组
     * @param target  目标值
     * @return 返回结果
     */
    public int[] twoSum2(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                return new int[]{map.get(numbers[i]), i};
            }
            map.put(target - numbers[i], i);
        }
        return null;
    }

    /**
     * 首先知道target目标值
     * 在数组中寻找目标值
     * 3. 书中双指针的实现
     *
     * @param numbers 数组
     * @param target  目标值
     * @return 返回结果
     */
    public int[] twoSum3(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j && numbers[i] + numbers[j] != target) {
            if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[]{i, j};
    }
}
