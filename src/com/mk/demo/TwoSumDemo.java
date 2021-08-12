package com.mk.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: LeetCode第一道题 给出两数之和，求坐标，
 * @Author mckale
 * @Date 2021/8/11 19:26
 */
public class TwoSumDemo {

    //暴力循环
    public static int[] sum1(int[] nums,int target){
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length ; j++) {
                if (target - nums[i] == nums[j]){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    //最优解
    public static int[] sum2(int[] nums,int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int ums = target - nums[i];
            if (map.containsKey(ums)){
                return new int[]{map.get(ums),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }


    public static void main(String[] args) {
        int[] nums = {2,7,11};
        int target = 9;
        int[] ui = sum2(nums,target);
        for (int i : ui) {
            System.out.println(i);
        }
        System.out.println();
    }


}
