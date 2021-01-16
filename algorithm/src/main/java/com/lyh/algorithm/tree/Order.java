package com.lyh.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Order {

    //    1
    //  3    5
    //6  7  8  9
    public static void preOrderTravalWithStackV2(TreeNode root) {
        ArrayList res = new ArrayList();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur = null;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            res.add(cur.value);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        System.out.println(res);
    }


    public List inorderTraversal_not(TreeNode root) {
        List res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.value);
            curr = curr.right;
        }
        return res;
    }

    public List postorderTraversal(TreeNode<Integer> root) {
        LinkedList<TreeNode<Integer>> stack = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode<Integer> node = stack.pollLast();
            res.addFirst(node.value);
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }
        return res;
    }

//##################################################################
    public List preorderTraversal(TreeNode root) {
        List result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        preorder(root, result);
        return result;
    }

    private static List preorder(TreeNode root, List result) {
        if (root != null) {
            result.add(root.value);
            preorder(root.left, result);
            preorder(root.right, result);
        }
        return result;
    }

    public List inorderTraversal(TreeNode root) {
        List result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result = inorder(root, result);
        return result;
    }

    private static List inorder(TreeNode root, List result) {
        if (root != null) {
            inorder(root.left, result);
            result.add(root.value);
            inorder(root.right, result);
        }
        return result;
    }

    /**
     * 层序遍历树
     */
    public static void levelOrderTraval(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        queue.offer(root);
        TreeNode<Integer> cur = null;
        while (!queue.isEmpty()) {
            cur = queue.removeFirst();
            res.add(cur.value);
            if (cur.left != null) {
                queue.addLast(cur.left);
            }
            if (cur.right != null) {
                queue.addLast(cur.right);
            }
        }
        System.out.println(res);
    }


}



