package com.peter.left.interview.epi.chapter15.t4;

import com.peter.left.interview.epi.chapter15.t1.Node;

public class Solution
{
	private int num;
	
	private Node helper(final Node root, final int k)
	{
		if (root != null)
		{
			final Node left = helper(root.left, k);
			
			if (left != null)
			{
				return left;
			}
			else if (num == k)
			{
				return root;
			}
			else
			{
				++num;
				return helper(root.right, k);
			}
		}
		
		return null;
	}
	
	Node getKth(final Node root, final int k)
	{
		if (k >= 0)
		{
			num = 0;
			return helper(root, k);
		}
		else
		{
			return null;
		}
	}
}
