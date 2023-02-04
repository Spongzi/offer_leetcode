package com.spongzi._12;

import java.util.Arrays;

/**
 * 剑指 Offer II 012. 左右两边子数组的和相等
 * <a href="https://leetcode.cn/problems/tvdfij/?favorite=e8X3pBZi"></a>
 *
 * @author spong
 * @date 2023/02/04
 */
public class Main {
    public int pivotIndex(int[] nums) {
        // 求左右连边的和, 用减法解决问题
        // 先求出所有的和, 然后对其进行相减, 如果剪完之后和结果相同
        // 那么求出答案
        for (int i = 0; i < nums.length; i++) {
            int leftSum = 0;
            int rightSum = 0;
            if (i > 0) {
                for (int left = i - 1; left >= 0; left--) {
                    leftSum += nums[left];
                }
            }
            if (i < nums.length - 1) {
                for (int right = i + 1; right < nums.length; right++) {
                    rightSum += nums[right];
                }
            }
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }

    public int pivotIndex1(int[] nums) {
        // 1. 先求出总和
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        int sum = 0;
        // 2. 再次遍历当前数组
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum - nums[i] == total - sum) {
                return i;
            }
        }
        return -1;
    }
}
