import java.util.*;

public class UniqueWordAbbreviation {

    //PROBLEM: Unique Word Abbreviation
    //  The abbreviation of a word is a concatenation of its first letter, the number of characters between the first
    //  and last letter, and its last letter. If a word has only two characters, then it is an abbreviation of itself.
    //For example:
    //dog --> d1g because there is one letter between the first letter 'd' and the last letter 'g'.
    //internationalization --> i18n because there are 18 letters between the first letter 'i' and the last letter 'n'.
    //it --> it because any word with only two characters is an abbreviation of itself.
    //Implement the ValidWordAbbr class:
    //ValidWordAbbr(String[] dictionary) Initializes the object with a dictionary of words.
    //boolean isUnique(string word) Returns true if either of the following conditions are met (otherwise returns false):
    //  There is no word in dictionary whose abbreviation is equal to word's abbreviation.
    //  For any word in dictionary whose abbreviation is equal to word's abbreviation, that word and word are the same.
    //Constraints:
    //  1 <= dictionary.length <= 3 * 104
    //  1 <= dictionary[i].length <= 20
    //  dictionary[i] consists of lowercase English letters.
    //  1 <= word.length <= 20
    //  word consists of lowercase English letters.
    //  At most 5000 calls will be made to isUnique.
    public static void main(String[] args) {
        ValidWordAbbr validWordAbbr = new ValidWordAbbr(new String[]{"deer", "door", "cake", "card"});
        System.out.println(validWordAbbr.isUnique("dear")); // return false, dictionary word "deer" and word "dear" have the same abbreviation "d2r" but are not the same.
        System.out.println(validWordAbbr.isUnique("cart")); // return true, no words in the dictionary have the abbreviation "c2t".
        System.out.println(validWordAbbr.isUnique("cane")); // return false, dictionary word "cake" and word "cane" have the same abbreviation  "c2e" but are not the same.
        System.out.println(validWordAbbr.isUnique("make")); // return true, no words in the dictionary have the abbreviation "m2e".
        System.out.println(validWordAbbr.isUnique("cake")); // return true, because "cake" is already in the dictionary and no other word in the dictionary has "c2e" abbreviation.
    }
}


// time complexity: O(n)
// space complexity: O(n)
//[HashMap] Use HashMap to store the key (first char + count + last char) as Key and the string as value. As soon as, a
//key is found existing we check if the string also matches the corresponding value.
//took 1941 ms (lintcode: 99.8 percentile) and 339.22 MB
class ValidWordAbbr {

    Map<String, String> map;
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();
        for(String s : dictionary){
            int n = s.length();
            String key = getKey(s);
            if(map.containsKey(key)) map.put(key, "");
            else map.put(key, s);
        }
    }

    public boolean isUnique(String word) {
        String key = getKey(word);
        if(map.containsKey(key)) return map.get(key).equals(word);
        return true;
    }
    public String getKey(String s){
        if(s.length() <= 2) return s;
        String key = s.charAt(0) + Integer.toString(s.length() - 2) + s.charAt(s.length() - 1);
        return key;
    }
}
