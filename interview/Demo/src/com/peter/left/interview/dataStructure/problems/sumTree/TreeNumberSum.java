package com.peter.left.interview.dataStructure.problems.sumTree;

public class TreeNumberSum
{
    private int sum(final TreeNode root, final int value)
    {
        assert root != null : "root must not be null";
        
        final int sum;
        final int nodeValue = value * 10 + root.getValue();
        
        if (root.getLeft() == null && root.getRight() == null)
        {
            sum = nodeValue;
        }
        else
        {
            final int leftSum = (root.getLeft() == null) ? 0 : sum(root.getLeft(), nodeValue);
            final int rightSum = (root.getRight() == null) ? 0 : sum(root.getRight(), nodeValue);
            sum = leftSum + rightSum;
        }
        
        return sum;
    }
    
    public int sum(final TreeNode root)
    {
        return (root == null) ? 0 : sum(root, 0);
    }
}
