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
        int[] nums = new int[]{0,1,2,3,3,2,1,2,0};
        System.out.println(removeElement2(nums, 2));
    }

    //took 0 ms (100 percentile) and 37.2 MB (97 percentile)
    public static int removeElement(int[] nums, int val){
        int k = nums.length - 1;
        for(int i = 0; i <= k; i++){
            if(nums[i] == val){
                while(k >= i) {
                    if (nums[k] != val) {
                        nums[i] = nums[k];
                        k--;
                        break;
                    } else {
                        k--;
                    }
                }
            }
        }
        return k + 1;
    }
    
    //took 0 ms (100 percentile) and 37.4 MB (87 percentile) (simpler version of the above approach)
    public int removeElement(int[] nums, int val) {
       int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val) nums[j++] = nums[i];   
        }
        return j;
    }

    //took 0 ms (100 percentile) and 37.4 MB (75 percentile)
    public static int removeElement2(int[] nums, int val){
        int i = 0;
        for(int j = 0; j < nums.length; j++){
            if(nums[j] != val){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
        return i;
    }
}
