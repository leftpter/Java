package com.peter.left.interview.dataStructure.problems.commonRoot;

import java.util.ArrayList;
import java.util.List;

public class Solution
{
    void preorder(final TreeNode root, final List<Integer> order)
    {
        if (root != null)
        {
            order.add(root.value);
            preorder(root.left, order);
            preorder(root.right, order);
        }
    }
    
    void postorder(final TreeNode root, final List<Integer> order)
    {
        if (root != null)
        {
            postorder(root.left, order);
            postorder(root.right, order);
            order.add(root.value);
        }
    }
    
    TreeNode fromValue(final int value, final TreeNode root)
    {
        if (root != null)
        {
            if (root.value == value)
            {
                return root;
            }
            else
            {
                 final TreeNode node = fromValue(value, root.left);
                 return (node == null) ? fromValue(value, root.right) : node;
            }
        }
        
        return null;
    }
    
    TreeNode LCA(final TreeNode root, final int val1, final int val2)
    {
        final List<Integer> preorder = new ArrayList<>();
        preorder(root, preorder);
        final int val1Pos = preorder.indexOf(val1);
        final int val2Pos = preorder.indexOf(val2);
        if (val1Pos == -1 || val2Pos == -1)
        {
            return null;
        }
        final List<Integer> preorderList = preorder.subList(0, Math.min(val1Pos, val2Pos) + 1);
        final List<Integer> postorder = new ArrayList<>();
        postorder(root, postorder);
        final List<Integer> postorderList =
                postorder.subList(Math.max(postorder.indexOf(val1), postorder.indexOf(val2)), postorder.size());
        
        for (final Integer val : postorderList)
        {
            if (preorderList.contains(val))
            {
                return fromValue(val, root);
            }
        }
        
        return null;
    }
}
