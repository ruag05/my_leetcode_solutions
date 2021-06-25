package com.company;

//PROBLEM
//  -Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//  -You may assume that each input would have exactly one solution, and you may not use the same element twice.
//  -You can return the answer in any order.

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println(twoSum(nums, target);
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> dict = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(dict.containsKey(nums[i])){
                if(dict.get(nums[i]) >= 0 ){
                    int[] result = new int[]{dict.get(nums[i]), i};
                    return result;
                }
            }
            else{
                dict.put(target - nums[i], i);
            }
        }
        return null;
    }
}
