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
    //  time complexity: O(k^2)
    //  space complexity: O(k)
    //took 63 ms (2 percentile) and 38.9 MB (8 percentile)
    //[recursion] Build a secondary array and fill it with default 0 values. Then using recursion store each of computed
    //values in a Map with that {rowIndex, colIndex} as key and computed value as Value
    private final class RowCol {
        private int row, col;

        public RowCol(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public int hashCode() {
            int result = (int) (row ^ (row >>> 32));
            return (result << 5) - 1 + (int) (col ^ (col >>> 32)); // 31 * result == (result << 5) - 1
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null) return false;
            if (this.getClass() != o.getClass()) return false;

            RowCol rowCol = (RowCol) o;
            return row == rowCol.row && col == rowCol.col;
        }
    }

    private Map<RowCol, Integer> cache = new HashMap<>();

    private int getNum2(int row, int col) {
        RowCol rowCol = new RowCol(row, col);
        if (cache.containsKey(rowCol)) {
            return cache.get(rowCol);
        }
        int computedVal =
                (row == 0 || col == 0 || row == col) ? 1 : getNum2(row - 1, col - 1) + getNum2(row - 1, col);
        cache.put(rowCol, computedVal);
        return computedVal;
    }

    public List<Integer> getRow2(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            ans.add(getNum2(rowIndex, i));
        }
        return ans;
    }
    
    ///////////////////////////

    //approach#3
    // took 0 ms (100 percentile) and 36.5 MB (91 percentile) (generates n^th row elements without generating
    // previous rows, uses relationship between the current element and the previous element in the same row)
    public static List<Integer> getRow3(int rowIndex){
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
