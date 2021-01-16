package com.lyh.algorithm;

public class _135 {

    public int totalCandy(int[] scores) {
        int[] candy = new int[scores.length];
        for (int i = 0; i < candy.length; i++) {
            candy[i] = 1;
        }
        for (int i = 0; i < scores.length - 1; i++) {
            if (scores[i] < scores[i + 1]) {
                candy[i + 1] = candy[i] + 1;
            }
        }

        for (int i = scores.length - 1; i > 0; i--) {
            if (scores[i] < scores[i - 1]) {
                candy[i - 1] = Math.max(candy[i], candy[i - 1] + 1);
            }
        }
        int sum = 0;
        for (int i = 0; i < candy.length; i++) {
            sum += candy[i];
        }
        return sum;
    }
}
