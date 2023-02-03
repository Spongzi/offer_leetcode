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
    /**
     * 三数之和的另一种解法
     *
     * @param nums 给定的数组
     * @return 返回结果集合
     */
    public List<List<Integer>> threeSum(int[] nums) {
        // 定义一个结果集合
        LinkedList<List<Integer>> ans = new LinkedList<>();
        int n = nums.length;
        Arrays.sort(nums);

        // 开始对第一个数字进行遍历
        for (int first = 0; first < n; first++) {
            // 每次遍历都与上一次的值不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            // 定义第三个值的位置
            int third = n - 1;
            // 定义目标值 即转变后的第一个值,把问题转化为两数之和
            int target = -1 * nums[first];
            for (int second = first + 1; second < n; second++) {
                // 每次遍历都与上一次的值不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 保证第二个值在第三个值的前面
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果两个指针相交了还没有出现结果值,那么就不会再出现了,可以直接跳出循环
                if (second == third) {
                    break;
                }
                // 统计结果值
                if (nums[second] + nums[third] == target) {
                    ans.add(Arrays.asList(nums[first], nums[second], nums[third]));
                }
            }
        }
        return ans;
    }

    public List<List<Integer>> threeSum1(int[] nums) {
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
