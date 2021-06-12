package com.company;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
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
