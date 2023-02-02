package com.spongzi._08;

import java.security.Key;

/**
 * 剑指 Offer II 008. 和大于等于 target 的最短子数组
 * <a href="https://leetcode.cn/problems/2VG8Kg/?favorite=e8X3pBZi"></a>
 * 整体思路, 双指针的想法,一个在左边一个在右边先跑着,然后判断是否大于当前数字,如果大于当前数字,那么左边的指针向右走
 *
 * @author spong
 * @date 2023/02/02
 */
public class Main {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (left <= right && sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left++];
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
