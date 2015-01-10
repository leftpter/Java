package com.peter.left.interview.epi.chapter15.t6;

import com.peter.left.interview.epi.chapter15.t1.Node;

public class PreorderSolution
{
	private void add(final Node root, final int value)
	{
		Node o = root;
		while (o != null)
		{
			if (value < o.value)
			{
				if (o.left == null)
				{
					o.left = new Node(value);
					break;
				}
				else
				{
					o = o.left;
				}
			}
			else
			{
				if (o.right == null)
				{
					o.right = new Node(value);
					break;
				}
				else
				{
					o = o.right;
				}
			}
		}
	}
	
	
	public Node construct(final int preorder[])
	{
		if (preorder.length > 0)
		{
			final Node root = new Node(preorder[0]);
			
			for (int i = 1; i < preorder.length; ++i)
			{
				add(root, preorder[i]);
			}
			
			return root;
		}
		else
		{
			return null;
		}
	}
}
