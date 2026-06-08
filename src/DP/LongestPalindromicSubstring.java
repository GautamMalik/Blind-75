package DP;

// ques: https://leetcode.com/problems/longest-palindromic-substring/description/

public class LongestPalindromicSubstring {
    Boolean[][] dp;
    String ans;
    public String longestPalindrome(String s) {
        dp = new Boolean[s.length()][s.length()];
        ans = "";
        for(int i=0; i<s.length(); i++){
           for(int j=i; j<s.length(); j++){
               if(j-i+1 > ans.length()) {
                   if (isPallimdrome(i, j, s))
                       ans = s.substring(i,j+1);
               }
           }
        }
        return ans;
    }

    private boolean isPallimdrome(int i, int j, String s) {
        if(i>=j)
            return dp[i][j] = true;

        if(dp[i][j] != null)
            return dp[i][j];

        if(s.charAt(i) != s.charAt(j))
            return dp[i][j] = false;

        return dp[i][j] = isPallimdrome(i+1,j-1,s);
    }


    public static void main(String[] args) {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        System.out.println(longestPalindromicSubstring.longestPalindrome("babad"));
    }
}
