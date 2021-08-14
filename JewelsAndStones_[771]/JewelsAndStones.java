import java.util.Arrays;

public class JewelsAndStones {

    //PROBLEM: Jewels and Stones
    //  You're given strings jewels representing the types of stones that are jewels, and stones representing the stones
    //  you have. Each character in stones is a type of stone you have. You want to know how many of the stones you have
    //  are also jewels.
    //  Letters are case sensitive, so "a" is considered a different type of stone from "A".
    //Constraints:
    //  1 <= jewels.length, stones.length <= 50
    //  jewels and stones consist of only English letters.
    //  All the characters of jewels are unique.
    public static void main(String[] args) {
        String jewels = "aA";
        String stones = "aAAbbbb";
        System.out.println(numJewelsInStones(jewels, stones));
    }
    // time complexity: O(n + m)
    // space complexity: O(1)
    //[boolean array]Store the presence of each character in jewels in a boolean array. Then, traverse the stones array
    //to check if the character is already seen in boolean array. If yes, increment the result pointer
    //took 0 ms (100 percentile) and 37.4 MB (53 percentile)
    public static int numJewelsInStones(String jewels, String stones) {
        boolean[] seenJ = new boolean[64];

        char[] charsJ = jewels.toCharArray();
        for(char ch : charsJ)
            seenJ[ch - 'A'] = true;
        char[] charsS = stones.toCharArray();
        int res = 0;
        for(char ch : charsS){
            if(seenJ[ch - 'A']) res++;
        }
        return res;
    }
}

