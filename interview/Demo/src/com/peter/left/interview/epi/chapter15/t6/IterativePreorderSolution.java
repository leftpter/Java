package com.peter.left.interview.epi.chapter15.t6;

import java.util.Stack;

import com.peter.left.interview.epi.chapter15.t1.Node;
import lombok.ToString;
public class IterativePreorderSolution
{
	@ToString
	private static class Data
	{
		final int max;
		final Node node;
		
		Data(final int max, final Node node)
		{
			this.max = max;
			this.node = node;
		}
	}
	public Node construct(final int preorder[])
	{
		final Stack<Data> stack = new Stack<>();
		final Node root;
		if (preorder.length > 0)
		{
			root = new Node(preorder[0]);
			Node o = root;
			int min = Integer.MIN_VALUE;
			int max = Integer.MAX_VALUE;
			for (int i = 1; i < preorder.length; ++i)
			{
				final int value = preorder[i];
				// Left of current node.
				if (min <= value && value <= o.value)
				{
					// Right of current node.
					stack.push(new Data(max, o));
					o.left = new Node(value);
					max = o.value;
					o = o.left;
				}
				else
				{
					// Right of the node, its value must be larger than the value of the node,
					// But smaller than the max value.
					while (value < o.value || max < value)
					{
						final Data data = stack.pop();
						o = data.node;
						max = data.max;
					}
					
					o.right = new Node(value);
					min = o.value;
					o = o.right;
				}
			}
		}
		else
		{
			root = null;
		}
		return root;
	}
}
