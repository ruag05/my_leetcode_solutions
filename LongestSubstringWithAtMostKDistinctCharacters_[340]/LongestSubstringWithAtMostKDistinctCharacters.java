import java.util.*;

public class LongestSubstringWithAtMostKDistinctCharacters {

    //PROBLEM:
    //  Given a string s and an integer k, return the length of the longest substring of s that contains at most k
    //  distinct characters.
    //Constraints:
    //  1 <= s.length <= 5 * 104
    //  0 <= k <= 50

    public static void main(String[] args) {
        String s = "eqgkcwGFvjjmxutystqdfhuMblWbylgjxsxgnoh";
        System.out.println(lengthOfLongestSubstringKDistinct(s, 16));
    }

    // time complexity: O(n)
    // space complexity: O(n)
    //took 503 ms (70 percentile) and 22.3 MB
    //Uses hashmap to store the index of rightmost of each element. So, as soon as the #elements in window increase from
    //k, then we can remove the proper leftmost element, so that #distinct elements in window again become equal to k
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s.length() == 0 || k == 0) return 0;

        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, maxLength = 0;

        while(right < s.length()){
            //store character along with its rightmost position
            map.put(s.charAt(right), right++);
            maxLength ++;
            if(map.size() == k + 1){
                //remove leftmost element
                int index = Collections.min(map.values());
                map.remove(s.charAt(index));
                //slide the window
                left = index + 1;
            }
            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }
}
