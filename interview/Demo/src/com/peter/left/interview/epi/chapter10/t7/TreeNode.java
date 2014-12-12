package com.peter.left.interview.epi.chapter10.t7;

import lombok.ToString;

@ToString
public class TreeNode
{
    int value;
    TreeNode left;
    TreeNode right;
    
    TreeNode(final int value, final TreeNode left, final TreeNode right)
    {
        this.value = value;
        this.left = left;
        this.right = right;
    }
    
    TreeNode(final int value)
    {
        this(value, null, null);
    }
}
