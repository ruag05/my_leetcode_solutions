package com.company;

public class Main {

    //PROBLEM
    //  -Write a function to find the longest common prefix string amongst an array of strings.
    //
    //  -If there is no common prefix, return an empty string ""
    //
    //  -Constraints:
    //
    //  1 <= strs.length <= 200
    //  0 <= strs[i].length <= 200
    //  strs[i] consists of only lower-case English letters.

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    //took 0 ms (100 percentile) and 37. MB (61 percentile)
    public static String longestCommonPrefix(String[] strs){
        for(int i = 0; i < strs[0].length(); i++){
            char c = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++){
                if(i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }
}
