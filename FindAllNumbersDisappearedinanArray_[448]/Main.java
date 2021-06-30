package com.leetcode_solutions.ruchir;

import com.sun.tools.sjavac.ProblemException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    //PROBLEM
    //  -Given an array nums of n integers where nums[i] is in the range [1, n],
    //  return an array of all the integers in the range [1, n] that do not appear in nums.
    //
    //  -Constraints:
    //  - n == nums.length
    //  - 1 <= n <= 105
    //  - 1 <= nums[i] <= n

    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        for (int element : findDisappearedNumbers2(nums)) {
            System.out.println(element);
        }
    }

    //took 25 ms (11 percentile) and 47.4 MB (92 percentile)
    public static List<Integer> findDisappearedNumbers(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int val = map.get(num) == null ? 0 : map.get(num);
            map.put(num, val + 1);
        }

        List<Integer> list = new ArrayList<>();

        for(int i = 1; i <= nums.length; i++){
            if(map.get(i) == null || map.get(i) == 0){
                list.add(i);
            }
        }

        return list;
    }

    //took 5 ms (79 percentile) and 47.7 MB (87 percentile)
    public static List<Integer> findDisappearedNumbers2(int[] nums){
        for(int i = 0; i < nums.length; i++){
            while(nums[i] != nums[nums[i] - 1]){
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i + 1){
                res.add(i + 1);
            }
        }
        return res;
    }
}
