package com.lyh.algorithm;

public class _01 {

    public static boolean isPowerOfTwo(int n) {


        int i = 0;
        while (true) {
            double num = Math.pow(2, i);
            if (num == n) {
                return true;
            } else if (num < n) {
                i++;
            }else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(8));
        System.out.println(isPowerOfTwo(5));
    }

}
