package com.leetcode_solutions.ruchir;

//PROBLEM
//	-Given an array nums of integers, return how many of them contain an even number of digits.

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{555,9010,482,1771};
        System.out.println(findNumbers_2(nums));
    }
    public static int findNumbers(int[] nums) {
        int evenDigitNumbers = 0;
        for (int i : nums) {
            double quotient = i;
            int digitLength = 0;
            while(quotient >= 1){
                quotient /= 10;
                digitLength ++;
            }
            if(digitLength %2 == 0)
                evenDigitNumbers ++;
        }
        return evenDigitNumbers;
    }
    public static int findNumbers_1(int[] nums) {
        int evenDigitNumbers = 0;
        for (int i : nums) {
            double quotient = i;
            int digitLength = 0;
            while(quotient >= 1){
                quotient /= 10;
                digitLength ++;
            }
            evenDigitNumbers = (digitLength % 2 == 0) ? evenDigitNumbers + 1: evenDigitNumbers;
        }
        return evenDigitNumbers;
    }
    public static int findNumbers_2(int[] nums) { //best performance
        int evenDigitNumbers = 0;
        for (int i : nums) {
            int digitLength = 0;
            while(i >= 1){
                i /= 10;
                digitLength ++;
            }
            if(digitLength % 2 == 0)
                evenDigitNumbers++;
        }
        return evenDigitNumbers;
    }
}
