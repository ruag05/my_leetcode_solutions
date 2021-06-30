package com.leetcode_solutions.ruchir;

public class Main {

    public static void main(String[] args) {
          int[] nums = new int[]{1,0,1,1,0,0,1,1,1,0,0,0,0,1,1,0,1};
          System.out.println(findMaxConsecutiveOnes(nums));
    }

    public static int findMaxConsecutiveOnes(int[] nums){
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
    public static int findMaxConsecutiveOnes1(int[] nums) {
        int max = 0;
        int maxLocal = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1)
                //concises line 15-17 into 1
                max = Math.max(++maxLocal, max);
            else
                maxLocal = 0;
        }
        return max;
    }
    public static int findMaxConsecutiveOnes2(int[] nums) {
        int max = 0;
        int maxLocal = 0;
        for(int i : nums){
            maxLocal = (i == 0)? 0: ++maxLocal;
            if(maxLocal > max)
                max = maxLocal;
        }
        return max;
    }
    public static int findMaxConsecutiveOnes3(int[] nums) {
        int max = 0;
        int maxLocal = 0;
        for(int i : nums){
            //concises line 40-42
            max = Math.max(max, maxLocal = (i == 0)? 0: ++maxLocal);
        }
        return max;
    }
}
