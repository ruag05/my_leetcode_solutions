import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class NumberOfIslands {

    //PROBLEM: Number of Islands
    //  Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the
    //  number of islands.
    //  An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
    //  You may assume all four edges of the grid are all surrounded by water.
    //Constraints:
    //  m == grid.length
    //  n == grid[i].length
    //  1 <= m, n <= 300
    //  grid[i][j] is '0' or '1'

    public static void main(String[] args){
        char[][] grid = {{'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(numIslands2(grid));
    }

    // time complexity: O(m*n)
    // space complexity: O(m*n)
    //[DFS/BFS] Traverse the grid and as soon as a '1' is encountered, increment the pointer and traverse all the
    //adjacent '1's and make them 0 (so we don't recount them) and then again continue traversing
    //took 1 ms (99.95 percentile) and 41.2 MB (79 percentile)
    public static int numIslands(char[][] grid){
        int numIslands = 0;

        //traverse the grid row-wise
        for(int i = 0; i < grid.length; i++){
            //traverse the current row column-wise
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1') {

                    //since at least one '1' is encountered, it is an island
                    numIslands += 1;

                    //go in all the directions from this '1' and make them '0' so that we don't recount them
                    dfs(grid, i, j);
                }
            }
        }

        return numIslands;
    }
    public static void dfs(char[][] grid, int i, int j){
        if(i < 0 || i >= grid.length ||
                j < 0 || j >= grid[i].length || grid[i][j] == '0' ) return ;

        grid[i][j] = '0';

        //go down
        dfs(grid, i + 1, j);
        //go up
        dfs(grid, i - 1, j);
        //go right
        dfs(grid, i, j + 1);
        //go left
        dfs(grid, i, j - 1);
    }

    // time complexity: O(mn)
    // space complexity: O(mn)
    //  [Queue] Traverse the grid and as soon as a '1' is encountered, place it in Queue. And for all its adjacent cells
    //  that are equal to 1, make them 0 and add them also to queue
    //  took 5 ms (12 percentile) and 41.2 MB (89 percentile)
    static List<int[]> directions = Arrays.asList(
            new int[]{0, 1},
            new int[]{0, -1},
            new int[]{1, 0},
            new int[]{-1, 0}
    );
    public static int numIslands2(char[][] grid){
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    grid[i][j] = '0';
                    q.offer(new int[]{i, j});
                    while(!q.isEmpty()){
                        int[] org = q.poll();
                        int orgR = org[0];
                        int orgC = org[1];
                        for(int[] dir : directions){
                            int newR = orgR + dir[0];
                            int newC = orgC + dir[1];
                            if(newR < 0 || newC < 0 || newR >= grid.length || newC >= grid[newR].length || grid[newR][newC] != '1') continue;
                            grid[newR][newC] = '0';
                            q.offer(new int[]{newR, newC});
                        }
                    }
                }
            }
        }

        return count;
    }
}
