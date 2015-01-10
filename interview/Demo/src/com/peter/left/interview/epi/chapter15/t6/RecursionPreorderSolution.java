package com.peter.left.interview.epi.chapter15.t6;

import com.peter.left.interview.epi.chapter15.t1.Node;

public class RecursionPreorderSolution
{
	private int index;
	
	private Node helper(final int preorder[], final int min, final int max)
	{
		if (index < preorder.length && min <= preorder[index] && preorder[index] <= max)
		{
			final Node root = new Node(preorder[index++]);
			root.left = helper(preorder, min, root.value);
			root.right = helper(preorder, root.value, max);
			return root;
		}
		else
		{
			return null;
		}
	}
	
	public Node construct(final int preorder[])
	{
		return helper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
}
