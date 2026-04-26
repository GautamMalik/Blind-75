package ArrayString.SlidingWindow;

// ques:

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>(); // freq Map
        int maxFreq = 0; // max freq count of freq map
        int ans = 0;

        int left = 0, right = 0;
        while (right < s.length()) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1); // updating freq by 1
            maxFreq = Math.max(maxFreq, map.get(s.charAt(right)));

            if ((right-left+1) - maxFreq > k) {  // shirinking window size
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                left++;
            }
            ans = Math.max(ans, right - left+1);
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement longestRepeatingCharacterReplacement = new LongestRepeatingCharacterReplacement();
        longestRepeatingCharacterReplacement.characterReplacement("AAAB", 0);
    }
}
