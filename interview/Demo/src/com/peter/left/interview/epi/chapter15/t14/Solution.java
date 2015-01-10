package com.peter.left.interview.epi.chapter15.t14;

import com.peter.left.interview.epi.chapter15.t1.Node;

public class Solution
{
	Node insert(final Node root, final int value)
	{
		if (null == root)
		{
			return new Node(value);
		}
		Node o = root;
		while (null != o)
		{
			if (o.value == value)
			{
				throw new IllegalArgumentException("Value exist :" + value);
			}
			else if (value < o.value)
			{
				if (null == o.left)
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
				if (null == o.right)
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
		return root;
	}
	
	Node remove(final Node root, final int value)
	{
		if (null == root)
		{
			return null;
		}
		else
		{
			final Node newRoot;
			
			if (Integer.MAX_VALUE == value)
			{
				newRoot = new Node(Integer.MIN_VALUE);
				newRoot.right = root;
			}
			else
			{
				newRoot = new Node(Integer.MAX_VALUE);
				newRoot.left = root;
			}
			
			for (Node o = root, parent = newRoot; o != null; )
			{
				if (value == o.value)
				{
					if (null == o.left || null == o.right)
					{
						if (o == parent.left)
						{
							parent.left = (null == o.left) ? o.right : o.left;
						}
						else
						{
							parent.right = (null == o.left) ? o.right : o.left;
						}
					}
					else
					{
						if (o == parent.left)
						{
							parent.left = o.right;
						}
						else
						{
							parent.right = o.right;
						}
						
						if (o.right.left == null)
						{
							o.right.left = o.left;
						}
						else
						{
							Node prev;
							for (prev = o.left; prev.right != null; prev = prev.right)
							{
								
							}
							
							prev.right = o.right.left;
							o.right.left = o.left;
						}
					}
					
					break;
				}
				else if (value < o.value)
				{
					parent = o;
					o = o.left;
				}
				else
				{
					parent = o;
					o = o.right;
				}
			}
			
			return (newRoot.left == null) ? newRoot.right : newRoot.left;
		}
	}
	
}
