package com.mk.juc;

//给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
public class demo1 {
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] twoSum = twoSum(nums, target);
        System.out.println(twoSum[0]+" + "+twoSum[1]+" = "+target);
    }
}
