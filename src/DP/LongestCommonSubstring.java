package DP;

// ques: https://www.geeksforgeeks.org/problems/longest-common-substring1452/1

public class LongestCommonSubstring {
    public int longCommSubstr(String s1, String s2) {
        String[][] dp = new String[s1.length()][s2.length()];

        String ans = "";

        for(int i=0; i< s1.length(); i++){
            for(int j=0; j<s2.length(); j++){
                if(s1.charAt(i) == s2.charAt(j)) {
                    if(i==0 || j==0)
                        dp[i][j] = String.valueOf(s1.charAt(i));
                    else if(dp[i-1][j-1] == null)
                        dp[i][j] = String.valueOf(s1.charAt(i));
                    else
                        dp[i][j] = dp[i - 1][j - 1] + s1.charAt(i);

                    if(dp[i][j].length() > ans.length())
                        ans = new String(dp[i][j]);
                }
            }
        }
        return ans.length();
    }

    public static void main(String[] args) {
        LongestCommonSubstring longestCommonSubstring = new LongestCommonSubstring();
        longestCommonSubstring.longCommSubstr("jqvdtcfzugvyk","xvnuyjqvdtcfzyy");
    }
}
