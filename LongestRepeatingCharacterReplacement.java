public class LongestRepeatingCharacterReplacement {

    //PROBLEM: Longest Repeating Character Replacement
    //  You are given a string s and an integer k. You can choose any character of the string and change it to any
    //  other uppercase English character. You can perform this operation at most k times.
    //  Return the length of the longest substring containing the same letter you can get after performing the above
    //  operations.
    //Constraints:
    //  1 <= s.length <= 105
    //  s consists of only uppercase English letters.
    //  0 <= k <= s.length

    public static void main(String[] args){

    }

    // time complexity: O(n)
    // space complexity: O(n)
    //Sliding Window - Store the freq of each character and also keep track of the highest char freq encountered till now
    //Then, calculate the number of different characters till now and if they are greater than k, then remove the leftmost
    //element and moe the left pointer ahead
    //took 4 ms (95 percentile) and 39 MB (67 percentile)
    public int characterReplacement(String s, int k) {
        int maxLength = 0, left = 0, maxSeenFreq = 0, numDupChars = 0;
        int[] seenFreq = new int[26];
        char[] chars = s.toCharArray();

        for(int right = 0; right < chars.length; right++){
            //store/update the frequency of the character
            int c = chars[right] - 'A';
            seenFreq[c]++;

            //calculate the highest freq encountered till now
            maxSeenFreq = Math.max(maxSeenFreq, seenFreq[c]);

            //find the number of repeating characters
            numDupChars = (right - left + 1) - maxSeenFreq;

            //if #repeating characters are more than k, remove leftmost character
            if(numDupChars > k){
                seenFreq[chars[left] - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
