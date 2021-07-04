package com.lyh.algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Test {


    public void preOrder(TreeNode<Integer> root){

        Stack<TreeNode<Integer>> stack=new Stack<>();
        List<Integer> res=new ArrayList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode<Integer> cur=stack.pop();
            res.add(cur.value);
            if(cur.right!=null){
                stack.push(cur.right);
            }
            if(cur.left!=null){
               stack.push(cur.left);
            }
        }
    }

    public void inOrder(TreeNode<Integer> root){
        Stack<TreeNode<Integer>> stack=new Stack<>();
        List<Integer> res=new ArrayList<>();
        TreeNode<Integer> cur=root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.value);
            cur = cur.right;
        }
    }
}
