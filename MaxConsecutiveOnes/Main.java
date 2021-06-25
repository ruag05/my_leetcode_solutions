package com.leetcode_solutions.ruchir;

//PROBLEM
//  -Given a binary array nums, return the maximum number of consecutive 1's in the array.

public class Main {

    public static void main(String[] args) {
          int[] nums = new int[]{1,0,1,1,0,0,1,1,1,0,0,0,0,1,1,0,1};
          System.out.println(findMaxConsecutiveOnes(nums)); //use any of the following method to get the output
    }
    public int findMaxConsecutiveOnes(int[] nums) { //gives best performance
        int max = 0;
        int maxLocal = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1)
                maxLocal++;
            else
                maxLocal = 0;
            max = maxLocal > max ? maxLocal : max;
        }
        return max;
    }
    public static int findMaxConsecutiveOnes_1(int[] nums){ //first iteration of the approach
       int max = 0;
       int maxLocal = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1) {
                maxLocal++;
                if (maxLocal > max)
                    max = maxLocal;
            }
            else
                maxLocal = 0;
        }
        return max;
    }
    public static int findMaxConsecutiveOnes_2(int[] nums) { //second iteration of the approach
        int max = 0;
        int maxLocal = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1)
                //concises line 26-28 into 1
                max = Math.max(++maxLocal, max);
            else
                maxLocal = 0;
        }
        return max;
    }
    public static int findMaxConsecutiveOnes_3(int[] nums) { //third iteration of the approach
        int max = 0;
        int maxLocal = 0;
        for(int i : nums){
            maxLocal = (i == 0)? 0: ++maxLocal;
            if(maxLocal > max)
                max = maxLocal;
        }
        return max;
    }
    public static int findMaxConsecutiveOnes_4(int[] nums) { //fourth iteration of the approach
        int max = 0;
        int maxLocal = 0;
        for(int i : nums){
            //concises line 51-53
            max = Math.max(max, maxLocal = (i == 0)? 0: ++maxLocal);
        }
        return max;
    }
    
}
