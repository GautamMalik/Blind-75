package DP;

// ques: https://leetcode.com/problems/decode-ways/description/

public class DecodeWays {
    Integer[] dp;

    public int numDecodings(String s) {
        dp = new Integer[s.length()];
        return dfs(0,s);
    }

    private int dfs(int idx, String s) {
        if(idx == s.length())
            return 0;

        if(s.charAt(idx) == '0')
            return 0;

        if(dp[idx] != null)
            return dp[idx];

        int takeOneDigit =  1+ dfs(idx + 1, s);
        int takeTwoDigits = 0;
        if (idx + 1 < s.length()) {
            int num = Integer.parseInt(s.substring(idx, idx + 2));
            if(num>=10 && num<=26)
                takeTwoDigits = 1 + dfs(idx + 2, s);

        }
        return dp[idx] = takeOneDigit + takeTwoDigits;
    }

    public static void main(String[] args) {
        DecodeWays decodeWays = new DecodeWays();
        System.out.println(decodeWays.numDecodings("226"));
    }

    /*
                226
               /   \
              2     22
            /  \     \
           2   26     6
          /
         6

         leaf node return 1 -> idx == s.length return 1
     */
}
