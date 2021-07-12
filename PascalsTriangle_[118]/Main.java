package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    //PROBLEM
    //  -Given an integer numRows, return the first numRows of Pascal's triangle.
    //
    //  -In Pascal's triangle, each number is the sum of the two numbers directly above it.
    //
    //  -Constraints:
    //
    //  1 <= numRows <= 30

    public static void main(String[] args) {
        for(List<Integer> row : generate2(5)){
            for(int num : row){
                System.out.print(num + " ");
            }
            System.out.println(" ");
        }
    }

    //took 0 ms (100 percentile) and 37.2 MB (23 percentile)
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);

        List<Integer> tempArr;

        int k = 2;
        while(k <= numRows){
            tempArr = new ArrayList<>();

            //first element is always 1
            tempArr.add(1);

            //middle elements are sum of above two elements
            for(int i = 1; i < k - 1; i++){
                tempArr.add(i, (result.get(k - 1 - 1).get(i) + result.get(k - 1 - 1).get(i - 1)));
            }

            //last element is always 1
            tempArr.add(1);

            result.add(tempArr);
            k++;
        }
        return result;
    }

    //took 0 ms (100 percentile) and 36.7 MB (80 percentile) (optimized solution)
    public static List<List<Integer>> generate2(int numRows)
    {
        List<List<Integer>> result = new ArrayList<>();

        ArrayList<Integer> row = new ArrayList<>();
        for(int i = 0; i < numRows;i++)
        {
            //always add a new element to the start of the row
            row.add(0, 1);

            //manipulate the middle elements (excluding the first (by starting j from 1)
            // and last element (by setting j < row.size() - 1)
            //Also, this 'for' loop will only be entered from 2nd row onwards
            for(int j = 1; j < row.size() - 1; j++)
                row.set(j, row.get(j) + row.get(j+1));

            //add the current row formed to final list
            result.add(new ArrayList<>(row));
        }

        return result;
    }
}
