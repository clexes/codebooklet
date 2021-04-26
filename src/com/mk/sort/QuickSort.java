package com.mk.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {78,87,5,7,4,1,97,45,67};
        int[] sort = sort(nums);
        System.out.println(Arrays.toString(sort));
    }

    private static void swap(int[] nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void quickSort(int[] nums,int left,int right){
        /*if(right - left <= 0)
            return;

        int prov = nums[right];
        int partition = left - 1;

        for (int i = left; i < right - 1; i++) {
            if (nums[i] < prov){
                partition++;
                swap(nums,partition,i);
            }
        }

        partition++;
        swap(nums,partition,right);
        quickSort(nums,left,partition -1);
        quickSort(nums,partition+1,right);*/
        // 递归返回条件，和分区排序结束
        if (right-left <=0) {
            return;
        }
        // 选择数组右边界值作为分区节点
        int pivot = nums[right];
        // 从数组左边界值开始维护分区
        int partition=left-1;
        // 遍历当前分区内元素
        for (int i = left; i <= right-1; i++) {
            if ((nums [i] < pivot) ) {
                // 将小于pivot的值交换到partition左边
                // 将大于等于pivot的值交换到partition右边
                partition++;
                swap(nums, partition, i);
            }
        }
        // 将分区节点插入到数组左右分区中间
        partition++;
        swap(nums, partition, right);
        // 分区节点排序完成
        // 左分区继续排序，右分区继续排序
        quickSort(nums,left, partition-1);
        quickSort(nums,partition+1, right);



    }

    private static int[] sort(int[] nums){
        if (nums == null || nums.length == 0)
            return nums;
        quickSort(nums,0,nums.length - 1);
        return nums;
    }



}
