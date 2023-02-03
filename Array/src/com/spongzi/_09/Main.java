package com.spongzi._09;

/**
 * 剑指 Offer II 009. 乘积小于 K 的子数组
 * <a href="https://leetcode.cn/problems/ZVAVXX/?favorite=e8X3pBZi"></a>
 *
 * @author spong
 * @date 2023/02/03
 */
public class Main {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        long product = 1;
        int left = 0;
        int count = 0;
        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];
            while (left <= right && product < k) {
                product /= nums[left++];
            }
            count += left <= right ? right - left + 1 : 0;
        }
        return count;
    }
}
