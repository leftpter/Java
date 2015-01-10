package com.peter.left.interview.epi.chapter15.t3;

import com.peter.left.interview.epi.chapter15.t1.Node;

public class IterativeSolution implements Solution
{
	@Override
	public Node geteSuccessor(final Node root,  final int value)
	{
		Node parent = null;
		
		Node o = root;
		while (o != null)
		{
			if (value < o.value)
			{
				parent = o;
				o = o.left;
			}
			else if (value > o.value)
			{
				o = o.right;
			}
			else
			{
				if (o.right == null)
				{
					o = parent;
				}
				else
				{
					o = o.right;
					while (o.left != null)
					{
						o = o.left;
					}
				}
				
				break;
			}
		}
		
		return o;
	}
}
