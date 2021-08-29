import java.util.*;

public class ZeroOneMatrix {

    //PROBLEM: 01Matrix
    //  Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
    //  The distance between two adjacent cells is 1.
    //Constraints:
    //  m == mat.length
    //  n == mat[i].length
    //  1 <= m, n <= 104
    //  1 <= m * n <= 104
    //  mat[i][j] is either 0 or 1.
    //  There is at least one 0 in mat.

    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {1,1,0,0,1,0,0,1,1,0},
                {1,0,0,1,0,1,1,1,1,1},
                {1,1,1,0,0,1,1,1,1,0},
                {0,1,1,1,0,1,1,1,1,1},
                {0,0,1,1,1,1,1,1,1,0},
                {1,1,1,1,1,1,0,1,1,1},
                {0,1,1,1,1,1,1,0,0,1},
                {1,1,1,1,1,0,0,1,1,1},
                {0,1,0,1,1,0,1,1,1,1},
                {1,1,1,0,1,0,1,1,1,1}
        };
        for(int[] row : updateMatrix2(mat))
            for(int num : row)
                System.out.println(num);
    }


    // time complexity: O(m*n)
    // space complexity: O(m*n) [for Queue]
    //[BFS - Queue] Traverse through the matrix and for each cell that is 0, put that in the Queue. Then, pop the
    //cell (have 0 value) and check its neighbor whether their current value is smaller than current cell value + 1. If
    //not then update their value
    //took 12 ms (68 percentile) and 40.5 MB (97 percentile)
    public static int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < mat.length; i++)
            for(int j = 0; j < mat[0].length; j++)
                if(mat[i][j] == 0) q.offer(new int[]{i,j});
                else mat[i][j] = Integer.MAX_VALUE;

        int[][] dir = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
        while(!q.isEmpty()){

            int[] curr = q.poll();
            int currX = curr[0];
            int currY = curr[1];

            for(int i = 0; i < 4; i++){
                int newX = currX + dir[i][0];
                int newY = currY + dir[i][1];

                if(newX < 0 || newY < 0 || newX >= mat.length || newY >= mat[0].length ||
                        mat[newX][newY] <= mat[currX][currY] + 1) continue;

                q.offer(new int[]{newX,newY});
                mat[newX][newY] = mat[currX][currY] + 1;
            }
        }

        return mat;
    }

    // time complexity: O(m*n)
    // space complexity: O(1)
    //Traverse the matrix twice, in first time check if left/top cell + 1 has smaller value than current value. Then,
    //in second turn, check if right/bottom cell + 1 has smaller value than current value.
    //took 7 ms (82 percentile) and 42.2 MB (42 percentile)
    public static int[][] updateMatrix2(int[][] mat){
        int[][] res = new int[mat.length][mat[0].length];
        for(int[] row : res)
            Arrays.fill(row, Integer.MAX_VALUE - 10000);

        for(int i = 0; i < res.length; i++){
            for(int j = 0; j < res[0].length; j++){
                if(mat[i][j] == 0) res[i][j] = 0;
                else{
                    if(i > 0) res[i][j] = Math.min(res[i][j], res[i - 1][j] + 1);
                    if(j > 0) res[i][j] = Math.min(res[i][j], res[i][j - 1] + 1);
                }
            }
        }

        for(int i = mat.length - 1; i >= 0; i--){
            for(int j = mat[0].length - 1; j >= 0; j--){
                if(mat[i][j] == 0) res[i][j] = 0;
                else{
                    if(i < mat.length - 1) res[i][j] = Math.min(res[i][j], res[i + 1][j] + 1);
                    if(j < mat[0].length - 1) res[i][j] = Math.min(res[i][j], res[i][j + 1] + 1);
                }
            }
        }

        return res;
    }
}
