import java.util.*;

public class KeysAndRooms {
    //PROBLEM: Keys And Rooms
    //  There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0. Your goal is to visit
    //  all the rooms. However, you cannot enter a locked room without having its key.
    //  When you visit a room, you may find a set of distinct keys in it. Each key has a number on it, denoting which
    //  room it unlocks, and you can take all of them with you to unlock the other rooms.
    //  Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i, return true if
    //  you can visit all the rooms, or false otherwise
    //Constraints:
    //  n == rooms.length
    //  2 <= n <= 1000
    //  0 <= rooms[i].length <= 1000
    //  1 <= sum(rooms[i].length) <= 3000
    //  0 <= rooms[i][j] < n
    //  All the values of rooms[i] are unique.
    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(List.of(1));
        rooms.add(List.of(2));
        rooms.add(List.of(3));
        rooms.add(List.of(0));

        System.out.println(canVisitAllRooms2(rooms));
    }

    // time complexity: O(n)
    // space complexity: O(n)
    //[Stack and HashSet] Push 0 [room] into stack and while stack is not empty keep popping. For each popped room,
    //get the keys and push them into stack in order to visit later. Also, to prevent duplicate entries in stack, use
    //HashSet
    //took 4 ms (15 percentile) and 41.9 MB (7 percentile)
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();

        stack.push(0);
        visited.add(0);

        while(!stack.isEmpty()){
            int top = stack.pop();
            List<Integer> keys = rooms.get(top);
            for(int key : keys) {
                if(!visited.contains(key)) {
                    stack.push(key);
                    visited.add(key);
                }
            }
        }

        return visited.size() == rooms.size();
    }

    // time complexity: O(n)
    // space complexity: O(n)
    //[Stack and boolean array] Push 0 [room] into stack and while stack is not empty keep popping. For each popped room,
    //get the keys and push them into stack in order to visit later. Also, to prevent duplicate entries in stack, use
    //boolean[]
    //took 1 ms (84 percentile) and 38.9 MB (71 percentile)
    public static boolean canVisitAllRooms2(List<List<Integer>> rooms) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[rooms.size()];

        stack.push(0);
        visited[0] = true;

        while(!stack.isEmpty()){
            int top = stack.pop();
            List<Integer> keys = rooms.get(top);
            for(int key : keys){
                if(!visited[key]){
                    stack.push(key);
                    visited[key] = true;
                }
            }
        }

        for(boolean status : visited)
            if(!status) return false;

        return true;
    }
}
