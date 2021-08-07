import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {

    //PROBLEM: Pacific Atlantic Water Flow
    //  There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean
    //  touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.
    //  The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where
    //  heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
    //  The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east,
    //  and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from
    //  any cell adjacent to an ocean into the ocean.
    //  Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from
    //  cell (ri, ci) to both the Pacific and Atlantic oceans.
    //Constraints:
    //  m == heights.length
    //  n == heights[r].length
    //  1 <= m, n <= 200
    //  0 <= heights[r][c] <= 105

    public static void main(String[] args) {
        int[][] heights = {
                {1,2,2},
                {3,4,2}
        };
        for(List<Integer> cell : pacificAtlantic(heights)){
            System.out.println('[' + cell.get(0) + ',' + cell.get(1) + ']');
        }
    }

    // time complexity: O(m*n)
    // space complexity: O(m*n)
    //[DFS] Instead of starting from a cell and going till ocean, start from the ocean and see which all cells are
    //reachable, that is start from all the 4 borders one-by-one(i.e., twice for each ocean)(This approach is better as
    //as when we start traversal from cell, result is applicable only for that cell, however, when we start from ocean
    //and go backwards we already know that every cell we visit must be connected to the ocean). FOr traversal, use DFS
    //While traversing from a ocean keep storing true/false for each cell that is reachable for that specific ocean, we
    //need to do this for both the ocean separately
    //took 3 ms (98.9 percentile) and 40 MB (82 percentile)
    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        if(heights == null || heights.length == 0) return null;

        int rowsCount = heights.length;
        int colsCount = heights[0].length;

        boolean[][] visitedPacific = new boolean[rowsCount][colsCount];
        boolean[][] visitedAtlantic = new boolean[rowsCount][colsCount];
        List<List<Integer>> result = new ArrayList<>();

        //find the cells reachable from pacific and atlantic from left and right, respectively
        for(int r = 0; r < rowsCount; r++){
            dfs(heights, r, 0, Integer.MIN_VALUE, visitedPacific);
            dfs(heights, r, colsCount - 1, Integer.MIN_VALUE, visitedAtlantic);
        }
        //find the cells reachable from pacific and atlantic from top and bottom, respectively
        for(int c = 0; c < colsCount; c++){
            dfs(heights, 0, c, Integer.MIN_VALUE, visitedPacific);
            dfs(heights, rowsCount - 1, c, Integer.MIN_VALUE, visitedAtlantic);
        }

        //find the cells that are reachable in both visitedPacific and visitedAtlantic
        for(int i = 0; i < rowsCount; i++){
            for(int j = 0; j < colsCount; j++){
                if(visitedPacific[i][j] && visitedAtlantic[i][j] )
                    result.add(Arrays.asList(i,j));
            }
        }
        return result;
    }
    public static void dfs(int[][] heights, int i, int j, int prev, boolean[][] ocean){
        if(i < 0 || i >= heights.length || j < 0 || j >= heights[i].length) return;
        if(heights[i][j] < prev) return;
        if(ocean[i][j]) return;

        ocean[i][j] = true;

        dfs(heights, i + 1, j, heights[i][j], ocean);
        dfs(heights, i - 1, j, heights[i][j], ocean);
        dfs(heights, i, j + 1, heights[i][j], ocean);
        dfs(heights, i, j - 1, heights[i][j], ocean);
    }
}
