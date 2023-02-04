package com.spongzi._10;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 010. 和为 k 的子数组
 * <a href="https://leetcode.cn/problems/QTMn0o/?favorite=e8X3pBZi"></a>
 *
 * @author spong
 * @date 2023/02/04
 */
public class Main {
    public int subarraySum(int[] nums, int k) {
        // 定义一个map集合用来存储是否增加 count
        Map<Integer, Integer> sumToCount = new HashMap<>();
        sumToCount.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int num : nums) {
            sum += num;
            count += sumToCount.getOrDefault(sum - k, 0);
            sumToCount.put(sum, sumToCount.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    /**
     * 错误解题 -- 需要的是连续的数字,所以第二次循环不可以从0开始
     * @param nums 数组
     * @param k 目标值
     * @return 返回符合要求的情况个数
     */
    public int subarraySum1(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = 0; j <= i; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public int subarraySum2(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j >= 0; j--) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
