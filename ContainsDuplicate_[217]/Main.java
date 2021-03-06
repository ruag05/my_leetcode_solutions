package com.leetcode_solutions.ruchir;

import java.util.*;

public class Main {

    //PROBLEM
    //  -Given an integer array nums, return true if any value appears at least twice in the array,
    //  and return false if every element is distinct.
    //
    //  -Constraints:
    //
    //  - 1 <= nums.length <= 105
    //  - -109 <= nums[i] <= 109

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,4,3};
        System.out.println(containsDuplicate(nums));
    }

    //took 6 ms (56 percentile) and 44.7 MB (67 percentile)
    public static boolean containsDuplicate(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();

        for(int number : nums) {
            if(map.get(number) != null)
                return true;
            else
                map.put(number, 1);
        }
        return false;
    }

    //took 4 ms (82 percentile) and 43.2 MB 72 percentile)
    public static boolean containsDuplicate2(int[] nums){
        Set<Integer> set = new HashSet<>();

        for(int number : nums) {
            if(!set.add(number))
                return true;
        }
        return false;
    }

    //took 3 ms (99.8 percentile) and 46 MB (17 percentile)
    public static boolean containsDuplicate3(int[] nums){
        int max = nums[0];
        int min = nums[0];
        for(int num : nums){
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int[] checker = new int[max - min + 1];
        for(int num : nums){
            if(checker[num - min] > 0 return true;
            checker[num - min]++;
        }
        return false;
    }
}
