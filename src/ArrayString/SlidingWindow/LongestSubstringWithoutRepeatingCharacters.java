package ArrayString.SlidingWindow;
import java.util.*;

// ques:

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int left=0, right=0;
        int ans=0, tempAns=0;
        while(right<s.length()){
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
            if(map.get(s.charAt(right))>1){
                while (map.get(s.charAt(right)) > 1) {
                    map.put(s.charAt(left),map.get(s.charAt(left))-1);
                    left++;
                }
                tempAns=right-left+1;
            } else{
                tempAns++;
            }
            ans = Math.max(ans,tempAns);
            right++;
        }
        return ans;
    }

    public int lengthOfLongestSubstringUsingSet(String s) {
        int left=0;
        int ans=0;
        Set<Character> set = new HashSet<>();
        for(int right=0; right<s.length(); right++){
            if(set.contains(s.charAt(right))){
                while(set.contains(s.charAt(right))){
                    set.remove(s.charAt(left));
                    left++;
                }
            }
            set.add(s.charAt(right));
            ans = Math.max(ans,right-left+1);
        }
        return ans;
    }

    public int lengthOfLongestSubstringThierSolution(String s) {
        Map<Character, Integer> charIndexMap = new HashMap<>();
        int maxLength = 0, left = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            if (charIndexMap.containsKey(currentChar) && charIndexMap.get(currentChar) >= left) {
                left = charIndexMap.get(currentChar) + 1;
            }
            charIndexMap.put(currentChar, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
        l.lengthOfLongestSubstring("pwwkew");
    }
}
