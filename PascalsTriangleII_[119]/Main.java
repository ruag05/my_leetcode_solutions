package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    //PROBLEM
    //  Given an integer rowIndex, return the rowIndex^th (0-indexed) row of the Pascal's triangle.
    //
    //  -In Pascal's triangle, each number is the sum of the two numbers directly above.
    //
    // -Constraints:
    //  0 <= rowIndex <= 33

    public static void main(String[] args) {
        for(int num : getRow2(5)){
            System.out.println(num);
        }
    }

    //approach#1
    // threw Time Limit Exceeded (simple recursion - brute force)
    public static List<Integer> getRow(int rowIndex){
        List<Integer> result = new ArrayList<>();
        for(int col = 0; col <= rowIndex; col++){
            result.add(getNumber(rowIndex,col));
        }
        return result;
    }
    public static int getNumber(int rowIndex, int colIndex){
        if(rowIndex == 0) return 1;
        if(colIndex == 0 || colIndex == rowIndex) return 1;
        return getNumber(rowIndex - 1, colIndex - 1) + getNumber(rowIndex - 1, colIndex);
    }

    ///////////////////////////

    //approach#2
    // took 0 ms (100 percentile) and 36.5 MB (91 percentile) (generates n^th row elements without generating
    // previous rows, uses relationship between the current element and the previous element in the same row)
    public static List<Integer> getRow2(int rowIndex){
        Integer[] result = new Integer[rowIndex + 1];
        result[0] = 1;
        for(int i = 1; i < result.length; i++)
            result[i] = 0;

        for(int i = 1; i <= rowIndex; i++){
            for(int j = i; j >= 1; j--){
                result[j] += result[j - 1];
            }
        }

        return Arrays.asList(result);
    }
}
