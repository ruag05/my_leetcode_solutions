import java.util.*;

public class GroupAnagrams {

    //PROBLEM: Group Anagrams
    //  Given an array of strings strs, group the anagrams together. You can return the answer in any order.
    //  An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using
    //  all the original letters exactly once.
    //Constraints:
    //  1 <= strs.length <= 104
    //  0 <= strs[i].length <= 100
    //  strs[i] consists of lower-case English letters

    public static void main(String[] args) {
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        for(List<String> list : groupAnagrams(strs)) {
            System.out.print("[");
            for (String s : list)
                System.out.print(s + ", ");
            System.out.println("]");
        }
    }

    // time complexity: O(n)
    // space complexity: O(n)
    //[HashMap] Traverse the input array and transform each string into a list of integers where each position represents
    //the freq of the character for that string. For each transformed string, check if the same list of integers is present
    //took 20 ms (16 percentile) and 53 MB (7 percentile)
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<List<Integer>, List<String>> map = new HashMap<>();
        for(String s : strs){
            List<Integer> curr = transform(s);
            if(map.containsKey(curr)) map.get(curr).add(s);
            else{
                List<String> newGrp = new ArrayList<>();
                newGrp.add(s);
                map.put(curr, newGrp);
            }
        }

        return new ArrayList<>(map.values());
    }
    public static List<Integer> transform(String s){
        int n = s.length();
        Integer[] arr = new Integer[26];
        for(int i = 0; i < n; i++){
            arr[s.charAt(i) - 'a'] = arr[s.charAt(i) - 'a'] == null ? 1 : arr[s.charAt(i) - 'a'] + 1;
        }
        return Arrays.asList(arr);
    }

    // time complexity: O(n)
    // space complexity: O(n)
    //[HashMap] Traverse the array and sort each of them. Post sorting check if the HashMap already contains the sorted
    //string as key
    //took 6 ms (77 percentile) and 41.9 MB (84 percentile)
    public static List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            if(!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
