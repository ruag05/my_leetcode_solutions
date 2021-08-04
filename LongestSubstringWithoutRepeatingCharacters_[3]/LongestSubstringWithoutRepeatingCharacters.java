import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    //PROBLEM: Longest Substring Without Repeating Characters
    //  Given a string s, find the length of the longest substring without repeating characters.
    //Constraints:
    //  0 <= s.length <= 5 * 104
    //  s consists of English letters, digits, symbols and spaces

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    // time complexity: O(n)
    // space complexity: O(n)
    //Sliding window - store the characters with their latest index in HashMap and as soon as a repeating character is
    //found, find the latest index of that element in HashMap and remove all elements till that index, from hashmap
    //took 5 ms (79 percentile) and 38.9 MB (90 percentile)
    public static int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1) return s.length();

        Map<Character, Integer> map = new HashMap<>();
        int left = 0, maxLength = 0;
        int n = s.length();

        for(int right = 0; right < n; right++){
            if(map.containsKey(s.charAt(right)))
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            map.put(s.charAt(right), right);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
