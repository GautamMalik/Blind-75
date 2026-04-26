package ArrayString.ManipulationAndHashing;
import java.util.*;


// ques: https://leetcode.com/problems/valid-anagram/description/

public class ValidAnagram {

    // same as better
    public boolean isAnagramMySol(String s, String t) {
        if(s.length()!=t.length())
            return false;

        Map<Character,Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(int i=0; i<t.length();i++){
            Integer temp = map.get(t.charAt(i));
            if(temp==null || temp==0)
                return false;
            map.put(t.charAt(i),temp-1);
        }
        return true;
    }

    public boolean isAnagramBruteForce(String s, String t) {
        if(s.length()!=t.length())
            return false;
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        Arrays.sort(arr1); Arrays.sort(arr2);
        for(int i=0; i<arr1.length; i++){
            if(arr1[i]!=arr2[i])
                return false;
        }
        return true;
    }
}
