package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    //PROBLEM
    //  -Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.

    public static void main(String[] args) {
        int[][] mat = {{2,3},{4,5}};
        for(int num : findDiagonalOrder2(mat)){
            System.out.println(num);
        }
    }

    //took 4 ms (43 percentile) and 52 MB (15 percentile)
    public static int[] findDiagonalOrder(int[][] mat) {
        int r = 0, c = 0, m = mat.length, n = mat[0].length;
        int[] result = new int[mat.length * mat[0].length];
        for(int i = 0; i < result.length; i++) {
            result[i] = mat[r][c];

            //check whether the diagonal is going up/down
            if ((r + c) % 2 == 0) {
                if (c == n - 1) r++;
                else if (r == 0) c++;
                else {
                    r--;
                    c++;
                }
            } else {
                if (r == m - 1) c++;
                else if (c == 0) r++;
                else {
                    c--;
                    r++;
                }
            }
        }
        return result;
    }

    //took 5 ms (33 percentile) and 40.9 MB (72 percentile)
    public static int[] findDiagonalOrder2(int[][] mat){
        int r, c, m = mat.length, n = mat[0].length;
        int[] result = new int[m * n];
        int k = 0;
        List<Integer> diagonalArr = new ArrayList<>();

        for(int i = 0; i < m + n - 1; i++){
            diagonalArr.clear();

            //check the cases when the r and/or c reached the matrix bounds
            r = i < n ? 0 : i - n + 1;
            c = i < n ? i : n - 1;

            //traverse the diagonal
            while(r < m && c > -1){
                diagonalArr.add(mat[r][c]);
                r++;
                c--;
            }

            //if diagonal is going up
            if(i % 2 == 0)
                Collections.reverse(diagonalArr);

            //place all elements of the traversed diagonal in array
            for (Integer element : diagonalArr) {
                result[k++] = element;
            }
        }

        return result;
    }
}
