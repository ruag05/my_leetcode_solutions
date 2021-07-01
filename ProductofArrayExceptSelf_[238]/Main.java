package com.leetcode_solutions.ruchir;

public class Main {

    //PROBLEM
    //  -Given an integer array nums, return an array answer such that answer[i] is equal
    //  to the product of all the elements of nums except nums[i].
    //
    //  -The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
    //
    //  -You must write an algorithm that runs in O(n) time and without using the division operation.
    //
    //  - 2 <= nums.length <= 105
    //  - -30 <= nums[i] <= 30
    //  - The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

    public static void main(String[] args) {
        int[] nums = new int[]{2,5};
        for(int number : produceExceptSelf(nums)){
            System.out.println(number);
        }
    }

    //took 1 ms (100 percentile) and 49.8 MB ( 54 percentile)
    public static int[] produceExceptSelf(int[] nums){
        int[] res = new int[nums.length];

        res[0] = 1;
        for(int i = 1; i < nums.length; i++){
            res[i] = res[i-1] * nums[i - 1];
        }

        int right = 1;
        for(int i = nums.length - 1 - 1; i >= 0; i--){
            right *= nums[i + 1];
            res[i] *= right;
        }

        return res;
    }
}
