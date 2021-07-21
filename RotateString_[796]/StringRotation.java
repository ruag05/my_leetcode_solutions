package com.company;

public class StringRotation {

    //PROBLEM : Rotate String
    //  -Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
    //
    //  A shift on s consists of moving the leftmost character of s to the rightmost position.
    //
    //  For example, if s = "abcde", then it will be "bcdea" after one shift.
    //
    //  -Constraints:
    //  1 <= s.length, goal.length <= 100
    //  s and goal consist of lowercase English letters

    public static void main(String[] args) {
        String s = "bbbacddceeb";
        String goal = "ceebbbbacdd";
        System.out.println(rotateString2(s, goal));
    }

    //took 0 ms (100 percentile) and 36.9 MB (75 percentile)
    public static boolean rotateString(String s, String goal){
        if(s.length() != goal.length()) return false;

        search:
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < goal.length(); j++){
                if(s.charAt((i + j) % goal.length()) != goal.charAt(j)) continue search;
            }
            return true;
        }
        return false;
    }

    //took 0 ms (100 percentile) and 36.7 MB (83.3 percentile)
    public static boolean rotateString2(String s, String goal){
        if(s.length() != goal.length()) return false;
        return s.concat(s).contains(goal);
    }
}
