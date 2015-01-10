package com.peter.left.interview.epi.chapter15.t2;

import com.peter.left.interview.epi.chapter15.t1.Node;

public class IterativeSolution implements Solution
{
	@Override
	public Node search(final Node root, final int value)
	{
		Node o = root;
		while (o != null)
		{
			if (value < o.value)
			{
				o = o.left;
			}
			else if (o.value < value)
			{
				o = o.right;
			}
			else
			{
				for (; o.left != null && o.left.value == value; o = o.left)
				{
					
				}
				
				break;
			}
		}
		
		return o;
	}
}
