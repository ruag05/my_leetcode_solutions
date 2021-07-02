package com.leetcode_solutions.ruchir;

import java.util.*;

public class Main {

    //PROBLEM
    //  -Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
    //such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
    //
    //  -Notice that the solution set must not contain duplicate triplets.
    //
    //  -Constraints:
    //
    //  - 0 <= nums.length <= 3000
    //  - -105 <= nums[i] <= 105

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 0, 2, 2};
        List<List<Integer>> list = threeSum(nums);
    }

    //took 18 ms (88 percentile) and 43.2 MB (46 percentile)
    public static List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++){
            if(i == 0 || nums[i] != nums[i - 1]) {
                int low = i + 1, high = nums.length - 1, sum = -nums[i];
                while (low < high) {
                    if (nums[low] + nums[high] == sum) {
                        //add triplet
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(nums[i]);
                        triplet.add(nums[low]);
                        triplet.add(nums[high]);
                        result.add(triplet);
                        while (low < high && nums[low] == nums[low+1]) low++;
                        while (low < high && nums[high] == nums[high-1]) high--;
                        low++;
                        high--;
                    } else if (nums[low] + nums[high] < sum) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }

        return result;
    }
}
