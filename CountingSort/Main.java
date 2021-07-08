package com.company;

public class Main {

    //PROVIDED
    //  All elements in input array are positive
    //  0 <= element <= k

    public static void main(String[] args) {
        int[] nums = new int[]{2,1,1,0,2,5,4,0,2,8,7,7,9,2,0,1,9};
        countingSort(nums);
        for(int num : nums){
            System.out.println(num);
        }
    }
    public static void countingSort(int[] nums){
        int k = 0;
        for(int num : nums){
            k = Math.max(num, k);
        }

        //build count array
        int[] countArr = new int[k + 1];
        for (int num : nums) {
            countArr[num]++;
        }

        //update count array with element-wise position
        for(int i = 1; i < countArr.length; i++){
            countArr[i] += countArr[i - 1];
        }

        //build sorted array
        int[] sortedArr = new int[nums.length];
        for(int i = nums.length - 1; i >= 0; i--){
            int index = countArr[nums[i]] - 1;
            sortedArr[index] = nums[i];
            countArr[nums[i]] --;
        }

        System.arraycopy(sortedArr,0,nums,0,sortedArr.length);
    }
}
