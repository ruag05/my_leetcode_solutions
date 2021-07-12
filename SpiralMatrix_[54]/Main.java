package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    //PROBLEM
    //  -Given an m x n matrix, return all elements of the matrix in spiral order

    public static void main(String[] args) {
        int[][] mat = {{1,2},{3,4}, {5,6}}; //,3,4},{5,6,7,8}, {9,10,11,12}};
        for(int num : spiralOrder(mat)){
            System.out.println(num);
        }
    }

    //took 0 ms (100 percentile) and 37.3 MB (34 percentile)
    public static List<Integer> spiralOrder(int[][] matrix) {
        boolean movingRight = true, movingDown = false, movingLeft = false;
        int r = 0, c = 0, rCounter = 0, cCounter = 0, m = matrix.length, n = matrix[0].length;
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < m*n; i++){
            result.add(matrix[r][c]);
            if(movingRight){
                if(c < n - cCounter - 1) c++;
                else{
                    c = n - cCounter - 1;
                    r++;
                    movingRight = false;
                    movingDown = true;
                }
            } else if(movingDown){
                if(r < m - rCounter - 1) r ++;
                else{
                    r = m - rCounter - 1;
                    c--;
                    movingDown = false;
                    movingLeft = true;
                }
            } else if(movingLeft){
                if(c > cCounter) c--;
                else{
                    c = cCounter;
                    r--;
                    movingLeft = false;
                }
            } else {
                if(r > rCounter + 1) r--;
                else{
                    rCounter++;
                    cCounter++;
                    r = rCounter;
                    c = cCounter;
                    movingRight = true;
                }
            }
        }

        return result;
    }

    //took 0 ms (100 percentile) and 38 MB (22 percentile)
    public static List<Integer> spiralOrder2(int[][] matrix){
        List<Integer> res = new LinkedList<>();
        if (matrix == null || matrix.length == 0) return res;
        int n = matrix.length, m = matrix[0].length;
        int up = 0,  down = n - 1;
        int left = 0, right = m - 1;
        while (res.size() < n * m) {
            for (int j = left; j <= right && res.size() < n * m; j++)
                res.add(matrix[up][j]);

            for (int i = up + 1; i <= down - 1 && res.size() < n * m; i++)
                res.add(matrix[i][right]);

            for (int j = right; j >= left && res.size() < n * m; j--)
                res.add(matrix[down][j]);

            for (int i = down - 1; i >= up + 1 && res.size() < n * m; i--)
                res.add(matrix[i][left]);

            left++; right--; up++; down--;
        }
        return res;
    }
}
