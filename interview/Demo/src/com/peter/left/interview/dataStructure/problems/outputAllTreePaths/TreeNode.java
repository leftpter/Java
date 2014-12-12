package com.peter.left.interview.dataStructure.problems.outputAllTreePaths;

public class TreeNode<E>
{
    private final E value;
    private final TreeNode<E> left;
    private final TreeNode<E> right;
    
    public TreeNode(final E value, final TreeNode<E> left, TreeNode<E> right)
    {
        this.value = value;
        this.left = left;
        this.right = right;
    }
    
    public TreeNode(final E value)
    {
        this(value, null, null);
    }
    
    public E getValue()
    {
        return value;
    }
    
    public TreeNode<E> getLeft()
    {
        return left;
    }
    
    public TreeNode<E> getRight()
    {
        return right;
    }
}
