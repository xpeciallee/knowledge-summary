package com.lyh.algorithm;

import com.lyh.algorithm.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class _105 {

    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i], i);
        }
        TreeNode root = helper(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1, map);
        return root;
    }

    private TreeNode helper(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd, Map<Integer, Integer> map) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preOrder[preStart]);
        int inRoot = map.get(preOrder[preStart]);
        int numsLeft = inRoot - inStart;
        root.left = helper(preOrder, preStart + 1, preStart + numsLeft, inOrder, inStart, inRoot - 1, map);
        root.right = helper(preOrder, preStart + numsLeft + 1, preEnd, inOrder, inRoot + 1, inEnd, map);
        return root;
    }
}
