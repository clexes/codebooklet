package com.mk.leetcode;

import java.util.HashMap;
import java.util.Map;

class TwoSum {

    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{1, 3, 4, 2}, 6);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
//        int index = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        //双重暴力循环
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = nums.length-1; j > 0; j--) {
//                if (nums[i]+nums[j] == target & i!=j){
//                    return new int[]{i,j};
//                }
//            }
//        }
        return null;
    }
}