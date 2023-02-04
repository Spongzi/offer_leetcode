package com.spongzi._11;

import java.util.HashMap;

/**
 * 剑指 Offer II 011. 0 和 1 个数相同的子数组
 * <a href="https://leetcode.cn/problems/A1NYOS/?favorite=e8X3pBZi"></a>
 *
 * @author spong
 * @date 2023/02/04
 */
public class Main {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0, -1);
        int sum = 0;
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if (sumToIndex.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - sumToIndex.get(sum));
            } else {
                sumToIndex.put(sum, i);
            }
        }
        return maxLength;
    }
}
