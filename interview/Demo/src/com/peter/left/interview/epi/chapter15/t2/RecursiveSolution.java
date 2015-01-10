package com.peter.left.interview.epi.chapter15.t2;

import com.peter.left.interview.epi.chapter15.t1.Node;

public class RecursiveSolution implements Solution
{

	@Override
	public Node search(final Node root, final int value)
	{
		if (null == root)
		{
			return null;
		}
		else
		{
			if (value < root.value)
			{
				return search(root.left, value);
			}
			else if (root.value == value)
			{
				final Node left = search(root.left, value);
				return (left == null) ? root : left;
			}
			else
			{
				return search(root.right, value);
			}
		}
	}

}
