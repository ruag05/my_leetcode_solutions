import java.util.HashMap;
import java.util.Map;

public class ClimbStair {

    //PROBLEM: Climbing Stairs
    //  You are climbing a staircase. It takes n steps to reach the top.
    //  Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
    //Constraints:
    //  1 <= n <= 45

    public static void main(String[] args) {
        System.out.println(climbStairs2(5));
    }

    //time complexity: O(2^n) - > throws TLE
    //space complexity: O(1) (ignoring system stack)
    //[recursion][brute force]
    int totalWays = 0;
    public int climbStairs(int n) {
        if(n == 1) return 1;
        helper(0, n);
        return totalWays;
    }
    public boolean helper(int stepsClimbed, int totalSteps){
        if(stepsClimbed >= totalSteps) return false;

        if (stepsClimbed + 1 == totalSteps){
            totalWays += 1;
            return true;
        } else if (stepsClimbed + 2 == totalSteps){
            totalWays += 2;
            return true;
        }

        helper(stepsClimbed + 1, totalSteps);
        helper(stepsClimbed + 2, totalSteps);

        return false;
    }

    //time complexity: O(2^n) - > throws TLE
    //space complexity: O(1) (ignoring system stack)
    //[recursion][optimized - brute force]
    public static int climbStairs2(int n) {
        return helper2(0, n);
    }
    public static int helper2(int stepsClimbed, int totalSteps){
        if(stepsClimbed > totalSteps) return 0;

        if (stepsClimbed == totalSteps){
            return 1;
        }
        return helper2(stepsClimbed + 1, totalSteps) + helper2(stepsClimbed + 2, totalSteps);
    }

    //time complexity: O(n)
    //space complexity: O(n)
    //[Recursion + Memoization]
    public int climbStairs3(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        return helper3(0, n, map);
    }
    public int helper3(int stepsClimbed, int totalSteps, Map<Integer, Integer> map){
        if(stepsClimbed > totalSteps) return 0;
        if(stepsClimbed == totalSteps) return 1;
        if(map.containsKey(stepsClimbed)) {
            return map.get(stepsClimbed);
        }
        map.put(stepsClimbed, helper3(stepsClimbed + 1, totalSteps, map) + helper3(stepsClimbed + 2, totalSteps, map));

        return map.get(stepsClimbed);
    }
}
