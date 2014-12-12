package com.peter.left.interview.epi.chapter10.t5;

import lombok.ToString;

@ToString
public class TreeNode
{
    int value;
    TreeNode parent;
    TreeNode left;
    TreeNode right;
    
    TreeNode(final int value, final TreeNode parent, final TreeNode left, final TreeNode right)
    {
        this.value = value;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }
    
    TreeNode(final int value, final TreeNode parent)
    {
        this(value, parent, null, null);
    }
}
