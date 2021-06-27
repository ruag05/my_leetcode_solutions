package com.leetcode_solutions.ruchir;

public class Main {

    //PROBLEM
    //  -Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place
    //  such that each unique element appears only once. The relative order of the elements should be kept the same.
    //
    //  -Since it is impossible to change the length of the array in some languages,
    //  you must instead have the result be placed in the first part of the array nums. More formally,
    //  if there are k elements after removing the duplicates, then the first k elements of nums should
    //  hold the final result. It does not matter what you leave beyond the first k elements.
    //
    //  -Return k after placing the final result in the first k slots of nums.
    //
    //  -Do not allocate extra space for another array. You must do this by modifying the input array
    //  in-place with O(1) extra memory.

    public static void main(String[] args){
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }

    //took 1 ms to execute & 40.6 MB
    public static int removeDuplicates(int[] nums){
        int i = 1, j = 1;
        while(j < nums.length){
            if(nums[j] == nums [j - 1])
                j++;
            else {
                nums[i] = nums[j];
                i++;
                j++;
            }
        }
        return i;
    }

    //took 0 ms to execute and 40.6 MB
    public static int removeDuplicates1(int[] nums){
        int i = 0, j = 1;
        while(j < nums.length){
            if(nums[j] == nums [i])
                j++;
            else {
                i++;
                nums[i] = nums[j];
                j++;
            }
        }
        return i + 1;
    }
}
