package com.leetcode_solutions.ruchir;

public class Main {

    //PROBLEM
    //  -Given integer array nums, return the third maximum number in this array.
    //  If the third maximum does not exist, return the maximum number.
    //
    //  -Constraints:
    //  - 1 <= nums.length <= 104
    //  - -231 <= nums[i] <= 231 - 1

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,-1 };
        System.out.println(thirdMax2(nums));
    }

    //took 2 ms (67 percentile) and 39 MB (51 percentile)
    public static int thirdMax1(int[] nums){
        Integer fLargest = null, sLargest = null, tLargest = null;
        for(Integer element : nums){
            if(element.equals(fLargest)||
                    element.equals(sLargest) ||
                    element.equals(tLargest))
                continue;
            if(fLargest == null || element > fLargest){
                tLargest = sLargest;
                sLargest = fLargest;
                fLargest = element;
            } else if(sLargest == null ||element > sLargest){
                tLargest = sLargest;
                sLargest = element;
            } else if(tLargest == null ||element > tLargest){
                tLargest = element;
            }
        }
        return tLargest == null ? fLargest : tLargest;
    }

    //took 1 ms (89 percentile) and 38 MB (30 percentile)
    public static int thirdMax2(int[] nums){
        long fLargest = Long.MIN_VALUE, sLargest = Long.MIN_VALUE, tLargest = Long.MIN_VALUE;
        for(int element : nums){
            if(element == fLargest ||
            element == sLargest ||
            element == tLargest)
                continue;
            if(element > fLargest){
                tLargest = sLargest;
                sLargest = fLargest;
                fLargest = element;
            } else if(element > sLargest){
                tLargest = sLargest;
                sLargest = element;
            } else if(element > tLargest){
                tLargest = element;
            }
        }
        return tLargest == Long.MIN_VALUE ? (int) fLargest : (int) tLargest;
    }
}
