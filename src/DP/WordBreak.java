package DP;

// ques: https://leetcode.com/problems/word-break/description/

import java.util.*;

public class WordBreak {
    Boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new Boolean[s.length()];
        return dfs(s,0, wordDict);
    }

    private boolean dfs(String s, int idx ,List<String> wordDict) {
        if(idx  > s.length())
            return false;
        if(idx == s.length())
            return true;
        if(dp[idx] != null)
            return dp[idx];
        for(String st : wordDict){
            if(st.charAt(0) == s.charAt(idx) && s.length()-idx >= st.length() && s.substring(idx,idx+st.length()).equals(st))
                if(dfs(s, idx + st.length(), wordDict))
                    return dp[idx] = true;
        }
        return dp[idx]= false;
    }

    private boolean isEqual(String substring, String st) {
        if(substring.length() != st.length())
            return false;
        for(int i=0; i<substring.length(); i++){
            if(substring.charAt(i) != st.charAt(i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        System.out.println(wordBreak.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab" , new ArrayList<>(List.of("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"))));
    }

}
