package com.spongzi._07;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer II 007. 数组中和为 0 的三个数
 * <a href="https://leetcode.cn/problems/1fGaJU/?favorite=e8X3pBZi"></a>
 *
 * @author spong
 * @date 2023/02/02
 */
public class Main {
    public List<List<Integer>> threeSum(int[] nums) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (nums.length >= 3) {
            Arrays.sort(nums);
            int i = 0;
            while (i < nums.length - 2) {
                twoSum(nums, i, result);
                int temp = nums[i];
                while (i < nums.length && nums[i] == temp) {
                    ++i;
                }
            }
        }
        return result;
    }

    private void twoSum(int[] nums, int i, LinkedList<List<Integer>> result) {
        int j = i + 1;
        int k = nums.length - 1;
        while (j < k) {
            if (nums[i] + nums[j] + nums[k] == 0) {
                result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                int temp = nums[j];
                while (nums[j] == temp && j < k) {
                    ++j;
                }
            } else if (nums[i] + nums[j] + nums[k] < 0) {
                ++j;
            } else {
                --k;
            }
        }
    }
}
