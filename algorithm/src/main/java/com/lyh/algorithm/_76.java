package com.lyh.algorithm;

public class _76 {


    public String minWindow(String s, String t) {
        int[] count = new int[256];
        for (char c : t.toCharArray()) {
            count[c]++;
        }
        int start = 0;
        int end = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        int counter = t.length();
        while (end < s.length()) {
            if (count[s.charAt(end)] > 0) {
                counter--;
            }
            count[s.charAt(end)]--;
            end++;
            while (counter == 0) {
                if (end - start < minLen) {
                    minStart = start;
                    minLen = end - start;
                }
                count[s.charAt(start)]++;
                if (count[s.charAt(start)] > 0) {
                    counter++;
                }
                start++;
            }
        }
        if (minLen == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(minStart, minStart + minLen);
    }
}
