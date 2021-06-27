package com.leetcode_solutions.ruchir;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

public class Main {

    //PROBLEM
    //  -Given an array arr of integers, check if there exists two integers N and M such that N
    //  is the double of M ( i.e. N = 2 * M).
    //
    //  -More formally check if there exists two indices i and j such that :
    //
    //  - i != j
    //  - 0 <= i, j < arr.length
    //  - arr[i] == 2 * arr[j]

    public static void main(String[] args){
        int[] arr = new int[]{5,10};
        System.out.println(checkIfExist1(arr));
    }

    //took 2 ms to execute and 38.6 MB
    public static boolean checkIfExist(int[] arr){
        if(arr == null)
            return false;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            if(map.containsValue(2 * arr[i]) || (arr[i] % 2 == 0 && map.containsValue(arr[i]/2)) ){
                return true;
            } else {
                map.put(i, arr[i]);
            }
        }
        return false;
    }

    //took 1 ms and 38.8 MB
    public static boolean checkIfExist1(int[] arr){
        if(arr == null)
            return false;

        Set<Integer> values = new HashSet<>();
        for(int element : arr){
            if(values.contains(2 * element) ||
            element % 2 == 0 && values.contains(element/2)){
                return true;
            } else{
                values.add(element);
            }
        }
        return false;
    }
}
