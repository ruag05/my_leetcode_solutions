package com.company;

import java.util.HashMap;
import java.util.Map;

public class CheckPermutation {

    //PROBLEM: Valid Anagram
    //  -Given two strings s and t, return true if t is an anagram of s, and false otherwise
    //
    //  -Constraints:
    //  1 <= s.length, t.length <= 5 * 104
    //  s and t consist of lowercase English letters

    public static void main(String[] args){
        String a = "ihello";
        String b = "hello";
        System.out.println(checkPermutation2(a,b));
    }

    //took 12 ms (21 percentile) and 40.1 MB (20 percentile) (uses HashMap)
    public static boolean checkPermutation(String a, String b){
        if(a.length() != b.length()) return false;

        Map<Integer, Integer> map = new HashMap<>();
        for(char ch : a.toCharArray()){
            int chIndex = ch;
            if(map.get(chIndex) != null)
                map.put(chIndex,map.get(chIndex) + 1);
            else
                map.put(chIndex, 1);
        }
        for(char ch : b.toCharArray()){
            int chIndex = ch;
            if(map.get(chIndex) == null || map.get(chIndex) < 0) return false;
            map.put(chIndex, map.get(chIndex) - 1);
        }
        for(int num : map.values()) {
            if (num != 0) return false;
        }
        return true;
    }

    //took 1 ms (100 percentile) and 39.5 MB (38 percentile) (uses array)
    public static boolean checkPermutation2(String a, String b){
        if(a.length() != b.length()) return false;
        int[] tracker = new int[26];
        for(char ch : a.toCharArray())
            tracker[ch - 'a'] ++;
        for(char ch : b.toCharArray()) {
            tracker[ch - 'a']--;
            if (tracker[ch - 'a'] < 0) return false;
        }
        for(int num : tracker)
            if(num != 0) return false;
            return true;
    }
}
