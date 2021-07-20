package com.company;

import java.util.List;
import java.util.ArrayList;

public class RotateMatrix {

    //PROBLEM: Rotate Image
    //  -You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
    //
    //  -You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
    //  DO NOT allocate another 2D matrix and do the rotation.
    //
    //  -Constraints:
    //  matrix.length == n
    //  matrix[i].length == n
    //  1 <= n <= 20
    //  -1000 <= matrix[i][j] <= 1000

    public static void main(String[] args) {
        int[][] matrix = {{5,1,9,11}, {2,4,8,10}, {13,3,6,7}, {15,14,12,16}};
        rotate3(matrix);
        for(int[] arr : matrix){
            for(int num : arr)
                System.out.println(num);
        }
    }

    //took 0 ms (100 percentile) and 39 MB (62 percentile) (uses secondary array for rotated elements)
    public static void rotate(int[][] matrix){
        int[][] resMatrix = new int[matrix.length][matrix[0].length];

        for(int r = 0; r < matrix.length; r++){
            for(int c = 0; c < matrix[r].length; c++)
            {
                resMatrix[c][matrix.length - 1 - r] = matrix[r][c];
            }
        }

        System.arraycopy(resMatrix, 0, matrix, 0, resMatrix.length);
    }

    //took 0 ms (100 percentile) and 39.2 MB (48 percentile) (uses secondary array for rotated elements)
    public static void rotate2(int[][] matrix){
        int temp;
        int n = matrix.length;
        for(int r = 0; r < (n + 1) / 2; r++){
            for(int c = 0; c < n / 2; c++)
            {
                temp = matrix[n - 1 - c][r];
                matrix[n - 1 - c][r] = matrix[n - 1 - r][n - c - 1];
                matrix[n - 1 - r][n - c - 1] = matrix[c][n - 1 -r];
                matrix[c][n - 1 - r] = matrix[r][c];
                matrix[r][c] = temp;
            }
        }
    }

    //took 0 ms (100 percentile) and 39 MB (62 percentile) (first mirrors the matrix about diagonal and then,
    //reverses each row
    public static void rotate3(int[][] matrix) {
        int n = matrix.length;

        //first, mirror the matrix about diagonal
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < r; c++){
                int temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp;
            }
        }

        //second, reverse the rows
        for (int r = 0; r < n; r++) {
            for (int c = 0; c <= (n - 1) / 2; c++) {
                int temp = matrix[r][c];
                matrix[r][c] = matrix[r][n - 1 - c];
                matrix[r][n - 1 - c] = temp;
            }
        }
    }
}
