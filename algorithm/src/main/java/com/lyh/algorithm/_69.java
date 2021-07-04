package com.lyh.algorithm;

public class _69 {
    public static void main(String[] args) {
        System.out.println(sqrt2(8));
        System.out.println(sqrt(8));
    }

    public static int sqrt(int n) {
        int left = 0, right = n;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (mid * mid > n) {
                right = (int) mid - 1;
            } else if (mid * mid < n) {
                left = (int) mid + 1;
            } else {
                return (int) mid;
            }
        }
        return right;
    }


    public static int sqrt2(int n) {
        int x = 0;
        while (true) {
            if (Math.pow(x, 2) < n) {
                x++;
            } else if (Math.pow(x, 2) > n) {
                return x - 1;
            } else {
                return x;
            }
        }
    }
}
