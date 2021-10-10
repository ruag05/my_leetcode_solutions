package com.company;

public class Main {

    //PROBLEM
    //  -Write a function that reverses a string. The input string is given as an array of characters s
    //
    //  -Constraints:
    //  1 <= s.length <= 105
    //  s[i] is a printable ascii character

    public static void main(String[] args) {
        char[] s = new char[]{'h','e','l','l','o'};
        reverseString(s);
    }

    //using iteration
    //took 1 ms (95.5 percentile) and 45.9 MB (54.3 percentile)
    public static void reverseString(char[] s) {
        if(s.length > 1){
            int i = 0, j = s.length - 1;
            char temp;
            while(i < j){
                temp = s[i];
                s[i++] = s[j];
                s[j--] = temp;
            }
        }
    }
    
    //using recursion
    //took 2 ms and 49.3 MB
    public void reverseString1(char[] s){
        helper(s, 0, s.length - 1);
    }
    public void helper(char[] arr, int start, int end){
        if(start >= end) return;
        
        Character ch = arr[start];
        arr[start++] = arr[end];
        arr[end--] = ch;
        helper(arr, start, end);
    }
}
