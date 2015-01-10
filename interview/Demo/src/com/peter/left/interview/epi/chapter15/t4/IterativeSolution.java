package com.peter.left.interview.epi.chapter15.t4;

import java.util.Stack;

import com.peter.left.interview.epi.chapter15.t1.Node;

public class IterativeSolution
{
	Node getKth(final Node root, final int k)
	{
		Node o = root;
		final Stack<Node> stack = new Stack<>();

		for (int i = -1; o != null || !stack.isEmpty(); )
		{
			if (o == null)
			{
				o = stack.pop();
				if (++i == k)
				{
					return o;
				}
				o = o.right;
			}
			else
			{
				if (o.left == null)
				{
					if (++i == k)
					{
						return o;
					}
					o = o.right;
				}
				else
				{
					stack.push(o);
					o = o.left;
				}
			}
		}
		
		return null;
	}
}
