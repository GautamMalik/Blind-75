package ArrayString.SlidingWindow;

import java.util.*;

// ques: https://leetcode.com/problems/minimum-window-substring/description/

/*

Integer a = 128;
Integer b = 128;

System.out.println(a == b);  // false

 */

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (t.length() > s.length())
            return "";
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int need = tMap.size(), have = 0;
        String ans = "";

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
            if (tMap.containsKey(c) && sMap.get(c).equals(tMap.get(c)))
                have++;

            while (left <= right && need == have) {
                char leftChar = s.charAt(left);
                int currWindow = right - left + 1;

                if (currWindow < minLength) {
                    minLength = currWindow;
                    ans = s.substring(left, right + 1);
                }
                sMap.put(leftChar, sMap.get(leftChar) - 1);
                if (tMap.containsKey(leftChar) && sMap.get(leftChar) < tMap.get(leftChar)) {
                    have--;
                }
                left++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        System.out.println("Ans: " + minimumWindowSubstring.minWindow("aa", "aa"));
    }
}




