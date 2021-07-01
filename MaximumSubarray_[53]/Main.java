package com.leetcode_solutions.ruchir;

public class Main {

    //PROBLEM
    //  -Given an integer array nums, find the contiguous subarray (containing at least one number)
    // which has the largest sum and return its sum.
    //
    //  -Constraints:
    //
    //  - 1 <= nums.length <= 3 * 104
    //  - -105 <= nums[i] <= 105

    public static void main(String[] args) {
        int[] nums = new int[]{5,4,-1,7,8};
        System.out.println(maxSubArray(nums));
    }

    //took 0 ms (100 percentile) and 38.7 MB (76 percentile)
    public static int maxSubArray(int[] nums){
        int maxSoFar = nums[0];
        int maxOverall = maxSoFar;
        for(int i = 1; i < nums.length; i++){
            if(maxSoFar + nums[i] < nums[i]){
                maxSoFar = nums[i];
            } else{
                maxSoFar += nums[i];
            }
            if(maxSoFar > maxOverall){
                maxOverall = maxSoFar;
            }
        }
        return maxOverall;
    }
}
