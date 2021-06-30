package com.leetcode_solutions.ruchir;

public class Main {

    //PROBLEM
    //  -Given n non-negative integers a1, a2, ..., an , where each represents a point at
    //  coordinate (i, ai). n vertical lines are drawn such that the two endpoints of the
    //  line i is at (i, ai) and (i, 0). Find two lines, which, together with the x-axis
    //  forms a container, such that the container contains the most water.
    //
    //  -Notice that you may not slant the container.

    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,8};
        System.out.println(maxArea(height));
    }

    //took 2 ms (98 percentile) and 52.4 MB (82 percentile)
    public static int maxArea(int[] height){
        int i = 0, j = height.length - 1;
        int maxArea = 0;
        while(i < j) {
            int area = (j - i) * Math.min(height[i],height[j]);
            if (area > maxArea) {
                maxArea = area;
            }
           if(height[i] < height[j]){
                i++;
           } else
               j--;
        }
        return maxArea;
    }
}
