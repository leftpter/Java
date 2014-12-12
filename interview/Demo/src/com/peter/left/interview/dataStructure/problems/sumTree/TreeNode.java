package com.peter.left.interview.dataStructure.problems.sumTree;

public class TreeNode
{
    private int value;
    private TreeNode left;
    private TreeNode right;
    
    public TreeNode(final int value, final TreeNode left, final TreeNode right)
    {
        this.value = value;
        this.left = left;
        this.right = right;
    }
    
    public int getValue()
    {
        return value;
    }
    
    public TreeNode getLeft()
    {
        return left;
    }
    
    public TreeNode getRight()
    {
        return right;
    }
}
