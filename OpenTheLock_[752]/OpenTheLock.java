import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Arrays;

public class OpenTheLock {

    //PROBLEM: Open The Lock
    //  You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5',
    //  '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0'
    //  to be '9'. Each move consists of turning one wheel one slot.
    //  The lock initially starts at '0000', a string representing the state of the 4 wheels.
    //  You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the
    //  lock will stop turning and you will be unable to open it.
    //  Given a target representing the value of the wheels that will unlock the lock, return the minimum total number
    //  of turns required to open the lock, or -1 if it is impossible.
    //Constraints:
    //  1 <= deadends.length <= 500
    //  deadends[i].length == 4
    //  target.length == 4
    //  target will not be in the list deadends.
    //  target and deadends[i] consist of digits only

    public static void main(String[] args) {

    }

    // time complexity: O(m^n * n^2 + d); n: #dials in lock (4 letters)
    //                                    m: #possibilities in each dial (0->9 i.e., 10)
    //                                    d: #deadends
    //  There are 10 x 10 x 10 x 10 possible combinations => 10^4 => m^n
    //  For each combination, we are looping 4 times (which is n) and in each iteration, there are substring operations
    //  (which is O(n) * constant) => O(4n*constant) => O(4n) => O(nn) => O(n^2)
    //  space complexity: O(m*n = d); n: #dials in lock (4 letters)
    //                              m: #possibilities in each dial (0->9 i.e., 10)
    //                              d: #deadends
    //took 170 ms (31 percentile) and 47.1 MB (39 percentile)
    public int openLock(String[] deadends, String target) {
        Set<String> blocks = new HashSet<>(Arrays.asList(deadends));
        Queue<String> locks = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        locks.offer("0000");
        visited.add("0000");
        int minTurns = 0;

        while(!locks.isEmpty()){
            int size = locks.size();
            for(int i = 0; i < size; i++){
                String currLock = locks.poll();
                if(blocks.contains(currLock)) continue;
                if(currLock.equals(target)) return minTurns;

                StringBuilder sb = new StringBuilder(currLock);
                for(int j = 0; j < 4; j ++) {
                    char c = sb.charAt(j);
                    String s1 = sb.substring(0, j) + (c == '9' ? 0 : c - '0' + 1) + sb.substring(j + 1);
                    String s2 = sb.substring(0, j) + (c == '0' ? 9 : c - '0' - 1) + sb.substring(j + 1);
                    if(!visited.contains(s1) && !blocks.contains(s1)) {
                        locks.offer(s1);
                        visited.add(s1);
                    }
                    if(!visited.contains(s2) && !blocks.contains(s2)) {
                        locks.offer(s2);
                        visited.add(s2);
                    }
                }
            }
            minTurns++;
        }
        return -1;
    }

    // time complexity: O(m^n * n^2 + d); n: #dials in lock (4 letters)
    //                                    m: #possibilities in each dial (0->9 i.e., 10)
    //                                    d: #deadends
    //  There are 10 x 10 x 10 x 10 possible combinations => 10^4 => m^n
    //  For each combination, we are looping 4 times (which is n) and in each iteration, there are substring operations
    //  (which is O(n) * constant) => O(4n*constant) => O(4n) => O(nn) => O(n^2)
    //  space complexity: O(m*n = d); n: #dials in lock (4 letters)
    //                              m: #possibilities in each dial (0->9 i.e., 10)
    //                              d: #deadends
    //took 76 ms (78 percentile) and 46.7 MB (66 percentile)
    public int openLock2(String[] deadends, String target){
        int minMoves = 0;
        Queue<String> q = new LinkedList<>();
        Set<String> notDesired = new HashSet<>(Arrays.asList(deadends));
        q.offer("0000");

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String currP = q.poll();

                if(notDesired.contains(currP)) continue;
                if(currP.equals(target)) return minMoves;

                char[] currArr = currP.toCharArray();
                for(int j = 0; j < 4; j++){
                    char ch = currArr[j];
                    currArr[j] = ch == '9' ? '0' : (char)(ch + 1);
                    String s1 = new String(currArr);
                    if(!notDesired.contains(s1)) q.offer(s1);

                    currArr[j] = ch == '0' ? '9' : (char)(ch - 1);
                    String s2 = new String(currArr);
                    if(!notDesired.contains(s2)) q.offer(s2);

                    currArr[j] = ch;
                }
                notDesired.add(currP);
            }
            minMoves++;
        }
        return -1;
    }
}
