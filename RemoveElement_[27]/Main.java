package com.leetcode_solutions.ruchir;

public class Main {

    //PROBLEM
    //  -Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
    //  The relative order of the elements may be changed.
    //
    //  -Since it is impossible to change the length of the array in some languages,
    //  you must instead have the result be placed in the first part of the array nums.
    //  More formally, if there are k elements after removing the duplicates, then
    //  the first k elements of nums should hold the final result. It does not matter
    //  what you leave beyond the first k elements.
    //
    //  -Return k after placing the final result in the first k slots of nums.
    //
    //  -Do not allocate extra space for another array. You must do this by modifying the
    //  input array in-place with O(1) extra memory.

    public static void main(String[] args){
        int[] nums = new int[]{1,2,1,2,2,3,4,2,5,1,2};
        System.out.println(removeElement(nums, 2));
    }
    public static int removeElement(int[] nums, int val){
        int k = nums.length - 1;
        for(int i = 0; i <= k; i++){
            if(nums[i] == val){
                while(k > i) {
                    if (nums[k] != val) {
                        nums[i] = nums[k];
                        k--;
                        break;
                    } else {
                        k--;
                    }
                }
                if(k == i && nums[i] == val){
                    k--;
                }
            }
        }
        return k + 1;
    }
}
