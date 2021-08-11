import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacter {

    //PROBLEM: First Unique Character in a String
    //  Given a string s, find the first non-repeating character in it and return its index. If it does not exist,
    //  return -1.
    //Constraints:
    //  1 <= s.length <= 105
    //  s consists of only lowercase English letters.

    public static void main(String[] args) {

    }
    // time complexity: O(n)
    // space complexity: O(1)
    //[HashMap] Uses HashMap to store characters and its freq. Traverse the string again and check in array which first
    //character has frequency: 1
    //took 21 ms (58 percentile) and 39.5 MB (49 percentile)
    public static int firstUniqChar(String s) {
        int n = s.length();
        Map<Character, Integer> seen = new HashMap<>();
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            seen.put(ch, seen.getOrDefault(ch, 0) + 1);
        }
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(seen.get(ch) == 1) return i;
        }

        return -1;
    }

    // time complexity: O(n)
    // space complexity: O(1)
    //[Array] Uses array to store freq of the characters. Traverse the string again and check in array which first
    //character has frequency: 1
    //took 6 ms (80 percentile) and 39.4 MB (76 percentile)
    public static int firstUniqChar2(String s) {
        int n = s.length();
        int[] seen = new int[26];
        for(int i = 0; i < n; i++)
            seen[i]++;
        for(int i = 0; i < n; i++)
            if(seen[i] == 1) return i;
        return -1;
    }
}
