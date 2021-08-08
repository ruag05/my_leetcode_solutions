import java.util.*;

public class FindAllAnagramsInAString {

    //PROBLEM: Find All Anagrams in a String
    //  Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the
    //  answer in any order.
    //Constraints:
    //  1 <= s.length, p.length <= 3 * 104
    //  s and p consist of lowercase English letters.
    public static void main(String[] args) {
        String s = "abcabc";
        String p = "ac";
        for(int i : findAnagrams2(s,p))
            System.out.println(i);
    }

    // time complexity: O(n + m)
    // space complexity: O(1) (as the mapS and mapP will never go beyond 26 size (as input is english characters only)
    //[Sliding Window] Store the characters with their frequency in a HashMap. Then, traverse the main string and build
    //HashMap for characters encountered till now and keep checking whether the two hashmaps are same. Then, as soon as
    //the right index has passed m characters, remove the mth characters (in left) from the right index.
    //took 400 ms (lintcode: 22 percentile)
    public static List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int m = p.length();
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapP = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < m; i++)
            mapP.put(p.charAt(i), mapP.getOrDefault(p.charAt(i), 0) + 1);

        for(int right = 0; right < n; right++) {
            char chR = s.charAt(right);
            mapS.put(chR, mapS.getOrDefault(chR, 0) + 1);

            //remove the 4th element from the right
            if(right >= m){
                char chL = s.charAt(right - m);
                if(mapS.get(chL) == 1) mapS.remove(chL);
                else mapS.put(chL, mapS.get(chL) - 1);
            }

            if(mapS.equals(mapP))
                res.add(right - m + 1);
        }

        return res;
    }

    // time complexity: O(n + m)
    // space complexity: O(n + m)
    //[Sliding Window] Store the characters with their frequency in an array. Then, traverse the main string and build
    //array for characters encountered till now and keep checking whether the two arrays are same. Then, as soon as
    //the right index has passed m characters, remove the mth characters (in left) from the right index.
    //took 281 ms (lintcode: 98 percentile)
    public static List<Integer> findAnagrams2(String s, String p) {
        int n = s.length();
        int m = p.length();

        int[] arrS = new int[26];
        int[] arrP = new int[26];
        List<Integer> res = new ArrayList<>();

        for(char ch : p.toCharArray())
            arrP[ch - 'a']++;

        for(int right = 0; right < n; right++){
            char chR = s.charAt(right);
            arrS[chR - 'a']++;

            if(right >= m){
                char chL = s.charAt(right - m);
                arrS[chL - 'a']--;
            }

            if(Arrays.equals(arrS, arrP))
                res.add(right - m + 1);
        }

        return res;
    }
}
