import java.util.*;

public class WallsAndGates {

    //PROBLEM: Walls and Gates
    //  You are given an m x n grid rooms initialized with these three possible values.
    //  -1 A wall or an obstacle.
    //  0 A gate.
    //  INF Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that
    //  the distance to a gate is less than 2147483647.
    //  Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be
    //  filled with INF.
    //Constraints:
    //  m == rooms.length
    //  n == rooms[i].length
    //  1 <= m, n <= 250
    //  rooms[i][j] is -1, 0, or 231 - 1.

    public static void main(String[] args) {
        int[][] rooms = new int[][]{
                {2147483647,-1,0,2147483647},
                {2147483647,2147483647,2147483647,-1},
                {2147483647,-1,2147483647,-1},
                {0,-1,2147483647,2147483647}
        };
        wallsAndGates2(rooms);
        for(int[] rows : rooms)
            for(int col : rows)
                System.out.println(col);
    }

    // time complexity: O(m ^ 2 * n ^ 2)
    // space complexity: O(mn)
    // [HashSet] Traverses the rooms and as soon as gate is found, do dfs to go to its neighbouring cell. Also, to avoid
    //revisiting the same room, it uses HashSet
    //threw TLE
    static Set<List<Integer>> set = new HashSet<>();
    public static void wallsAndGates(int[][] rooms) {
        for(int r = 0; r < rooms.length; r++){
            for(int c = 0; c < rooms[r].length; c++){
                if(rooms[r][c] == 0){
                    set.add(List.of(r,c));
                    dfs(rooms, r - 1, c, 0);
                    dfs(rooms, r + 1, c, 0);
                    dfs(rooms, r, c - 1, 0);
                    dfs(rooms, r, c + 1, 0);
                }
            }
        }
    }
    public static void dfs(int[][] rooms, int row, int col, int distance){
        if(row < 0 || row >= rooms.length || col < 0 || col >= rooms[row].length ||
                (set.contains(List.of(row, col)) && distance >= rooms[row][col]) ||
                rooms[row][col] == -1) return;

        if(rooms[row][col] != 0){
            rooms[row][col] = Math.min(rooms[row][col], distance + 1);
            set.add(List.of(row, col));
            dfs(rooms, row - 1, col, distance + 1);
            dfs(rooms, row + 1, col, distance + 1);
            dfs(rooms, row, col - 1, distance + 1);
            dfs(rooms, row, col + 1, distance + 1);
        }
    }


    // time complexity: O(mn)
    // space complexity: O(mn)
    //[Queue] Traverse the rooms to place all the gates in the Queue. Then, for each element in Queue find all the adjacent
    //cells and update its distance, until the queue is empty
    //took 1414 ms (lint code: 78 percentile)
    static int EMPTY = Integer.MAX_VALUE;
    static List<int[]> directions = Arrays.asList(
            new int[]{0, 1},
            new int[]{0, -1},
            new int[]{1, 0},
            new int[]{-1,0}
    );
    public static void wallsAndGates2(int[][] rooms) {
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < rooms.length; i++){
            for(int j = 0; j < rooms[0].length; j++){
                if(rooms[i][j] == 0)
                    q.offer(new int[]{i, j});
            }
        }
        while(!q.isEmpty()){
            int[] org = q.poll();
            int orgRow = org[0];
            int orgCol = org[1];
            for(int[] dir : directions){
                int newRow = orgRow + dir[0];
                int newCol = orgCol + dir[1];
                if(newRow < 0 || newCol < 0 || newRow >= rooms.length || newCol >= rooms[orgRow].length ||
                        rooms[newRow][newCol] != EMPTY) continue;
                rooms[newRow][newCol] = rooms[orgRow][orgCol] + 1;
                q.offer(new int[]{newRow, newCol});
            }
        }
    }
}
