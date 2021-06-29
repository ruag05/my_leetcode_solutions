package com.leetcode_solutions.ruchir;

public class Main {

    //PROBLEM
    //  -Given an array nums of non-negative integers, return an array consisting
    //  of all the even elements of nums, followed by all the odd elements of nums.
    //
    //  -You may return any answer array that satisfies this condition.

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8};
        for(int element : sortArrayByParity2(nums)){
            System.out.println(element);
        }
    }

    //took 1 ms (99 percentile) and 39.8 MB (62 percentile)
    public static int[] sortArrayByParity(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 == 0){
                int temp = nums[j];
                nums[j] = nums[i];
                j++;
                nums[i] = temp;
            }
        }
        return nums;
    }

    //took 1 ms (99 percentile) and 39.9 MB (41 percentile)
    public static int[] sortArrayByParity2(int[] nums) {
        int i = 0, j = nums.length - 1;
        while(i < j){
            if(nums[i] % 2 > nums[j] % 2){
                //swap
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j--;
                i++;
            }
            while(nums[i] % 2 == 0)
                i++;
            while(nums[j] % 2 == 1)
                j--;
        }
        return nums;
    }
}
