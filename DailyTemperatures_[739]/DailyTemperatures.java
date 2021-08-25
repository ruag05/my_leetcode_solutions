import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class DailyTemperatures {

    //PROBLEM: Daily Temperatures
    //  Given an array of integers temperatures represents the daily temperatures, return an array answer such that
    //  answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no
    //  future day for which this is possible, keep answer[i] == 0 instead.
    //Constraints:
    //  1 <= temperatures.length <= 105
    //  30 <= temperatures[i] <= 100

    public static void main(String[] args) {
        int[] temperatures = new int[]{73,74,75,71,69,72,76,73};
        for(int num : dailyTemperatures(temperatures))
            System.out.println(num);
    }

    // time complexity: O(n^2)
    // space complexity: O(1)
    //[Brute force] Using two for loops for each temperature, check if any of the ahead temperatures is higher
    //took 1118 ms (10 percentile) and 49.1 MB (46 percentile)
    public static int[] dailyTemperatures(int[] temperatures){
        int[] res = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++){
            for(int j = i + 1; j < temperatures.length; j++){
                if(temperatures[j] > temperatures[i]){
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }

    // time complexity: O(n)
    // space complexity: O(n)
    //[Stack] Iterate the temperatures from backwards and keep pushing them (along with their index) in stack. Also,
    //before pushing them check if the top temperature at stack is higher than the current temperature. If yes, calculate
    //the difference between the indexes else pop the colder temperature out of stock
    //took 44 ms (28 percentile) and 54.5 MB (16 percentile)
    public static int[] dailyTemperatures2(int[] temperatures){
        Stack<List<Integer>> stack = new Stack<>();
        int[] res = new int[temperatures.length];

        for(int i = temperatures.length - 1; i >= 0; i--){
            if(stack.isEmpty()) stack.push(Arrays.asList(temperatures[i], i));
            else{
                while(!stack.isEmpty()){
                    List<Integer> top = stack.peek();
                    if(top.get(0) > temperatures[i]){
                        res[i] = top.get(1) - i;
                        break;
                    }
                    else stack.pop();
                }
                stack.push(Arrays.asList(temperatures[i], i));
            }
        }
        return res;
    }

    // time complexity: O(n)
    // space complexity: O(n)
    //[Stack] Iterate the temperatures from backwards and keep pushing them (along with their index) in stack. Also,
    //before pushing them check if the top temperature at stack is higher than the current temperature. If yes, calculate
    //the difference between the indexes else pop the colder temperature out of stock
    //took 53 ms (24 percentile) and 54.4 MB (18 percentile)
    public static int[] dailyTemperatures3(int[] temperatures){
        Stack<List<Integer>> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for(int i = temperatures.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && stack.peek().get(0) <= temperatures[i]){
                stack.pop();
            }
            if(!stack.isEmpty() && stack.peek().get(0) > temperatures[i]){
                res[i] = stack.peek().get(1) - i;
            }
            stack.push(Arrays.asList(temperatures[i], i));
        }
        return res;
    }


    // time complexity: O(n)
    // space complexity: O(n)
    //[int array] Iterate the temperatures from front and keep adding them to array using a top variable. As soon as a
    //temperature with value greater than the temperature at the top is found, calculate the difference in indexes and
    //decrement the top variable(basically do pop operation)
    //took 12 ms (93 percentile) and 121.1 MB (6 percentile)
    public static int[] dailyTemperatures4(int[] temperatures){
        int[] stack = new int[temperatures.length];
        int[] res = new int[temperatures.length];
        int topIndex = -1;
        for(int i = 0; i < temperatures.length; i++){
            while(topIndex > -1 && temperatures[i] > temperatures[stack[topIndex]]){
                int index = stack[topIndex--];
                res[index] = i - index;
            }
            stack[++topIndex] = i;
        }
        return res;
    }
}
