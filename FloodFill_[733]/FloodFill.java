import java.util.*;

public class FloodFill {

    //PROBLEM: Flood Fill
    //  An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
    //  You are also given three integers sr, sc, and newColor. You should perform a flood fill on the image starting
    //  from the pixel image[sr][sc].
    //  To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting
    //  pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels
    //  (also with the same color), and so on. Replace the color of all of the aforementioned pixels with newColor.
    //  Return the modified image after performing the flood fill.
    //Constraints:
    //  m == image.length
    //  n == image[i].length
    //  1 <= m, n <= 50
    //  0 <= image[i][j], newColor < 216
    //  0 <= sr < m
    //  0 <= sc < n

    public static void main(String[] args) {
        int[][] image = {
                {0,0,0},
                {0,1,1}
        };
        for(int[] row : floodFill(image, 1,1, 1)) {
            for (int val : row) System.out.print(val);
            System.out.println(" ");
        }
    }

    // time complexity: O(n)
    // space complexity: O(n)
    //[DFS and HashSet] Start from the origin pixel and go in all directions in DFS way and keep changing their color.
    //Also, to not evaluate the same pixel again, use a HashSet
    //took 2 ms (20 percentile) and 39.5 MB (93 percentile)
    static List<int[]> directions =  Arrays.asList(
        new int[]{0,1},
        new int[]{0,-1},
        new int[]{1,0},
        new int[]{-1,0}
    );
    static Set<List<Integer>> set = new HashSet<>();
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int orgColor = image[sr][sc];
        if(orgColor != newColor) dfs(image, sr, sc, orgColor, newColor);
        return image;
    }
    public static void dfs(int[][] image, int r, int c, int orgColor, int newColor){
        if(r < 0 || r >= image.length || c < 0 || c >= image[r].length ||
                image[r][c] != orgColor || set.contains(List.of(r, c))) return;

        image[r][c] = newColor;
        set.add(List.of(r, c));

        for(int[] dir : directions){
            int newR = r + dir[0];
            int newC = c + dir[1];
            dfs(image, newR, newC, orgColor, newColor);
        }
    }


    // time complexity: O(n)
    // space complexity: O(n)
    //[DFS][Optimized] If the pixel's original color is not equals to newColor, start from the origin pixel
    //and go in all directions in DFS way and keep changing their color. As we have checked, that the original color
    //and new color are not same and because we are changing color, we do not need HashSet, as no pixel will be evaluated
    //again
    //took 1 ms (52 percentile) and 39.6 MB (84 percentile)
    static List<int[]> directions1 =  Arrays.asList(
            new int[]{0,1},
            new int[]{0,-1},
            new int[]{1,0},
            new int[]{-1,0}
    );
    public static int[][] floodFill1(int[][] image, int sr, int sc, int newColor) {
        int orgColor = image[sr][sc];
        if(orgColor != newColor) dfs1(image, sr, sc, orgColor, newColor);
        return image;
    }
    public static void dfs1(int[][] image, int r, int c, int orgColor, int newColor){
        if(r < 0 || r >= image.length || c < 0 || c >= image[r].length ||
                image[r][c] != orgColor ) return;

        image[r][c] = newColor;

        for(int[] dir : directions1){
            int newR = r + dir[0];
            int newC = c + dir[1];
            dfs1(image, newR, newC, orgColor, newColor);
        }
    }

    // time complexity: O(n)
    // space complexity: O(n)
    //[DFS][Optimized] If the pixel's original color is not equals to newColor, start from the origin pixel
    //and go in all directions in DFS way and keep changing their color. As we have checked, that the original color
    //and new color are not same and because we are changing color, we do not need HashSet, as no pixel will be evaluated
    //again
    //took 0 ms (100 percentile) and 45.1 MB (6 percentile)
    public static int[][] floodFill2(int[][] image, int sr, int sc, int newColor) {
        int orgColor = image[sr][sc];
        if(orgColor != newColor) dfs2(image, sr, sc, orgColor, newColor);
        return image;
    }
    public static void dfs2(int[][] image, int r, int c, int orgColor, int newColor){
        if(image[r][c] == orgColor){
            image[r][c] = newColor;
            if(r >= 1) dfs2(image, r - 1, c, orgColor, newColor);
            if(c >= 1) dfs2(image, r, c - 1, orgColor, newColor);
            if(r + 1 < image.length) dfs2(image, r + 1, c, orgColor, newColor);
            if(c + 1 < image[0].length) dfs2(image, r, c + 1, orgColor, newColor);
        }
    }


    // time complexity: O(n)
    // space complexity: O(n)
    //[BFS - Queue and HashSet] Start from the origin pixel and go in all directions in DFS way and keep changing their color.
    //Also, to not evaluate the same pixel again, use a HashSet
    //took 3 ms (7 percentile) and 40.1 MB (28 percentile)
    static List<int[]> directions3 =  Arrays.asList(
            new int[]{0,1},
            new int[]{0,-1},
            new int[]{1,0},
            new int[]{-1,0}
    );
    static Set<List<Integer>> set3 = new HashSet<>();
    public static int[][] floodFill3(int[][] image, int sr, int sc, int newColor){
        int orgColor = image[sr][sc];
        image[sr][sc] = newColor;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});
        set3.add(List.of(sr, sc));

        while(!q.isEmpty()){
            int[] cell = q.poll();

            for(int[] dir : directions3){
                int newR = cell[0] + dir[0];
                int newC = cell[1] + dir[1];
                if(newR < 0 || newR >= image.length || newC < 0 || newC >= image[newR].length ||
                        image[newR][newC] != orgColor || set3.contains(List.of(newR, newC))) continue;

                image[newR][newC] = newColor;
                set3.add(List.of(newR, newC));
                q.offer(new int[]{newR, newC});
            }
        }

        return image;
    }
}
