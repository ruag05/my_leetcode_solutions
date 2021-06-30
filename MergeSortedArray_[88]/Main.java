package com.leetcode_solutions.ruchir;

public class Main {

    //PROBLEM
    //  -You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
    //  and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
    //
    //  -Merge nums1 and nums2 into a single array sorted in non-decreasing order.
    //
    //  -The final sorted array should not be returned by the function,
    //  but instead be stored inside the array nums1. To accommodate this,
    //  nums1 has a length of m + n, where the first m elements denote the elements
    //  that should be merged, and the last n elements are set to 0 and should be ignored.
    //  nums2 has a length of n.
    //
    //  Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    //  Output: [1,2,2,3,5,6]

    public static void main(String[] args) {
        int[] nums1 = new int[] {1,2,3,0,0,0};
        int[] nums2 = new int[] {7,10,12};
        merge(nums1, 3, nums2, 3);
        for(int i : nums1){
            System.out.println(i);
        }
     }
    public static void merge(int[] nums1, int m, int[] nums2, int n){
        int i = m-1, j = n-1, k = m+n-1;
        while(i >= 0 && j >= 0){
            if(nums1[i] >= nums2[j]){
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        while(j >= 0){
            nums1[k--] = nums2[j--];
        }
    }
}
