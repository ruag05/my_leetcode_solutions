import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubString {

    //PROBLEM: Minimum Window Substring
    //  Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that
    //  every character in t (including duplicates) is included in the window. If there is no such substring, return
    //  the empty string "".
    //  The testcases will be generated such that the answer is unique.
    //  A substring is a contiguous sequence of characters within the string.
    //Constraints:
    //  m == s.length
    //  n == t.length
    //  1 <= m, n <= 105
    //  s and t consist of uppercase and lowercase English letters.

    public static void main(String[] args) {
        String s = "a";
        String t = "aa";
        System.out.println("Result is : " + minWindow(s, t));
    }

    // time complexity: O(m + n)
    // space complexity: O(m + n)
    //[Sliding Window] Store the target characters and their freq in a map (will be used to check how many of them are
    //present in the window). Traverse the given string from left to right and keep moving right pointer until the
    //window has all the required characters along with the required frequency. As soon as the requirement is met, we
    //stop the right pointer and start incrementing the left pointer, until the freq of a needed character goes below
    //the required frequency.
    //took 13 ms (46 percentile) and 39.9 MB (35 percentile)
    public static String minWindow(String s, String t){
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();
        int m = s.length();
        int n = t.length();
        int counter = 0;
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;

        //store t string characters and their frequency
        for(int i = 0; i < n; i++)
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);

        String res = "";
        for(right = 0; right < m; right++){
            char chR = s.charAt(right);
            mapS.put(chR, mapS.getOrDefault(chR, 0) + 1);
            if(mapS.get(chR) <= mapT.getOrDefault(chR, 0)) counter++;
            while(counter == n){
                char chL = s.charAt(left);

                if(right - left + 1 < minLen){
                    minLen = right - left + 1;
                    if(left == 0) res = s.substring(left, right + 1);
                    else res = s.substring(left, left + minLen);
                }
                if(!mapT.containsKey(chL) || mapS.get(chL) > mapT.get(chL)){
                   mapS.put(chL, mapS.get(chL)- 1);
                } else if(mapT.containsKey(chL)){
                    counter--;
                    mapS.put(chL, mapS.get(chL)- 1);
                }
                left++;
            }
        }

        return res;
    }
}
