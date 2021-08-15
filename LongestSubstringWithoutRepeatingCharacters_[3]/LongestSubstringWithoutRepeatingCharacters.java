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
        System.out.println(lengthOfLongestSubstring3(s));
    }

    // time complexity: O(n)
    // space complexity: O(n)
    //Sliding window - store the characters with their latest index in HashMap and as soon as a repeating character is
    //found, find the latest index of that element in HashMap and move the left pointer ahead of that
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

    // time complexity: O(n)
    // space complexity: O(n)
    //[Sliding Window] Store the characters with their latest index in array and as soon as a repeating character is
    //found, find the latest index of that element in array and move the left pointer ahead of that
    //took 3 ms (90 percentile) and 38.8 MB (96 percentile)
    public static int lengthOfLongestSubstring2(String s) {
        Integer[] seen = new Integer[128];
        int n = s.length();
        int maxLength = 0;
        int left = 0;
        for(int right = 0; right < n; right++){
            char ch = s.charAt(right);
            if(seen[ch] != null) left = Math.max(seen[ch] + 1, left);
            seen[ch] = right;
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    // time complexity: O(n)
    // space complexity: O(n)
    //[Sliding Window] Store the characters with their latest index in array and as soon as a repeating character is
    //found, find the latest index of that element in array and move the left pointer ahead of that
    //took 2 ms (99.9 percentile) and 39 MB (72 percentile)
    public static int lengthOfLongestSubstring3(String s) {
        Integer[] totalCh = new Integer[128];

        int leftP = 0;
        int rightP = 0;

        int res = 0;
        while (rightP < s.length()) {
            char chR = s.charAt(rightP);

            Integer index = totalCh[chR];
            if (index != null && index >= leftP) {
                leftP = index + 1;
            }

            res = Math.max(res, rightP - leftP + 1);

            totalCh[chR] = rightP;
            rightP++;
        }

        return res;
    }
}
