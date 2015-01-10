package com.peter.left.interview.epi.chapter15.t3;

import com.peter.left.interview.epi.chapter15.t1.Node;

public class RecursiveSolution implements Solution
{
	private Node current;
	private Node helper(final Node root, final int value)
	{
		if (root == null)
		{
			return null;
		}
		
		final Node left = helper(root.left, value);
		if (left != null)
		{
			return left;
		}
		
		if (current != null)
		{
			return root;
		}
		else if (root.value == value)
		{
			current = root;
		}
		
		return helper(root.right, value);
	}
	
	@Override
	public Node geteSuccessor(final Node root,  final int value)
	{
		current = null;
		return helper(root, value);
	}
}
