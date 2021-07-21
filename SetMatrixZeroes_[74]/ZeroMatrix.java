package com.company;

import java.util.Arrays;

public class ZeroMatrix {

    //PROBLEM : Zero Matrix
    //  -Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's,
    //  and return the matrix.
    //
    //  -You must do it in place
    //
    //  -Constraints
    //  m == matrix.length
    //  n == matrix[0].length
    //  1 <= m, n <= 200
    //  -2^31 <= matrix[i][j] <= 2^31 - 1

    public static void main(String[] args) {
        int[][] matrix = {{0}, {1}};
        setZeroes2(matrix);
        for(int[] row : matrix)
            for(int num : row)
                System.out.println(num);
    }

    //took 1 ms (94 percentile) and 40.6 MB (50 percentile) (uses two arrays to store the row and col indexes
    //where 0 was encountered
    public static void setZeroes(int[][] matrix) {
        boolean[] rows = new boolean[matrix.length];
        boolean[] cols = new boolean[matrix[0].length];

        for(int r = 0; r < matrix.length; r++){
            for(int c = 0; c < matrix[0].length; c++){
                if(matrix[r][c] == 0) {
                    rows[r] = true;
                    cols[c] = true;
                }
            }
        }

        for(int i = 0; i < rows.length; i++){
            boolean bool = rows[i];
            if(bool)
                Arrays.fill(matrix[i], 0);
        }

        for(int j = 0; j < cols.length; j++){
            boolean bool = cols[j];
            if(bool) {
               for(int r = 0; r < matrix.length; r++){
                    matrix[r][j] = 0;
               }
            }
        }
    }

    //took 0 ms (100 percentile) and 40.8 MB (39 percentile) (does the modification in-place)
    public static void setZeroes2(int[][] matrix) {

        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;

        //check if first row originally has zero
        for(int j = 0; j < matrix[0].length; j++){
            if(matrix[0][j] == 0){
                firstRowHasZero = true;
                break;
            }
        }

        //check if first column originally has zero
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][0] == 0){
                firstColHasZero = true;
                break;
            }
        }

        //for each 0 encountered in any row/column other first row/col, put 0 in first cell of that row and column
        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //make column (all except first column) zero, if its first cell has 0 in it
        for(int c = 1; c < matrix[0].length; c++){
            if(matrix[0][c] == 0){
                for(int r = 0; r < matrix.length; r++)
                    matrix[r][c] = 0;
            }
        }

        //make row (all except first row) zero, if its first cell has 0 in it
        for(int r = 1; r < matrix.length; r++){
            if(matrix[r][0] == 0){
                for(int c = 0; c < matrix[0].length; c++)
                    matrix[r][c] = 0;
            }
        }

        if(firstRowHasZero)
            Arrays.fill(matrix[0], 0);

        if(firstColHasZero){
            for(int r = 0; r < matrix.length; r++)
                matrix[r][0] = 0;
        }
    }
}
