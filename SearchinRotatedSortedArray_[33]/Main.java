package com.leetcode_solutions.ruchir;

public class Main {

    //PROBLEM
    //  -There is an integer array nums sorted in ascending order (with distinct values).
    //
    //  -Prior to being passed to your function, nums is rotated at an unknown pivot
    //  index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1],
    //  ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
    //  For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
    //
    //  -Given the array nums after the rotation and an integer target, return the index of
    //  target if it is in nums, or -1 if it is not in nums.
    //
    //  -You must write an algorithm with O(log n) runtime complexity.
    //
    //  -Constraints:
    //
    //  - 1 <= nums.length <= 5000
    //  - -104 <= nums[i] <= 104
    //  - All values of nums are unique.
    //  - nums is guaranteed to be rotated at some pivot.
    //  - -104 <= target <= 104

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        System.out.println(search2(nums, 0));
    }

    //took 0 ms (100 percentile) and 38.4 MB (61 percentile)
    public static int search(int[] nums, int target){
        int splitIndex = -1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < nums[i-1]){
                splitIndex = i;
            }
        }
        if(splitIndex > -1) {
            if (target <= nums[splitIndex - 1] && target >= nums[0]) {
                return binarySearch(nums, 0, splitIndex - 1, target);
            } else if (target >= nums[splitIndex] && target <= nums[nums.length - 1]) {
                return binarySearch(nums, splitIndex, nums.length - 1, target);
            }
        } else {
            return binarySearch(nums, 0 , nums.length - 1, target);
        }
        return -1;
    }

    public static int binarySearch(int arr[], int l, int r, int x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x)
                return mid;
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);
            return binarySearch(arr, mid + 1, r, x);
        }

        return -1;
    }

    //took 0 ms ( 100 percentile) and 38.5 MB (32 percentile)
    public static int search2(int[] nums, int target){
        int start = 0, end = nums.length - 1;
        while(start < end) {
            int mid = (start + end) / 2;
            if(target == nums[mid])
                return mid;
            if (nums[mid] > nums[end]) {        // 3,4,5,6,0,1

                if (target > nums[mid] || target <= nums[end]) {    //target = 6 or target = 1
                    start = mid + 1;
                } else {
                    end = mid;
                }
            } else {                             // 6,0,1,3,4,5
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
        }
        if (start == end && target != nums[start]) return -1;
        return start;
    }
}
