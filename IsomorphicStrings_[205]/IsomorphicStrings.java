import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    //PROBLEM: Isomorphic Strings
    //  Given two strings s and t, determine if they are isomorphic.
    //  Two strings s and t are isomorphic if the characters in s can be replaced to get t.
    //  All occurrences of a character must be replaced with another character while preserving the order of characters.
    //  No two characters may map to the same character, but a character may map to itself
    //Constraints:
    //  1 <= s.length <= 5 * 104
    //  t.length == s.length
    //  s and t consist of any valid ascii character.

    public static void main(String[] args) {
        String s = "badc";
        String t = "baba";
        System.out.println(isIsomorphic2(s, t));
    }

    // time complexity: O(n)
    // space complexity: O(n)
    //[HashMap] Traverse both the strings, and using HashMap store the association of one character to another
    //character and as soon as we encounter any character that is already present as a Key or a Value, check if it
    //matches previous association
    // took 9 ms (57 percentile) and 39 MB (75 percentile)
    public static boolean isIsomorphic(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(n != m) return false;

        Map<Character, Character> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            if(map.containsKey(s.charAt(i))){
                if(map.get(s.charAt(i)) != t.charAt(i)) return false;
            } else if(map.containsValue(t.charAt(i))){
                for(Map.Entry<Character, Character> entry: map.entrySet()) {
                    if(entry.getValue() == t.charAt(i)) {
                        if(entry.getKey() != s.charAt(i)) return false;
                    }
                }
            }
            else map.put(s.charAt(i), t.charAt(i));
        }
        return true;
    }

    // time complexity: O(n)
    // space complexity: O(n)
    //[2 HashMap] Traverse both the strings, and using multiple HashMaps store the association of one character to another
    //character and vice-versa. As soon as we encounter any character that is already present as a Key or a Value,
    //check if it matches previous association
    //took 13 ms (38 percentile) and 39 MB (75 percentile)
    public static boolean isIsomorphic2(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(n != m) return false;

        Map<Character, Character> mapStoT = new HashMap<>();
        Map<Character, Character> mapTtoS = new HashMap<>();
        for(int i = 0; i < n; i++){
            char chS = s.charAt(i);
            char chT = t.charAt(i);
            if(!(mapStoT.containsKey(chS)) && !(mapTtoS.containsKey(chT))){
                mapStoT.put(chS, chT);
                mapTtoS.put(chT, chS);
            } else if(mapStoT.containsKey(chS) && mapStoT.get(chS) != chT) return false;
            else if(mapTtoS.containsKey(chT) && mapTtoS.get(chT) != chS) return false;
        }
        return true;
    }

    // time complexity: O(n)
    // space complexity: O(1) (size of ASCII characters is fixed)
    //[2 Arrays] Traverse both the strings, and using multiple arrays store the association of one character to another
    //character and vice-versa. As soon as we encounter any character who association does not match return false
    //took 3 ms (98 percentile) and 39 MB (45 percentile)
    public static boolean isIsomorphic3(String s, String t){
        int n = s.length();
        int m = t.length();
        if(n != m) return false;

        int[] mapStoT = new int[256];
        Arrays.fill(mapStoT, -1);

        int[] mapTtoS = new int[256];
        Arrays.fill(mapTtoS, -1);

        for(int i = 0; i < n; i++) {
            char chS = s.charAt(i);
            char chT = t.charAt(i);
            if(mapStoT[chS] == -1 && mapTtoS[chT] == -1) {
                mapStoT[chS] = chT;
                mapTtoS[chT] = chS;
            } else if(mapStoT[chS] != chT || mapTtoS[chT] != chS) return false;
        }

        return true;
    }

    // time complexity: O(n)
    // space complexity: O(n)
    //[HashMap and StringBuilder] Transform both the string by placing the index of their first occurrence at their place
    //and then compare both them. If they're isomorphic, the transformed string will also be the same
    //took 15 ms [32 percentile] and 39.8 MB (30 percentile)
    public static boolean isIsomorphic4(String s, String t){
        return transform(s).equals(transform(t));
    }
    public static String transform(String s){
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for(int i = 0; i < n; i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), i));
            sb.append(map.get(s.charAt(i)));
            sb.append(" ");
        }
        return sb.toString();
    }
}
