package com.lyh.algorithm;

public class _139 {

    public boolean wordBreak(String s, String[] breaks) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < s.length(); i++) {
            for (String word : breaks) {
                int len = word.length();
                if (i >= len && s.substring(i - len, i).equals(word)) {
                    dp[i] = dp[i] || dp[i - len];
                }
            }
        }
        return dp[s.length()];
    }
}
