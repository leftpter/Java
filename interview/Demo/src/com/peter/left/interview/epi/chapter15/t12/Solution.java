package com.peter.left.interview.epi.chapter15.t12;

import com.peter.left.interview.epi.chapter15.t1.Node;

public class Solution
{
	private Node head;
	private Node prev;
	
	private void inorder(final Node root)
	{
		if (root != null)
		{
			inorder(root.left);
			
			if (prev != null)
			{
				prev.left = root;
			}
			else
			{
				head = prev;
			}
			
			prev = root;
			
			inorder(root.right);
		}
	}
	
	Node convert(final Node root)
	{
		prev = null;
		head = null;
		inorder(root);
		for (Node o = head, previous = null; o != null; o = o.right)
		{
			o.right = o.left;
			o.left = previous;
			previous = o;
		}
		return head;
	}
}
