package com.company;

public class Main {

    //PROBLEM
    //  -You are given an integer array nums where the largest integer is unique.
    //
    //  -Determine whether the largest element in the array is at least twice as much as
    //  every other number in the array. If it is, return the index of the largest element, or return -1 otherwise.
    //
    //  -Constraints:
    //
    //  - 1 <= nums.length <= 50
    //  - 0 <= nums[i] <= 100
    //  - The largest element in nums is unique.

    public static void main(String[] args) {
        int[] nums = new int[]{2,4,1,7,1,15};
        System.out.println(dominantIndex(nums));
    }

    //took 1 ms (26 percentile) and 38.6 MB (14 percentile)
    public static int dominantIndex(int[] nums){
        if(nums.length == 1){
            return 0;
        } else {
            int fLargest = Integer.MIN_VALUE, sLargest = Integer.MIN_VALUE;
            int largestIndex = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > fLargest) {
                    sLargest = fLargest;
                    fLargest = nums[i];
                    largestIndex = i;
                } else if (nums[i] > sLargest) {
                    sLargest = nums[i];
                }
            }
            if (fLargest >= 2 * sLargest)
                return largestIndex;
            else
                return -1;
        }
    }

    //took 0 ms (100 percentile) and 36.8 MB (59 percentile)
    public static int dominantIndex2(int[] nums) {
        if(nums.length == 1){
            return 0;
        } else {
            int largestIndex = -1, max = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] > max){
                    max = nums[i];
                    largestIndex = i;
                }
            }
            for (int num : nums) {
                if(num != max && max < 2*num)
                    return -1;
            }
            return largestIndex;
        }
    }

}
