package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{0,-6,5,4,3,2,1,-10,0};
        quickSort(nums, 0 , 8);
        for(int num : nums){
            System.out.println(num);
        }
    }
    public static void quickSort(int[] nums, int start, int end){
        if(start < end) {
            int pivotIndex = partition(nums, start, end);
            quickSort(nums, start, pivotIndex - 1);
            quickSort(nums, pivotIndex + 1, end);
        }
    }
    public static int partition(int[] nums, int start, int end){

        //randomly select pivot
        Random rand = new Random();
        int pIndex = rand.nextInt(end - start) + start;

        //separate pivot from array, by placing it at the end
        int pivot = nums[pIndex];
        nums[pIndex] = nums[end];
        nums[end] = pivot;

        //partition the sub-array into further sub-arrays where
        //the elements to the left of the pivot are less than the pivot (and inherently
        //the elements to the right of the pivot are greater than the pivot)
        int pivotPointer = start;
        for(int i = start; i < end; i++){
            
            //traverse the array so all the elements less than pivot comes to the start of the array
            if(nums[i] < pivot){
                int tempVar2 = nums[pivotPointer];
                nums[pivotPointer] = nums[i];
                nums[i] = tempVar2;
                pivotPointer ++;
            }
        }
        
        //finally, bring the pivot back and place it next to the last element with smaller value
        if(nums[pivotPointer] > nums[end]){
            nums[end] = nums[pivotPointer];
            nums[pivotPointer] = pivot;
        }
        return pivotPointer;
    }
}
