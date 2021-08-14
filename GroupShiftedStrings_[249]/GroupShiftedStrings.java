import java.util.*;

public class GroupShiftedStrings {

    //PROBLEM: Group Shifted Strings
    //  We can shift a string by shifting each of its letters to its successive letter.
    //  For example, "abc" can be shifted to be "bcd".
    //  We can keep shifting the string to form a sequence.
    //  For example, we can keep shifting "abc" to form the sequence: "abc" -> "bcd" -> ... -> "xyz".
    //  Given an array of strings strings, group all strings[i] that belong to the same shifting sequence. You may
    //  return the answer in any order
    //Constraints:
    //  1 <= strings.length <= 200
    //  1 <= strings[i].length <= 50
    //  strings[i] consists of lowercase English letters

    public static void main(String[] args) {
        String[] strings = {"az","abc","bcd","acef","xyz","ba","a","z"};
        for(List<String> list : groupStrings(strings)){
            for(String s : list)
                System.out.println(s);
        }
    }

    // time complexity: O(n)
    // space complexity: O(n)
    //[HashMap] For each string, calculate the difference between its characters and store it as key and the string as
    //value. If we come across the set of differences for another string, then append that string to value
    //took 2 ms (64 percentile) and 39.2 MB (70 percentile)
    public static List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strings) {
            int n = s.length();
            char prev = s.charAt(0);
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < n; i++) {
                char ch = s.charAt(i);
                int gap = ch - prev;
                if (gap < 0)
                    gap += 26;
                sb.append(gap);
                sb.append(" ");
                prev = ch;
            }
            List<String> st = map.getOrDefault(sb.toString(), new ArrayList<>());
            st.add(s);
            map.put(sb.toString(), st);
        }
        return new ArrayList<>(map.values());
    }
}
