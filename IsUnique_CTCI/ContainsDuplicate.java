package com.company;

import java.util.*;

public class ContainsDuplicate {

    //PROBLEM: Is Unique
    //  -Implement an algorithm to determine if a string has all unique characters. What if you
    //  cannot use additional data structures?

    public static void main(String[] args){
        String name = "ruchi Agwl";
        System.out.println(containsUniqueCharactersOnly5(name));

        int[] nums = new int[]{1,1,1,3,3,4,3,2,4,2};
        System.out.println(containsDuplicate(nums));
    }

    //region For string input

    //uses HashMap
    public static boolean containsUniqueCharactersOnly(String s){
        s = s.toLowerCase();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            int ascii = s.charAt(i);
            if(map.get(ascii) != null)
                return false;
            map.put(ascii, 1);
        }
        return true;
    }

    //uses Set
    public static boolean containsUniqueCharactersOnly2(String s){
        s = s.toLowerCase();
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            if(!set.add(s.charAt(i))) return false;
        }
        return true;
    }

    //uses Hashtable
    public static boolean containsUniqueCharactersOnly3(String s){
        s = s.toLowerCase();
        Hashtable table = new Hashtable();
        for(int i = 0; i < s.length(); i++){
            if(table.get(s.charAt(i)) != null) return false;
            table.put((s.charAt(i)), 1);
        }
        return true;
    }

    //uses a boolean array to track whether the item was passed already
    public static boolean containsUniqueCharactersOnly4(String s){
        if (s.length() > 128) return false;
        boolean[] char_set = new boolean[128];
        for (int i= 0; i < s.length(); i++) {
            int val= s.charAt(i);
            if (char_set[val]) {//Already found this char in string
                return false;
            }
            char_set[val] = true;
            }
        return true;
    }

    //sorts the array and them compares the neighbouring elements
    public static boolean containsUniqueCharactersOnly5(String s){
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        for(int i = 1; i < arr.length; i++){
            if(arr[i] == arr[i - 1]) return false;
        }
        return true;
    }
    //endregion

    //region For integer input
    //took 6 ms (58 percentile) and 45 MB (47 percentile)
    public static boolean containsDuplicate(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            if(map.get(num) != null) return true;
            map.put(num, 1);
        }
        return false;
    }

    //took 4 ms (83 percentile) and 43.2 MB (73 percentile)
    public static boolean containsDuplicate2(int[] nums){
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(!set.add(num)) return true;
        }
        return false;
    }
    //endregion
}
