package com.company;

import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class PalindromePermutation {

    //PROBLEM
    //  -Given a string, write a function to check if it is a permutation of a palindrome.
    //  A palindrome is a word or phrase that is the same forwards and backwards.
    //  A permutation is a rearrangement of letters. The palindrome does not need to be limited to
    //  just dictionary words

    public static void main(String[] args) {
        String s = "Tact cap";
        System.out.println(palindromePermutation(s));
    }

    //took 162 ms (99 percentile - lintcode) and 13.94 MB
    public static boolean palindromePermutation(String s){
        char[] chArr = s.toLowerCase().toCharArray();

        //build a map for each element and its frequency
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < chArr.length; i++)
            map.put(chArr[i], map.getOrDefault(chArr[i], 0) + 1);

        //traverse map to check how many elements occurred odd times
        int oddCounter = 0;
        for(int num : map.values()){
            if(num % 2 == 1)
                oddCounter++;
            if(oddCounter > 1) return false;
        }
        return true;
    }

    public static boolean palindromePermutation2(String s){
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++)
            if(!set.add(s.charAt(i)))
                set.remove(s.charAt(i));

        return set.size() <= 1;
    }
}
