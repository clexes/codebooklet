package com.mk.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        int[] nums = {78,87,5,7,4,1,97,45,67};
        sort(nums);
        System.out.println(Arrays.toString(nums));

    }

    private static void sort(int[] nums) {
        int len = nums.length;

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < len-i; j++) {
                if (nums[j] > nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

    }


}
