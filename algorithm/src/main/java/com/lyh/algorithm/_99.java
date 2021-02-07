package com.lyh.algorithm;

import com.lyh.algorithm.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _99 {

    public void recoverTree(TreeNode<Integer> root) {
        Deque<TreeNode<Integer>> stack = new ArrayDeque<TreeNode<Integer>>();
        TreeNode<Integer> x = null, y = null, pred = null;
        TreeNode<Integer> cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (pred != null && cur.value < pred.value) {
                y = cur;
                if (x == null) {
                    x = pred;
                } else {
                    break;
                }
            }
            pred = cur;
            cur = cur.right;
        }

        swap(x, y);
    }

    public void swap(TreeNode<Integer> x, TreeNode<Integer> y) {
        int tmp = x.value;
        x.value = y.value;
        y.value = tmp;
    }

    public static void main(String[] args) {
        Deque<Integer> integers = new ArrayDeque<>();
        integers.push(2);
        integers.push(3);
        integers.push(4);

        System.out.println(integers.pop());
        System.out.println(integers);
    }
}
