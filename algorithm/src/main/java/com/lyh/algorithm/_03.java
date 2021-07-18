package com.lyh.algorithm;

import java.util.HashMap;
import java.util.HashSet;

public class _03 {
    /**
     * 思路分析：哈希表  滑窗思想（双指针）
     * <p>
     * ①定义一个hashset存储已经统计过的字符。定义双指针，begin指向子串的头，end指向子串的尾，在遍历字符串中不断更新begin和end。定义一个count变量存储子串的最大长度。
     * <p>
     * ②首先判断str[end]是否存在hashset中，使用了set.contains(Object key)的方法。
     * <p>
     * =>如果不存在，就添加str[end]到set中，并将end后移。同时比较此时的子串长度与最大长度之间的关系取较大值。
     * <p>
     * =>如果存在，就将str[begin]从set中移除，并将begin后移。再次比较str[end]是否包含，循环直到将重复的那个元素移出set，此时begin应该指向重复元素的下一个位置。
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        char[] str = s.toCharArray();
        int start = 0;
        int end = 0;
        int count = 0;
        HashSet<Character> set = new HashSet<>();
        while (end < len && start < len) {
            if (set.contains(str[end])) {
                set.remove(str[start]);
                start++;
            } else {
                set.add(str[end]);
                count = Math.max(count, end - start + 1);
                end++;
            }
        }
        return count;
    }
}
