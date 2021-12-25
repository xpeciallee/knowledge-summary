package com.lyh.algorithm.dynamic;

public class _198 {
    /**
     * 输入：[2,7,9,3,1]
     * 输出：12
     * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
     */

    public static int rob(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 1]);
        }
        return dp[arr.length - 1];
    }

    static int rob2(int[] nums) {
        int n = nums.length;
        int a = 0, b = nums[0];
        for (int i = 1; i < n; ++i) {
            int c = Math.max(nums[i] + a, b);
            a = b;
            b = c;
            System.out.println("a=" + a + " b=" + b);
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));
        System.out.println(rob2(new int[]{2, 7, 9, 3, 1}));
    }
}
