package com.leetcode_solutions.ruchir;

import java.util.*;

public class Main {

    //PROBLEM
    //  -Given an array of intervals where intervals[i] = [starti, endi], merge all
    // overlapping intervals, and return an array of the non-overlapping intervals
    // that cover all the intervals in the input.
    //
    //  -Constraints:
    //
    //  - 1 <= intervals.length <= 104
    //  - intervals[i].length == 2
    //  - 0 <= starti <= endi <= 104

    public static void main(String[] args) {
        int[][] intervals = {{1,4},{4,6}};
        int[][] result = merge(intervals);
    }

    //took 6 ms (57 percentile) and 41.9 MB ( 37 percentile)
    public static int[][] merge(int[][] intervals){
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> result = new LinkedList<>();
        for(int[] interval : intervals){
            if(result.isEmpty() || result.getLast()[1] < interval[0]){
                result.add(interval);
            } else if(result.getLast()[1] >= interval[0]){
                result.getLast()[1] = Math.max(result.getLast()[1], interval[1]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
